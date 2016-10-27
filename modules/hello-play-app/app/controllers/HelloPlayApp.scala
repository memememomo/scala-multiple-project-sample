package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import utils.RichString._

@Singleton
class HelloPlayApp @Inject() extends Controller {
  def index = Action {
    Ok("Hello play app!".addNowDateTime())
  }
}