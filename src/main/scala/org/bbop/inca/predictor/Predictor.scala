package org.bbop.inca.predictor

import java.io.File

import org.bbop.inca.catdog.PetType.PetType

trait Predictor {
  def predict(file: File,threshold:Double):Object
}
