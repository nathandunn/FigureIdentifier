package org.bbop.inca.predictor

import java.io.File

import org.bbop.inca.catdog.PetType
import org.bbop.inca.catdog.PetType.PetType

class CatDogPredictor extends Predictor {

  def predict(file: File,threshold:Double):PetType = {
    PetType.DOG
  }

}
