name := "scala-multiple-project-sample"

version := "1.0-SNAPSHOT"

lazy val commonSettings = Seq(scalaVersion := "2.11.8")

lazy val root = project in file(".")

lazy val helloPlayApp = (project in file("modules/hello-play-app"))
    .settings(commonSettings: _*)
    .settings(libraryDependencies ++= Seq(jdbc,cache,ws,specs2 % Test))
    .settings(resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases")
    .dependsOn(helloUtils)
    .enablePlugins(PlayScala)

lazy val helloUtils = (project in file("modules/hello-utils"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(
    "joda-time" % "joda-time" % "2.9.4",
    "org.joda" % "joda-convert" % "1.7"
  ))

routesGenerator := InjectedRoutesGenerator