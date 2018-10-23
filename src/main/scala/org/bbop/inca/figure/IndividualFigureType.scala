package org.bbop.inca.figure

object IndividualFigureType extends Enumeration {
  type IndividualFigureType = Value
  val
  IMAGE,
  MICROSCOPE_IMAGE,
  BRAIN_IMAGE,
  CHART, // general
  LINE_CHART,
  BAR_CHART,
  DIAGRAM,
  MAP,
  OTHER,
  NOT_KNOWN = Value
}
