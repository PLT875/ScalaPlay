package unit

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import world.dao.CityDao
import play.api.test._
import play.api.test.Helpers._

/**
 * @author petertran
 */
class CityDaoTest extends FunSuite {
  
  test("5 cities should be return for country code CHE"){
    running(FakeApplication()) {
      val cityDao = new CityDao
      val result = cityDao.getCities("CHE")
      assert(result.length == 4)
    }
  }
  

}