package observatory

import org.scalameter._
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class ExtractionBench extends ExtractionBenchTest

trait ExtractionBenchTest extends FunSuite {

  def fixture = new { val years = Extraction.locateTemperatures(2015, "/stations.csv", "/2015.csv") }

  ignore("measure of yearly average speed") {
    val time = config(
      Key.exec.benchRuns -> 10,
      Key.exec.maxWarmupRuns -> 10,
      Key.verbose -> true) withWarmer {
        new Warmer.Default
      } withMeasurer {
        new Measurer.IgnoringGC
      } measure {
        val f = fixture
        Extraction.locationYearlyAverageRecords(f.years)
      }
    println(s"total time for yearly average = $time")
  }

}