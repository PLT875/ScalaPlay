package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.Logger._
import world.dao._
import world.analytics._
import world.model._

object Application extends Controller {

  val citiesForm = Form(single("country" -> text))
  val populationsForm = Form(single("region" -> text))

  def index = Action {
    Ok(views.html.index("Play & Scala Example"))
  }

  def world = Action {
    Ok(views.html.world("Hello World!"))
  }

  def manual = Action {
    Ok(views.html.manual("Play Documentation"))
  }

  def cities = Action {
    Ok(views.html.helloworld.cities("List Cities by Country"))
  }
  
  def populations = Action {
    Ok(views.html.helloworld.populations("List Populations by Region"))
  }
  
  def populationsShow = Action { implicit request =>
    val region = populationsForm.bindFromRequest.get.toString
    val countryDao = new CountryDao
    val countryList = countryDao.getCountries(region)
    val countryDensities = CountryAnalytics.populationDensity(countryList)
    Ok(views.html.helloworld.populationsList("List Population Densities by Region", region, countryDensities))
  }
    
  def citiesShow = Action { implicit request =>
    val country = citiesForm.bindFromRequest.get.toString
    val cityDao = new CityDao
    val cityList = cityDao.getCities(country)
    Ok(views.html.helloworld.citiesList("List Cities by Country", country, cityList))
  }
  
}