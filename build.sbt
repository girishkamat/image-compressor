name := "image-compressor"

version := "0.1"

scalaVersion := "2.12.14"

libraryDependencies += "net.coobird" % "thumbnailator" % "0.4.14"

Compile / assembly / mainClass := Some("ImageResizer")
Compile / run := Some("ImageResizer")
assemblyJarName := "image-compressor.jar"