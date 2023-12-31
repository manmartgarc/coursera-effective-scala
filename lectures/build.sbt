val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "lectures",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= List(
      // % Test: tells sbt to have treat it as a test dependency.
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "com.lihaoyi" %% "fansi" % "0.4.0",
      "org.scalameta" %% "munit-scalacheck" % "0.7.29" % Test
    )
  )
