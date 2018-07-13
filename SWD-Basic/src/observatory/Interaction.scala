package observatory

import scala.math.{ atan, sinh, Pi, pow, toDegrees }
import Visualization.{ predictTemperature, interpolateColor }
import com.sksamuel.scrimage.{ Image, Pixel }

/**
 * 3rd milestone: interactive visualization
 */
object Interaction {

  val P = 8 // 8 for 256 pixels
  val IMAGE_WIDTH = 1 << P
  val IMAGE_HEIGHT = 1 << P
  val ZOOM_LEVEL = 3 // 3 for all layers
  val ALPHA = 127

  /**
   * @param tile Tile coordinates
   * @return The latitude and longitude of the top-left corner of the tile, as per http://wiki.openstreetmap.org/wiki/Slippy_map_tilenames
   */
  def tileLocation(tile: Tile): Location = {
    // Avoid << operator. Casting problems to Int in division
    val lat = toDegrees(atan(sinh(Pi - (tile.y * 2 * Pi) / pow(2, tile.zoom))))
    val lon = tile.x / pow(2, tile.zoom) * 360 - 180
    Location(lat, lon)
  }

  /**
   * @param temperatures Known temperatures
   * @param colors Color scale
   * @param tile Tile coordinates
   * @return A 256×256 image showing the contents of the given tile
   */
  def tile(temperatures: Iterable[(Location, Temperature)], colors: Iterable[(Temperature, Color)], tile: Tile): Image = {
    val pos = for {
      y <- 0 until IMAGE_HEIGHT
      x <- 0 until IMAGE_WIDTH
    } yield (x, y)

    val offsetX = tile.x * (1 << P)
    val offsetY = tile.y * (1 << P)

    val pixels = pos.par
      .map({ case (x, y) => Tile(x + offsetX, y + offsetY, tile.zoom + P) })
      .map(tileLocation)
      .map(predictTemperature(temperatures, _))
      .map(interpolateColor(colors, _))
      .map(col => Pixel(col.red, col.green, col.blue, ALPHA))
      .toArray

    Image(IMAGE_WIDTH, IMAGE_HEIGHT, pixels)
  }

  /**
   * Generates all the tiles for zoom levels 0 to 3 (included), for all the given years.
   * @param yearlyData Sequence of (year, data), where `data` is some data associated with
   *                   `year`. The type of `data` can be anything.
   * @param generateImage Function that generates an image given a year, a zoom level, the x and
   *                      y coordinates of the tile and the data to build the image from
   */
  def generateTiles[Data](yearlyData: Iterable[(Year, Data)], generateImage: (Year, Tile, Data) => Unit): Unit = {
    val tiles = for {
      zoom <- 0 to ZOOM_LEVEL
      x <- 0 until 1 << zoom
      y <- 0 until 1 << zoom
      (year, data) <- yearlyData
    } yield generateImage(year, Tile(x, y, zoom), data)
  }
}