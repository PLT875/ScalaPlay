package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Play & Scala Example"))
  }
  
  def menu = Action {
    Ok(views.html.menu("World Database"))
  }
  
  def manual = Action {
    Ok(views.html.manual("Play Documentation"))
  }

}