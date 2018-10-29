package org.bbop.inca.predictor

import java.io.{File, FileInputStream}

import org.bbop.inca.figure.IndividualFigureType
import org.bbop.inca.figure.IndividualFigureType.IndividualFigureType
import org.bbop.inca.model.VG16CatDogModel
import org.datavec.image.loader.NativeImageLoader
import org.deeplearning4j.nn.graph.ComputationGraph
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.dataset.api.preprocessor.{DataNormalization, VGG16ImagePreProcessor}

/**
  * TODO: rewrite for the proper predictor
  */
class SingleImagePredictor extends Predictor {

  var computationGraph: ComputationGraph = _
  val model: VG16CatDogModel = new VG16CatDogModel

  def predict(file: File, threshold: Double): IndividualFigureType = {

    computationGraph = model.loadModel()

    val loader: NativeImageLoader = new NativeImageLoader(224, 224, 3)
    val image: INDArray = loader.asMatrix(new FileInputStream(file))
    val scaler: DataNormalization = new VGG16ImagePreProcessor()
    scaler.transform(image)
    val output: INDArray = computationGraph.outputSingle(false, image)
    if (output.getDouble(0) > threshold) {
      return IndividualFigureType.IMAGE
    } else if (output.getDouble(1) > threshold) {
      return IndividualFigureType.OTHER
    } else {
      return IndividualFigureType.NOT_KNOWN
    }
  }

}
