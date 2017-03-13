name := "bitcoin-rpc-proxy"
organization := "org.gnuzero"
version := "1.0"
scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV       = "2.4.16"
  val akkaHttpV   = "10.0.1"
  val scalaTestV  = "3.0.1"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV,
    "org.scalatest"     %% "scalatest" % scalaTestV % "test"
  )
}


resolvers += "Sonatype" at "https://oss.sonatype.org/"


libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.9",
  "junit" % "junit" % "4.8" % "test",
  "org.slf4j" % "slf4j-jdk14" % "1.6.4",
  "io.argonaut" %% "argonaut" % "6.1",
"net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
  "org.apache.commons" % "commons-email" % "1.2"
  //"org.constretto" %% "constretto-scala" % "1.0"
)

libraryDependencies += "org.constretto" % "constretto-core" % "2.2.3"

