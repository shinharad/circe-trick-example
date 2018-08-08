package com.github.shinharad

//import io.circe._
//import io.circe.generic.auto._
//import io.circe.generic.extras.Configuration
//import io.circe.parser._
//import io.circe.generic.extras.auto._
//import io.circe.generic.semiauto
//import io.circe.syntax._
//import cats.syntax.either._

object DefaultValue extends App {

  lazy val defaultValue = Message("匿名希望", "ノーコメントです")

//  def decode1(json: String): Either[Error, Message] = decode[Message](json)

//  def decode2(json: String): Either[Error, Message] =
//    decode[Message => Message](json).map(_(defaultValue))
//    decode[Message => Message](json).map(_(Message("匿名希望", Some("ノーコメントです"))))
//    decode[Message => Message](json).map(_(Message.defaultValue))

//  def decode3(json: String): Either[Error, Message] = {
////    import io.circe.generic.extras.auto._
//    implicit val customConfig: Configuration = Configuration.default.withDefaults
////    implicit val decodeBar: Decoder[Message] = semiauto.deriveDecoder
//    decode[Message](json)
//  }

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

//  println(decode1(json1)) // => Right(Message(Taro,よろしくお願いします))
//  println(decode1(json2)) // => Left(DecodingFailure(Attempt to decode value on failed cursor, List(DownField(body))))
//  println(decode3(json2))
//  println(decode2(json2)) // => Right(Message(Taro,ノーコメントです))
//  println(decode2(json3)) // => Right(Message(匿名希望,よろしくお願いします))
//  println(decode2("{}")) // => Right(Message(匿名希望,ノーコメントです))

}

final case class Message(
  name: String,
//  body: Option[String]
    body: String = "aaa" // こうやってもだめ
)

object Message {
//  implicit val decodeBar: Decoder[Message] = semiauto.deriveDecoder

//  import io.circe.generic.extras.{ semiauto => fancy }
//  implicit val decodeBar: Decoder[Message] = fancy.deriveDecoder

//  def defaultValue = Message("匿名希望", Some("ノーコメントです"))
  def defaultValue = Message("匿名希望", "ノーコメントです")

}

