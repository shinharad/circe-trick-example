package com.github.shinharad

//import io.circe.generic.auto._
import io.circe.generic.extras.Configuration
import io.circe.parser._

object DefaultValue1 extends App {

  val json1 =
    """
      |{
      |  "name": "Taro",
      |  "body": "よろしくお願いします"
      |}
    """.stripMargin

  val json2 =
    """
      |{
      |  "name": "Taro"
      |}
    """.stripMargin

  val json3 =
    """
      |{
      |  "body": "よろしくお願いします"
      |}
    """.stripMargin

  val json4 = "{}"

  final case class Message(
    name: String = "匿名希望",
    body: String = "ノーコメントです"
  )

  import io.circe.generic.extras.auto._
  implicit val customConfig: Configuration = Configuration.default.withDefaults
  println(decode[Message](json1)) // => Right(Message(Taro,よろしくお願いします))
  println(decode[Message](json2)) // => Right(Message(Taro,ノーコメントです))
  println(decode[Message](json3)) // => Right(Message(匿名希望,よろしくお願いします))
  println(decode[Message](json4)) // => Right(Message(匿名希望,ノーコメントです))

}

