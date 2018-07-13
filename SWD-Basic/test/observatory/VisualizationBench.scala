package observatory

import org.scalameter._
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class VisualizationBench extends VisualizationBenchTest

trait VisualizationBenchTest extends FunSuite {

  def fixture = new { val values = Extraction.locationYearlyAverageRecords(Extraction.locateTemperatures(2015, "/stations.csv", "/2015.csv")) }

  ignore("measure temp prediction speed on iterable") {
    val temploc = fixture.values
    val time = config(
      Key.exec.benchRuns -> 30,
      Key.verbose -> true) withWarmer {
        new Warmer.Default
      } withMeasurer {
        new Measurer.IgnoringGC
      } measure {
        Visualization.predictTemperature(temploc, Location(38, 24))
      }
    println(s"total time for temperature prediction = $time")
  }

}