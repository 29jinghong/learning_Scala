name := "programming-in-scala"

organization := "org.jinghong"

version := "1.0"

scalaVersion := "2.13.12"

lazy val AkkaVersion = "2.10.11"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0",
  "org.scalactic" %% "scalactic" % "3.2.18",
  "org.scalatest" %% "scalatest" % "3.2.18" % "test",
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.5.12"
)

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

publishArtifact in Test := false

parallelExecution in Test := false
