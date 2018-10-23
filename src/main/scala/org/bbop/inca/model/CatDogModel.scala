package org.bbop.inca.model

import java.io.{File, IOException}
import java.net.URL
import java.util.zip.Adler32

import org.apache.commons.io.FileUtils

class CatDogModel extends Model {

  var MODEL_URL: String = "https://dl.dropboxusercontent.com/s/djmh91tk1bca4hz/RunEpoch_class_2_soft_10_32_1800.zip?dl=0"


  def loadModel: File = {
    def model: File = new File("resources/model.zip");
    if (!model.exists() || FileUtils.checksum(model, new Adler32()).getValue() != 3082129141l) {
      model.delete()

      def modelURL: URL = new URL(MODEL_URL)

      try {
        println("Copying URL to file")
        FileUtils.copyURLToFile(modelURL, model)
        println("Done copyingURL to file")
      } catch {
        case e: IOException =>
          Console.err.println("Exception while trying to create pdf document - " + e)
          throw new RuntimeException(e);
      }
    }
    model
  }

}
