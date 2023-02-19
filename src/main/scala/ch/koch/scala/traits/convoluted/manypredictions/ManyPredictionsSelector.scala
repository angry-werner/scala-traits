package ch.koch.scala.traits.convoluted.manypredictions

import ch.koch.scala.traits.convoluted.model.Prediction

trait ManyPredictionsSelector:
  val predictionsSelector: (Prediction, Map[String, Prediction]) => List[Prediction]
