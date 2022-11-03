package org.cscie88c.week8

import com.typesafe.scalalogging.LazyLogging
import scala.util.{Try, Success, Failure}
import scala.io.Source
import org.cscie88c.config.{ConfigUtils}
import pureconfig.generic.auto._

// write case class here
case class SimpleApp2Config(fileName: String, month: String)

// run with: sbt "runMain org.cscie88c.week8.SimpleApp2"
object SimpleApp2 extends LazyLogging{

  val SIMPLE_APP_2_CONFIG_PATH = "org.cscie88c.simple-app-2"

  def lineStreamFromFile(fileName: String): Option[LazyList[String]] =
    Try {
      LazyList.from(Source.fromResource(fileName).getLines())
    }.toOption
  
  def monthLines(month: String)(lines: LazyList[String])(): LazyList[String] = {
    lines.filter(_.contains(month))
  }
      
  def main(args: Array[String]): Unit = {
    implicit val conf: SimpleApp2Config = ConfigUtils.loadAppConfig[SimpleApp2Config](SIMPLE_APP_2_CONFIG_PATH)
    val lines = lineStreamFromFile(conf.fileName)

    lines match {
      case Some(l) => println(s"Transactions in ${conf.month}: ${monthLines(conf.month)(l).size}")
      case None => println(s"No Transactions found for ${conf.month}")
    }
  }
}
