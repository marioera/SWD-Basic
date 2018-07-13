package observatory

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

object Main extends App {

  val output = "target/temperatures"
  val YEAR = 2015
  val TEST_FILE = ""

  val pallete = List(
    (-60.0d, Color(0, 0, 0)),
    (-50.0d, Color(33, 9, 107)),
    (-27.0d, Color(255, 0, 255)),
    (-15.0d, Color(0, 0, 255)),
    (0.0d, Color(0, 255, 255)),
    (12.0d, Color(255, 255, 0)),
    (32.0d, Color(255, 0, 0)),
    (60.0d, Color(255, 255, 255)))

  val yearTemperatures = Extraction.locateTemperatures(YEAR, "/stations.csv", "/" + YEAR + TEST_FILE + ".csv")
  val yearData = Extraction.locationYearlyAverageRecords(yearTemperatures)
  val data = List[(Year, Iterable[(Location, Temperature)])]((YEAR, yearData))

  def generateYearTile(year: Year, tile: Tile, data: Iterable[(Location, Temperature)]): Unit = {
    val dir = output + "/" + year + "/" + tile.zoom
    val fileName = dir + "/" + tile.x + "-" + tile.y + ".png"
    Files.createDirectories(Paths.get(dir))

    val image = Interaction.tile(data, pallete, tile)
    image.output(new File(fileName))
  }

  Interaction.generateTiles(data, generateYearTile)
}