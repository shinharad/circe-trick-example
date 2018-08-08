package com.github.shinharad

import io.circe.generic.auto._
import io.circe.parser._

object DefaultValue2 extends App {

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
    name: String,
    body: String
  )

  lazy val defaultValue = Message("匿名希望", "ノーコメントです")

  println(decode[Message](json1))
  // => Right(Message(Taro,よろしくお願いします))

  println(decode[Message](json2))
  // => Left(DecodingFailure(Attempt to decode value on failed cursor, List(DownField(body))))
  println(decode[Message => Message](json2).map(_(defaultValue)))
  // => Right(Message(Taro,ノーコメントです))

  println(decode[Message](json3))
  // => Left(DecodingFailure(Attempt to decode value on failed cursor, List(DownField(name))))
  println(decode[Message => Message](json3).map(_(defaultValue)))
  // => Right(Message(匿名希望,よろしくお願いします))

  println(decode[Message](json4))
  // => Left(DecodingFailure(Attempt to decode value on failed cursor, List(DownField(name))))
  println(decode[Message => Message](json4).map(_(defaultValue)))
  // => Right(Message(匿名希望,ノーコメントです))

}

