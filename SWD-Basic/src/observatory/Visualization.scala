package observatory

import scala.math.{ acos, sin, cos, toRadians, pow, round }
import com.sksamuel.scrimage.{ Image, Pixel }
import scala.collection.parallel.ParSeq
import scala.collection.parallel.ParIterable

/**
 * 2nd milestone: basic visualization
 */
object Visualization {

  val P = 6
  val MIN_DISTANCE = 1 // Km
  val EARTH_RADIUS = 6367 // Km
  val IMAGE_WIDTH = 360
  val IMAGE_HEIGHT = 180
  val ALPHA = 255

  def w(distance: Double): Double = {
    1 / pow(distance, P)
  }

  // Great-Circle distance formula
  def gcd(from: Location, to: Location): Double = {
    val fromLat = toRadians(from.lat)
    val toLat = toRadians(to.lat)
    val delta = toRadians(to.lon - from.lon)

    val sigma = acos(sin(fromLat) * sin(toLat) + cos(fromLat) * cos(toLat) * cos(delta))

    sigma * EARTH_RADIUS
  }

  /**
   * @param temperatures Known temperatures: pairs containing a location and the temperature at this location
   * @param location Location where to predict the temperature
   * @return The predicted temperature at `location`
   */
  def predictTemperature(temperatures: Iterable[(Location, Temperature)], location: Location): Temperature = {
    def loop_predict(temperatures: List[(Location, Temperature)], accW: Double, acc: Double): Temperature = temperatures match {
      case Nil => if (acc == 0) 0 else accW / acc
      case (loc, tem) :: t => {
        val distance = gcd(loc, location)
        if (distance <= MIN_DISTANCE)
          tem
        else {
          val wVal = w(distance)
          loop_predict(t, accW + (wVal * tem), acc + wVal)
        }
      }
    }

    loop_predict(temperatures.toList, 0.0d, 0.0d)
  }

  def linearInterpolation(color0: Int, color1: Int, t: Temperature): Int = {
    round(color0 + (color1 - color0) * t).toInt
  }

  def calculateInColor(p0: (Temperature, Color), p1: (Temperature, Color), value: Temperature): Color = {
    val t = (value - p0._1) / (p1._1 - p0._1)

    Color(
      linearInterpolation(p0._2.red, p1._2.red, t),
      linearInterpolation(p0._2.green, p1._2.green, t),
      linearInterpolation(p0._2.blue, p1._2.blue, t))
  }

  /**
   * @param points Pairs containing a value and its associated color
   * @param value The value to interpolate
   * @return The color that corresponds to `value`, according to the color scale defined by `points`
   */
  def interpolateColor(points: Iterable[(Temperature, Color)], value: Temperature): Color = {
    points.find(_._1 == value) match {
      case Some((_, color)) => color
      case None => {
        val (lower, higher) = points.toList.sortBy(_._1).partition(_._1 < value)
        val (pair0, pair1) = (lower.lastOption, higher.headOption)
        (pair0, pair1) match {
          case (Some(pair0), None) => pair0._2
          case (None, Some(pair1)) => pair1._2
          case (Some(pair0), Some(pair1)) => calculateInColor(pair0, pair1, value)
          case _ => Color(0, 0, 0)
        }
      }
    }

  }

  def posToLocation(pos: (Int, Int)): Location = {
    Location(90 - pos._2, pos._1 - 180)
  }

  /**
   * @param temperatures Known temperatures
   * @param colors Color scale
   * @return A 360×180 image where each pixel shows the predicted temperature at its location
   */
  def visualize(temperatures: Iterable[(Location, Temperature)], colors: Iterable[(Temperature, Color)]): Image = {
    val pos = for {
      y <- 0 until IMAGE_HEIGHT
      x <- 0 until IMAGE_WIDTH
    } yield (x, y)

    val pixels = pos.par
      .map(posToLocation)
      .map(predictTemperature(temperatures, _))
      .map(interpolateColor(colors, _))
      .map(col => Pixel(col.red, col.green, col.blue, ALPHA))
      .toArray

    Image(IMAGE_WIDTH, IMAGE_HEIGHT, pixels)
  }
}