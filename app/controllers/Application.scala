package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.Logger._
import world.dao._
import world.model._

object Application extends Controller {

  val form = Form(single("country" -> text))

  def index = Action {
    Ok(views.html.index("Play & Scala Example"))
  }

  def world = Action {
    Ok(views.html.world("Hello World"))
  }

  def manual = Action {
    Ok(views.html.manual("Play Documentation"))
  }

  def cities = Action {
    Ok(views.html.helloworld.cities("List Cities by Country"))
  }
  
  /*
    def citiesShow(country: String) = Action { implicit request =>
      val cityDao = new CityDao
      val cities = cityDao.getCities(country)
      Ok(cities.toString)
    }
  **/
  
  def citiesShow = Action { implicit request =>
    val country = form.bindFromRequest.get.toString
    val cityDao = new CityDao
    Ok(cityDao.getCities(country).toString)
  }
  
}