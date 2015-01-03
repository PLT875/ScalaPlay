package unit

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import world.dao.CityDao
import world.model.Country
import world.analytics.CountryAnalytics
import play.api.test._
import play.api.test.Helpers._

/**
 * @author petertran
 */
class CountryDaoAnalyticsTest extends FunSuite {
  
  val c0 = new Country("Macao", "East Asia", 200, 40000)
  val c1 = new Country("Hong Kong", "East Asia", 600, 60000)
  val c2 = new Country("Taiwan", "East Asia", 300, 90000)
  val c3 = new Country("South Korea", "East Asia", 200, 80000)
  
  val countries = List(c0, c1, c2, c3)
  val populationDensity = CountryAnalytics.populationDensity(countries)
  
  test("Population of density of Macao should be 200.0"){
    running(FakeApplication()){
      assert(populationDensity(0)._1 == "Macao")
      assert(populationDensity(0)._2 == 200.0)
    }
  }
  
  test("Population of density of Hong Kong should be 100.0"){
    running(FakeApplication()){
      assert(populationDensity(1)._1 == "Hong Kong")
      assert(populationDensity(1)._2 == 100.0)
    }
  }
  
  test("Population of density of Taiwan should be 300.0"){
    running(FakeApplication()){
      assert(populationDensity(2)._1 == "Taiwan")
      assert(populationDensity(2)._2 == 300.0)
    }
  }
  
  test("Population of density of South Korea should be 400.0"){
    running(FakeApplication()){
      assert(populationDensity(3)._1 == "South Korea")
      assert(populationDensity(3)._2 == 400.0)
    }
  }
  
  
}