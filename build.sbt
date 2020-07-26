resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.jcenterRepo
)

inThisBuild(
  List(
    scalaVersion := "2.12.11",
    crossScalaVersions := Seq("2.12.11", "2.13.3"),
    organization := "crew.chisel",
    homepage := Some(url("https://github.com/chisel-crew/amba")),
    startYear := Some(2020),
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    scmInfo := Some(
      ScmInfo(url("https://github.com/chisel-crew/amba"), "scm:git@github.com:chisel-crew/amba.git")
    )
  )
)

lazy val commonSettings = Seq(
// Refine scalac params from tpolecat
  scalacOptions --= Seq(
    "-Xfatal-warnings"
  ),
  scalacOptions ++= Seq(
    "-Xsource:2.11",
    "-language:reflectiveCalls",
    "-language:postfixOps",
    "-unchecked",
    "-deprecation"
  ),
  name := "hello",
  version := "0.0.1"
)

lazy val commonDeps = libraryDependencies ++= Seq(
  "com.github.pureconfig" %% "pureconfig" % Version.pureconfig
)

lazy val chiselDeps = libraryDependencies ++= Seq(
  "edu.berkeley.cs" %% "chisel3"          % Version.chisel,
  "edu.berkeley.cs" %% "firrtl"           % Version.firrtl,
  "edu.berkeley.cs" %% "chisel-iotesters" % Version.testers
)

lazy val zioDeps = libraryDependencies ++= Seq(
  "dev.zio" %% "zio"          % Version.zio,
  "dev.zio" %% "zio-test"     % Version.zio % "test",
  "dev.zio" %% "zio-test-sbt" % Version.zio % "test"
)

lazy val root = (project in file("."))
  .settings(
    maxErrors := 3,
    commonSettings,
    pubSettings,
    commonDeps,
    chiselDeps,
    zioDeps,
    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
  )

lazy val pubSettings = Seq(
  bintrayRepository := "amba",
  publishMavenStyle := true,
  bintrayOrganization := Some("chisel-crew")
)

// Aliases
addCommandAlias("rel", "reload")
addCommandAlias("com", "all compile test:compile it:compile")
addCommandAlias("fix", "all compile:scalafix test:scalafix")
addCommandAlias("fmt", "all scalafmtSbt scalafmtAll")

scalafixDependencies in ThisBuild += "com.nequissimus" %% "sort-imports" % "0.5.4"
