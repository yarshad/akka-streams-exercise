import com.typesafe.sbteclipse.core.EclipsePlugin.{EclipseCreateSrc, EclipseKeys}
import sbt.Keys._
import sbt._

object CommonSettings {
  import sbtstudent.AdditionalSettings

  lazy val commonSettings = Seq(
    organization := "com.lightbend.training",
    version := "1.0.0",
    scalaVersion := Version.scalaVer,
    scalacOptions ++= CompileOptions.compileOptions,
    unmanagedSourceDirectories in Compile := List((scalaSource in Compile).value),
    unmanagedSourceDirectories in Test := List((scalaSource in Test).value),
    EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource,
    EclipseKeys.eclipseOutput := Some(".target"),
    EclipseKeys.withSource := true,
    EclipseKeys.skipParents in ThisBuild := true,
    EclipseKeys.skipProject := true,
    parallelExecution in GlobalScope := false,
    logBuffered in Test := false,
    parallelExecution in ThisBuild := false,
    libraryDependencies ++= Dependencies.dependencies
  ) ++
    AdditionalSettings.initialCmdsConsole ++
    AdditionalSettings.initialCmdsTestConsole ++
    AdditionalSettings.cmdAliases
}
