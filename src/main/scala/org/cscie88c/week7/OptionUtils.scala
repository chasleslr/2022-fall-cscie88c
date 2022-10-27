package org.cscie88c.week7

import scala.io.Source
import scala.util.{Try, Success, Failure}

object OptionUtils {
  
  def fileCharCount(fileName: String): Try[Long] = Try {
    Source.fromResource(fileName).size
  }

  def charCountAsString(fileName: String): String = {
    fileCharCount(fileName) match {
      case Success(c) => s"number of characters: ${c}"
      case Failure(e) => "error opening file"
    }
  }

  def lineStreamFromFile(fileName: String): Option[LazyList[String]] = Try {
    val file = Source.fromResource(fileName)
    file.getLines.to(LazyList)
  }.toOption
}
