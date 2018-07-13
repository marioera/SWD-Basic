package observatory

import java.time.LocalDate

import scala.io.Source

/**
 * 1st milestone: data extraction
 */
object Extraction {

  def loadStations(stationsFile: String): Map[String, Location] = {
    val stationsFileData = Source.fromInputStream(getClass.getResourceAsStream(stationsFile))

    stationsFileData.getLines().flatMap(station => {
      val cols = station.split(",", -1)
      val data = (cols(0), cols(1), cols(2), cols(3))
      data match {
        case (_, _, "", "") => None
        case (_, _, _, "") => None
        case (_, _, "", _) => None
        case (stn, wban, latitude, longitude) => Some((stn + "-" + wban, Location(latitude.toDouble, longitude.toDouble)))
      }

    }).toMap
  }

  def loadTemperatures(year: Year, temperaturesFile: String): Iterable[(String, LocalDate, Double)] = {
    val temperaturesFileData = Source.fromInputStream(getClass.getResourceAsStream(temperaturesFile))

    temperaturesFileData.getLines().flatMap(temperature => {
      val cols = temperature.split(",", -1)

      val tCent = {
        if (cols(4) == 9999.9) None
        else Some(Math.round((cols(4).toDouble - 32) * 5 * 100.0d / 9) / 100.0d)
      }

      val data = (cols(0), cols(1), LocalDate.of(year, cols(2).toInt, cols(3).toInt), tCent)
      data match {
        case (_, _, _, None) => None
        case (stn, wban, date, Some(temperature)) => Some((stn + "-" + wban, date, temperature))
      }

    }).toIterable
  }

  /**
   * @param year             Year number
   * @param stationsFile     Path of the stations resource file to use (e.g. "/stations.csv")
   * @param temperaturesFile Path of the temperatures resource file to use (e.g. "/1975.csv")
   * @return A sequence containing triplets (date, location, temperature)
   */
  def locateTemperatures(year: Year, stationsFile: String, temperaturesFile: String): Iterable[(LocalDate, Location, Temperature)] = {
    val stations = loadStations(stationsFile)
    val temperatures = loadTemperatures(year, temperaturesFile)

    // Huge performance improvement changing stations.find(...) as List to use get(key) as Map!
    temperatures.flatMap(t => {
      stations.get(t._1).map(s => (t._2, s, t._3))
    })
  }

  /**
   * @param records A sequence containing triplets (date, location, temperature)
   * @return A sequence containing, for each location, the average temperature over the year.
   */
  def locationYearlyAverageRecords(records: Iterable[(LocalDate, Location, Temperature)]): Iterable[(Location, Temperature)] = {
    // HUGE Performance improvement just marking records.par. :) !! Goodbye OOM issue!
    records.par
      .groupBy(record => record._2)
      .mapValues(ts => ts.foldLeft(0.0)((acc, t) => acc + t._3) / ts.size).toList
  }
}