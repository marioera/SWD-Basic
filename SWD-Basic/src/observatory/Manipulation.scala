package observatory

/**
 * 4th milestone: value-added information
 */
object Manipulation {

  class Grid {

    val IP_X = 180 //180
    val IP_Y = 90 //90

    private var gridData: Map[GridLocation, Temperature] = Map[GridLocation, Temperature]()

    def get(location: GridLocation): Temperature = {
      gridData(location)
    }

    def populate(temperatures: Iterable[(Location, Temperature)]): Unit = {
      gridData = {
        for {
          lat <- -IP_Y - 1 to IP_Y
          lon <- -IP_X until IP_X
        } yield GridLocation(lat, lon) -> Visualization.predictTemperature(temperatures, Location(lat, lon))
      }.toMap
    }

  }

  /**
   * @param temperatures Known temperatures
   * @return A function that, given a latitude in [-89, 90] and a longitude in [-180, 179],
   *         returns the predicted temperature at this location
   */
  def makeGrid(temperatures: Iterable[(Location, Temperature)]): GridLocation => Temperature = {
    /*val grid = new Grid()
    grid.populate(temperatures)

    (gridLocation) => grid.get(gridLocation)*/
    (gridLocation) => Visualization.predictTemperature(temperatures, Location(gridLocation.lat, gridLocation.lon))
  }

  /**
   * @param temperaturess Sequence of known temperatures over the years (each element of the collection
   *                      is a collection of pairs of location and temperature)
   * @return A function that, given a latitude and a longitude, returns the average temperature at this location
   */
  def average(temperaturess: Iterable[Iterable[(Location, Temperature)]]): GridLocation => Temperature = {
    // Avoid to user .par here. Causes TimeOuts. Extraction already made that: locationYearlyAverageRecords
    val grids = temperaturess.map(makeGrid)

    (gridLocation) => {
      val temps = grids.map(grid => grid(gridLocation))
      temps.sum / temps.size
    }
  }

  /**
   * @param temperatures Known temperatures
   * @param normals A grid containing the “normal” temperatures
   * @return A grid containing the deviations compared to the normal temperatures
   */
  def deviation(temperatures: Iterable[(Location, Temperature)], normals: GridLocation => Temperature): GridLocation => Temperature = {
    val grid = makeGrid(temperatures)

    (gridLocation) => grid(gridLocation) - normals(gridLocation)
  }

}