package aoc2021.utils

import java.io.BufferedReader
import java.nio.charset.Charset
import java.nio.file.{Files, Paths}
import scala.jdk.StreamConverters._
import scala.util.{Failure, Success, Try}

object FileOperations {

  def readVectorFromFile(filePath: String) : Try[List[String]] = {
    Try {
      val f: BufferedReader = Files.newBufferedReader(Paths.get(filePath), Charset.forName("UTF-8"))
      f.lines().toScala(Iterator).toList
    }
  }

  def readIntVectorFromFile(filePath: String): Try[List[Int]] = {
    readVectorFromFile(filePath) match {
      case Success(value) => Try {
        value.map {
          line => Integer.parseInt(line)
        }
      }
      case Failure(exception) => Failure(exception)
    }
  }

}
