package observatory

import Visualization.{ interpolateColor }
import Interaction.{ tileLocation }
import com.sksamuel.scrimage.{ Image, Pixel }

/**
 * 5th milestone: value-added information visualization
 */
object Visualization2 {

  val P = 8 // 8 for 256 pixels
  val IMAGE_WIDTH = 1 << P
  val IMAGE_HEIGHT = 1 << P
  val ALPHA = 255

  /**
   * @param point (x, y) coordinates of a point in the grid cell
   * @param d00 Top-left value
   * @param d01 Bottom-left value
   * @param d10 Top-right value
   * @param d11 Bottom-right value
   * @return A guess of the value at (x, y) based on the four known values, using bilinear interpolation
   *         See https://en.wikipedia.org/wiki/Bilinear_interpolation#Unit_Square
   */
  def bilinearInterpolation(
    point: CellPoint,
    d00: Temperature,
    d01: Temperature,
    d10: Temperature,
    d11: Temperature): Temperature = {

    d00 * (1 - point.x) * (1 - point.y) +
      d01 * (1 - point.x) * point.y +
      d10 * point.x * (1 - point.y) +
      d11 * point.x * point.y
  }

  def interpolate(grid: GridLocation => Temperature, location: Location): Temperature = {
    val lat = location.lat.toInt
    val lon = location.lon.toInt
    val t00 = grid(GridLocation(lat, lon))
    val t01 = grid(GridLocation(lat + 1, lon))
    val t10 = grid(GridLocation(lat, lon + 1))
    val t11 = grid(GridLocation(lat + 1, lon + 1))
    val p = CellPoint(location.lon - lon, location.lat - lat)
    bilinearInterpolation(p, t00, t01, t10, t11)
  }

  /**
   * @param grid Grid to visualize
   * @param colors Color scale to use
   * @param tile Tile coordinates to visualize
   * @return The image of the tile at (x, y, zoom) showing the grid using the given color scale
   */
  def visualizeGrid(
    grid: GridLocation => Temperature,
    colors: Iterable[(Temperature, Color)],
    tile: Tile): Image = {

    val pos = for {
      y <- 0 until IMAGE_HEIGHT
      x <- 0 until IMAGE_WIDTH
    } yield (x, y)

    val offsetX = tile.x * (1 << P)
    val offsetY = tile.y * (1 << P)

    val pixels = pos.par
      .map({ case (x, y) => Tile(x + offsetX, y + offsetY, tile.zoom + P) })
      .map(tileLocation)
      .map(interpolate(grid, _))
      .map(interpolateColor(colors, _))
      .map(col => Pixel(col.red, col.green, col.blue, ALPHA))
      .toArray

    Image(IMAGE_WIDTH, IMAGE_HEIGHT, pixels)
  }

}
