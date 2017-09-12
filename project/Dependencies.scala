import sbt._

object Version {
  val akkaVer         = "2.5.3"
  val scalaVer        = "2.12.2"
  val scalaTestVer    = "3.0.1"

}

object Dependencies {
  val dependencies = Seq(
    "com.typesafe.akka"       %% "akka-actor"                 % Version.akkaVer withSources(),
    "com.typesafe.akka"       %% "akka-testkit"               % Version.akkaVer withSources(),
    "com.typesafe.akka"       %% "akka-stream"                % Version.akkaVer withSources(),
    "com.typesafe.akka"       %% "akka-stream-testkit"        % Version.akkaVer withSources(),
    "org.scalatest"           %% "scalatest"                  % Version.scalaTestVer % "test"
  )
}
