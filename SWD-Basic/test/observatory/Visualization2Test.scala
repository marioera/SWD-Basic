package observatory

import org.scalatest.FunSuite
import org.scalatest.prop.Checkers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
trait Visualization2Test extends FunSuite with Checkers {
  test("bilinearInterpolation") {
    assert(10.0 === Visualization2.bilinearInterpolation(CellPoint(0.5, 0.5), 10, 10, 10, 10))
    assert(25.0 === Visualization2.bilinearInterpolation(CellPoint(0.5, 0.5), 10, 20, 30, 40))
    assert(10.0 === Visualization2.bilinearInterpolation(CellPoint(0.0, 0.0), 10, 20, 30, 40))
    assert(40.0 === Visualization2.bilinearInterpolation(CellPoint(1.0, 1.0), 10, 20, 30, 40))
    assert(20.0 === Visualization2.bilinearInterpolation(CellPoint(0.5, 0.0), 10, 20, 30, 40))
    assert(30.0 === Visualization2.bilinearInterpolation(CellPoint(0.5, 1.0), 10, 20, 30, 40))
    assert(37.0 === Visualization2.bilinearInterpolation(CellPoint(0.9, 0.9), 10, 20, 30, 40))
    assert(38.0 === Visualization2.bilinearInterpolation(CellPoint(0.9, 1.0), 10, 20, 30, 40))
    assert(39.0 === Visualization2.bilinearInterpolation(CellPoint(1.0, 0.9), 10, 20, 30, 40))
  }

  test("visualizeGrid - Antipodes") {
    val location0 = Location(-180.0d, 90.0d)
    val location1 = Location(180.0d, 90.0d)
    val location2 = Location(0.0d, 0.0d)
    val location3 = Location(-180.0d, -90.0d)
    val location4 = Location(180.0d, -90.0d)

    val temperatures0 = List(
      (location0, 60.0),
      (location1, 60.0),
      (location2, 0.0),
      (location3, -60.0),
      (location4, -60.0))

    val pallete = List(
      (0.0d, Color(0, 255, 255)),
      (-15.0d, Color(0, 0, 255)),
      (12.0d, Color(255, 255, 0)),
      (-27.0d, Color(255, 0, 255)),
      (32.0d, Color(255, 0, 0)),
      (-50.0d, Color(33, 9, 107)),
      (60.0d, Color(255, 255, 255)),
      (-60.0d, Color(0, 0, 0)))

    val image = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(0, 0, 0))
    image.output(new java.io.File("./DeviationAntipodes.png"))

    assert(image.width * image.height === Visualization2.IMAGE_WIDTH * Visualization2.IMAGE_HEIGHT)
  }

  test("visualizeGrid - BiAntipode") {
    val location0 = Location(-45.0d, -90.0d)
    val location1 = Location(45.0d, 90.0d)

    val temperatures0 = List(
      (location0, 60.0),
      (location1, -60.0))

    val pallete = List(
      (0.0d, Color(0, 255, 255)),
      (-15.0d, Color(0, 0, 255)),
      (12.0d, Color(255, 255, 0)),
      (-27.0d, Color(255, 0, 255)),
      (32.0d, Color(255, 0, 0)),
      (-50.0d, Color(33, 9, 107)),
      (60.0d, Color(255, 255, 255)),
      (-60.0d, Color(0, 0, 0)))

    val image = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(0, 0, 0))
    image.output(new java.io.File("./DeviationBiAntipode.png"))
    val image100 = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(0, 0, 1))
    image100.output(new java.io.File("./DeviationBiAntipode1-0-0.png"))
    val image211 = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(1, 1, 2))
    image211.output(new java.io.File("./DeviationBiAntipode2-1-1.png"))
    val image333 = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(3, 3, 3))
    image333.output(new java.io.File("./DeviationBiAntipode3-3-3.png"))
    val image477 = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(7, 7, 4))
    image477.output(new java.io.File("./DeviationBiAntipode4-7-7.png"))
    val image51515 = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(15, 15, 5))
    image51515.output(new java.io.File("./DeviationBiAntipode5-15-15.png"))
    val image63131 = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(31, 31, 6))
    image63131.output(new java.io.File("./DeviationBiAntipode6-31-31.png"))
    val image76363 = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(63, 63, 7))
    image76363.output(new java.io.File("./DeviationBiAntipode7-63-63.png"))
    val image8127127 = Visualization2.visualizeGrid(Manipulation.makeGrid(temperatures0), pallete, Tile(127, 127, 8))
    image8127127.output(new java.io.File("./DeviationBiAntipode8-127-127.png"))

    assert(image.width * image.height === Visualization2.IMAGE_WIDTH * Visualization2.IMAGE_HEIGHT)
  }

  ignore("visualizeGrid - Deviation 2015 - 1975") {
    val pallete = List(
      (7.0d, Color(0, 0, 0)),
      (4.0d, Color(255, 0, 0)),
      (2.0d, Color(255, 255, 0)),
      (0.0d, Color(255, 255, 255)),
      (-2.0d, Color(0, 255, 255)),
      (-7.0d, Color(0, 0, 255)))

    val t1975 = Extraction.locateTemperatures(1975, "/stations.csv", "/1975-100.csv")
    val t1975Data = Extraction.locationYearlyAverageRecords(t1975)

    val t2015 = Extraction.locateTemperatures(2015, "/stations.csv", "/2015-100.csv")
    val t2015Data = Extraction.locationYearlyAverageRecords(t2015)

    val image = Visualization2.visualizeGrid(Manipulation.deviation(t2015Data, Manipulation.makeGrid(t1975Data)), pallete, Tile(0, 0, 0))
    image.output(new java.io.File("./Deviation2015-1975-100.png"))
    assert(1 === 1)
  }
}