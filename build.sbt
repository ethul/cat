name := "cat"

organization := "cat"

version := "0.0.0"

scalaVersion := "2.9.2"

resolvers += "Scala Tools Snapshots" at "http://scala-tools.org/repo-snapshots/"

resolvers += "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0-SNAPSHOT"

libraryDependencies += "org.scalaz" %% "scalaz-effect" % "7.0-SNAPSHOT"

libraryDependencies += "org.specs2" %% "specs2" % "1.9" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.10-SNAPSHOT" % "test"

scalacOptions += "-deprecation"
