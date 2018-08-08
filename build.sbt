lazy val root = (project in file("."))
  .settings(
    name := "circe-trick-example",
    organization := "com.github.shinharad",
    scalaVersion := "2.12.6",
    version      := "0.1.0-SNAPSHOT",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Xlint", "-Xmacro-settings:print-codecs"),
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser",
      "io.circe" %% "circe-generic-extras"
    ).map(_ % circeVersion)
  )

val circeVersion = "0.9.3"

