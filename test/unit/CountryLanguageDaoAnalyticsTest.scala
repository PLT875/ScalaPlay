package unit

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import world.dao.CountryLanguageDao
import play.api.test._
import play.api.test.Helpers._

/**
 * @author petertran
 */
class CountryLanguageDaoAnalyticsTest extends FunSuite {

  test("Population of French is 1374797 and Population of German is 4554014"){
    running(FakeApplication()){
      val countryLanguageDao = new CountryLanguageDao
      val languagePopulation = countryLanguageDao.getLanguagePercentages("Switzerland")
      assert(languagePopulation(0)._1 == "French")
      assert(languagePopulation(0)._3 == 1374797)
      assert(languagePopulation(1)._3 == 4554014)
      assert(languagePopulation(1)._1 == "German")
    }
  }
  
  
}