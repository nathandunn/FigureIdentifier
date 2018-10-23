package org.bbop.inca.model

import java.io.{File, IOException}
import java.net.URL
import java.util.zip.Adler32

import org.apache.commons.io.FileUtils
import org.deeplearning4j.nn.graph.ComputationGraph
import org.deeplearning4j.util.ModelSerializer

class VG16CatDogModel extends Model {

  var MODEL_URL: String = "https://dl.dropboxusercontent.com/s/djmh91tk1bca4hz/RunEpoch_class_2_soft_10_32_1800.zip?dl=0"
  var LOCAL_MODEL: String = "resources/model.zip"

  var computationGraph: ComputationGraph = _
  var modelFile: File = _

  def loadModel(): ComputationGraph = {
    if (modelFile == null) downloadModel
    if (computationGraph != null) return computationGraph

    println( "model file "+modelFile.getAbsolutePath)
    computationGraph = ModelSerializer.restoreComputationGraph(modelFile)
    computationGraph
  }


  def downloadModel: File = {
    modelFile = new File(LOCAL_MODEL)
    if (!modelFile.exists() || FileUtils.checksum(modelFile, new Adler32()).getValue != 3082129141l) {
      modelFile.delete()

      def modelURL: URL = new URL(MODEL_URL)

      try {
        println("Copying URL to file")
        FileUtils.copyURLToFile(modelURL, modelFile)
        println("Done copyingURL to file")
      } catch {
        case e: IOException =>
          Console.err.println("Exception while trying to create pdf document - " + e)
          throw new RuntimeException(e);
      }
    }
    modelFile
  }

}
