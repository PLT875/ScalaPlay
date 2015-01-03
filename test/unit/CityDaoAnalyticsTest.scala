package unit

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import world.dao.CityDao
import world.model.City
import world.analytics.CityAnalytics
import play.api.test._
import play.api.test.Helpers._

/**
 * @author petertran
 */
class CityDaoAnalyticsTest extends FunSuite {
  
  test("5 cities should be return for Switzerland"){
    running(FakeApplication()){
      val cityDao = new CityDao
      val result = cityDao.getCities("Switzerland")
      assert(result.length == 5)
    }
  }
  
  /** Test data **/
  val t0 = new City("t0", "Bandung", "West Java", 20)
  val t1 = new City("t1", "Bekasi", "West Java", 60)
  val t2 = new City("t2", "Depok", "West Java", 30)
  val t3 = new City("t3", "Malang", "East Java", 70)
  val t4 = new City("t4", "Blitar", "East Java", 10)
  val t5 = new City("t5", "Kediri", "East Java", 25)
  val t6 = new City("t6", "Cilacap", "Central Java", 20)
  val t7 = new City("t7", "Purwokerto",  "Central Java", 20)
  
  val cities = List(t0, t1, t2, t3, t4, t5, t6, t7)
  
  
  val districtsPopulation = CityAnalytics.populationByDistrict(cities)
  
  test("Population of West Java should be 110"){
    running(FakeApplication()){
      assert(districtsPopulation("West Java") == 110)
    }
  }
  
  test("Population of East Java should be 105"){
    running(FakeApplication()){
      assert(districtsPopulation("East Java") == 105)
    }
  }
  
  test("Population of Central Java should be 40"){
    running(FakeApplication()){
      assert(districtsPopulation("Central Java") == 40)
    }
  }

}