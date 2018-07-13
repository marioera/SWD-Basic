package observatory

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import java.time.LocalDate

@RunWith(classOf[JUnitRunner])
trait ExtractionTest extends FunSuite {

  test("stations") {
    val stations = Extraction.loadStations("/stations_test.csv").toList

    val location1 = Location(70.933d, -8.667d)
    val location2 = Location(35.317d, -77.633d)
    val location3 = Location(34.100d, -93.066d)

    val expected = List(
      ("010010-", location1),
      ("723067-93726", location2),
      ("-00100", location3))

    assert(expected === stations)
  }

  test("temperatures") {
    val temperatures = Extraction.loadTemperatures(1980, "/1980_test.csv").toList

    val expected = List(
      ("010010-", LocalDate.of(1980, 6, 2), 2.0d),
      ("010010-", LocalDate.of(1980, 6, 3), 2.61d),
      ("010013-", LocalDate.of(1980, 6, 7), 2.22d),
      ("010013-", LocalDate.of(1980, 6, 8), 1.5d),
      ("723067-93726", LocalDate.of(1980, 6, 13), 1.0d),
      ("723067-93726", LocalDate.of(1980, 6, 14), 4.0d),
      ("723067-93726", LocalDate.of(1980, 6, 14), 2.0d),
      ("-00100", LocalDate.of(1980, 6, 21), 3.89d),
      ("-00100", LocalDate.of(1980, 6, 22), 3.39d),
      ("-91002", LocalDate.of(1980, 6, 26), 0.61d),
      ("-91002", LocalDate.of(1980, 6, 27), 2.5d))
    assert(expected === temperatures)
  }

  test("locateTemperatures") {
    val actual = Extraction.locateTemperatures(1980, "/stations_test.csv", "/1980_test.csv").toList

    val location1 = Location(70.933d, -8.667d)
    val location2 = Location(35.317d, -77.633d)
    val location3 = Location(34.100d, -93.066d)

    val expected = List(
      (LocalDate.of(1980, 6, 2), location1, 2.0d),
      (LocalDate.of(1980, 6, 3), location1, 2.61d),
      (LocalDate.of(1980, 6, 13), location2, 1.0d),
      (LocalDate.of(1980, 6, 14), location2, 4.0d),
      (LocalDate.of(1980, 6, 14), location2, 2.0d),
      (LocalDate.of(1980, 6, 21), location3, 3.89d),
      (LocalDate.of(1980, 6, 22), location3, 3.39d))
    assert(expected === actual)
  }

  test("locationYearlyAverageRecords") {
    val locTemperatures = Extraction.locateTemperatures(1980, "/stations_test.csv", "/1980_test.csv").toList
    val actual = Extraction.locationYearlyAverageRecords(locTemperatures).toList

    val location1 = Location(70.933d, -8.667d)
    val location2 = Location(35.317d, -77.633d)
    val location3 = Location(34.100d, -93.066d)

    val expected = List(
      (location3, (3.89 + 3.39) / 2),
      (location2, (1.0 + 4.0 + 2.0) / 3),
      (location1, (2.0 + 2.61) / 2))
    assert(expected === actual)
  }
}