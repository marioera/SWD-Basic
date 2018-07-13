package observatory

import org.scalameter._
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ManipulationBench extends ManipulationBenchTest

trait ManipulationBenchTest extends FunSuite {

  def fixture = new { val values = Extraction.locationYearlyAverageRecords(Extraction.locateTemperatures(2015, "/stations.csv", "/2015.csv")) }

  ignore("measure average speed") {
    val temploc = fixture.values
    val time = config(
      Key.exec.benchRuns -> 30,
      Key.verbose -> true) withWarmer {
        new Warmer.Default
      } withMeasurer {
        new Measurer.IgnoringGC
      } measure {
        Manipulation.makeGrid(temploc)
      }
    println(s"total time for average calculation = $time")
  }

}