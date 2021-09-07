import net.coobird.thumbnailator.Thumbnails
import net.coobird.thumbnailator.name.Rename

import java.io.File

/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
object ImageResizer extends App {

  if (args.length != 2) {
    println("Usage: Provide a source and destination folder as e.g ./files ./files-resized")
    System.exit(1)
  }

  val fileDir = new File(args(0))
  val fileDestDir = new File(args(1))

  println("File dir " + fileDir)

  val files = fileDir.listFiles()

  val resolutions = List((1920, 1080), (1280, 720))

  def toKB(bytes: Long) = bytes / 1024

  println("File(Original), Size KB(Original), Size KB(Compressed), Percentage Compression")

  files.foreach { f =>
    println("Compressing file " + f.getName)
    val compressedFiles = Thumbnails.of(f).size(1280, 720)
      .outputQuality(1)
      .outputFormat("jpg")
      .asFiles(fileDestDir, Rename.NO_CHANGE)
    println(s"${f.getName},${toKB(f.length())}, ${toKB(compressedFiles.get(0).length())}, ${100 - ((compressedFiles.get(0).length() * 100)/f.length())}")
  }
}
