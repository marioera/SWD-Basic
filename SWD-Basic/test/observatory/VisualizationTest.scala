package observatory

import org.scalatest.FunSuite
import org.scalatest.prop.Checkers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
trait VisualizationTest extends FunSuite with Checkers {

  test("predictTemperature") {
    val location1 = Location(0.0d, 0.0d)
    val location2 = Location(0.0d, 2.0d)
    val location3 = Location(0.0d, -2.0d)
    val location = Location(0.0d, 1.0d)

    val temperatures = List(
      (location1, 0.0),
      (location2, 10.0),
      (location3, 5.0))

    val actual = Visualization.predictTemperature(temperatures, location)

    // Precision depends on P attribute for distance calculation
    assert(5.000000000000001d === actual)
  }

  test("predictTemperature - closeRange") {
    val location1 = Location(0.0d, 0.0d)
    val location2 = Location(0.0d, 2.0d)

    val location = Location(0.0000001d, 0.0d)

    val temperatures = List(
      (location1, 10.0),
      (location2, 0.0))

    val actual = Visualization.predictTemperature(temperatures, location)

    assert(10.0d === actual)
  }

  test("interpolateColor") {
    val pairs = List(
      (0.0d, Color(0, 255, 255)),
      (-15.0d, Color(0, 0, 255)),
      (12.0d, Color(255, 255, 0)),
      (-27.0d, Color(255, 0, 255)),
      (32.0d, Color(255, 0, 0)),
      (-50.0d, Color(33, 9, 107)),
      (60.0d, Color(255, 255, 255)),
      (-60.0d, Color(0, 0, 0)))

    assert(Color(0, 255, 255) === Visualization.interpolateColor(pairs, 0.0d))
    assert(Color(21, 255, 234) === Visualization.interpolateColor(pairs, 1.0d))
    assert(Color(43, 255, 213) === Visualization.interpolateColor(pairs, 2.0d))
    assert(Color(64, 255, 191) === Visualization.interpolateColor(pairs, 3.0d))
    assert(Color(85, 255, 170) === Visualization.interpolateColor(pairs, 4.0d))
    assert(Color(106, 255, 149) === Visualization.interpolateColor(pairs, 5.0d))
    assert(Color(128, 255, 128) === Visualization.interpolateColor(pairs, 6.0d))
    assert(Color(149, 255, 106) === Visualization.interpolateColor(pairs, 7.0d))
    assert(Color(170, 255, 85) === Visualization.interpolateColor(pairs, 8.0d))
    assert(Color(191, 255, 64) === Visualization.interpolateColor(pairs, 9.0d))
    assert(Color(213, 255, 43) === Visualization.interpolateColor(pairs, 10.0d))
    assert(Color(234, 255, 21) === Visualization.interpolateColor(pairs, 11.0d))
    assert(Color(255, 255, 0) === Visualization.interpolateColor(pairs, 12.0d))
  }

  test("visualize") {
    val location0 = Location(-180.0d, 90.0d)
    val location1 = Location(180.0d, 90.0d)
    val location2 = Location(0.0d, 0.0d)
    val location3 = Location(-180.0d, -90.0d)
    val location4 = Location(180.0d, -90.0d)
    val location5 = Location(-45.0d, -90.0d)
    val location6 = Location(45.0d, 90.0d)

    val pallete = List(
      (0.0d, Color(0, 255, 255)),
      (-15.0d, Color(0, 0, 255)),
      (12.0d, Color(255, 255, 0)),
      (-27.0d, Color(255, 0, 255)),
      (32.0d, Color(255, 0, 0)),
      (-50.0d, Color(33, 9, 107)),
      (60.0d, Color(255, 255, 255)),
      (-60.0d, Color(0, 0, 0)))

    val temperatures0 = List(
      (location0, 60.0),
      (location1, 60.0),
      (location2, 0.0),
      (location3, -60.0),
      (location4, -60.0))

    val temperatures1 = List(
      (location5, 60.0),
      (location6, -60.0))

    val image0 = Visualization.visualize(temperatures0, pallete)
    image0.output(new java.io.File("./ObservatoryAntipodes.png"))

    val image1 = Visualization.visualize(temperatures1, pallete)
    image1.output(new java.io.File("./ObservatoryBiAntipode.png"))

    assert(image0.width * image0.height === Visualization.IMAGE_WIDTH * Visualization.IMAGE_HEIGHT)
  }

}
