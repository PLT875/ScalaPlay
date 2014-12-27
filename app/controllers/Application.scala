package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._


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

  def citiesSubmit = Action { implicit request =>
    val (country) = form.bindFromRequest.get
    Ok("%s".format(country))
  }
}