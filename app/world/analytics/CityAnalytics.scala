package world.analytics

import world.model._

object CityAnalytics {
  def populationByDistrict(cities : List[City]): Map[String, Int] = {
    val res0 = cities.map(city => (city.district, city.population))
    val res1 = res0.groupBy { case(district, population) => district }
    val popByDistrict = res1.map(district => (district._1, district._2.foldLeft(0)( (sum, const) => sum + const._2) ))
    popByDistrict
  }
}