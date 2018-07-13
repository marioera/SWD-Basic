package observatory

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.prop.Checkers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
trait ManipulationTest extends FunSuite with Checkers {

  test("makeGrid") {
    val location1 = Location(0.0d, 0.0d)
    val location2 = Location(0.0d, 2.0d)
    val location3 = Location(0.0d, -2.0d)

    val location = GridLocation(0, 1)

    val temperatures = List(
      (location1, 0.0),
      (location2, 10.0),
      (location3, 5.0))

    val actual = Manipulation.makeGrid(temperatures)(location)

    // Precision depends on P attribute for distance calculation
    assert(5.000000000000001d === actual)
  }

  test("average") {
    val location1 = Location(0.0d, 0.0d)
    val location2 = Location(0.0d, 2.0d)
    val location3 = Location(0.0d, -2.0d)

    val location = GridLocation(0, 1)

    val temperatures = List(
      (location1, 0.0),
      (location2, 10.0),
      (location3, 5.0))

    val actual = Manipulation.average(List(temperatures))(location)

    // Precision depends on P attribute for distance calculation
    assert(5.000000000000001d === actual)
  }

  test("deviation") {
    val location1 = Location(0.0d, 0.0d)
    val location2 = Location(0.0d, 2.0d)
    val location3 = Location(0.0d, -2.0d)

    val location = GridLocation(0, 1)

    val temperatures = List(
      (location1, 0.0),
      (location2, 10.0),
      (location3, 5.0))

    val actual = Manipulation.deviation(temperatures, Manipulation.makeGrid(temperatures))(location)

    // Precision depends on P attribute for distance calculation
    assert(0.0d === actual)
  }

}