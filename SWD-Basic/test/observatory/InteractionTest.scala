package observatory

import org.scalatest.FunSuite
import org.scalatest.prop.Checkers

import scala.collection.concurrent.TrieMap
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
trait InteractionTest extends FunSuite with Checkers {

  test("tileLocation") {
    assert(Location(0.0d, 0.0d) === Interaction.tileLocation(Tile(1, 1, 1)))
    assert(Location(0.0d, 0.0d) === Interaction.tileLocation(Tile(2, 2, 2)))
    assert(Location(0.0d, 0.0d) === Interaction.tileLocation(Tile(4, 4, 3)))
  }

}