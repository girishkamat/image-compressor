name := "image-compressor"

version := "0.1"

scalaVersion := "2.12.14"

libraryDependencies += "net.coobird" % "thumbnailator" % "0.4.14"

mainClass in assembly := some("ImageResizer")
assemblyJarName := "image-compressor.jar"