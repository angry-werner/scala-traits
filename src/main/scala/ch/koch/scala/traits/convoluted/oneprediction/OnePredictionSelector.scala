package ch.koch.scala.traits.convoluted.oneprediction

import ch.koch.scala.traits.convoluted.model.Prediction

trait OnePredictionSelector:
  val predictionSelector: (Prediction, Map[String, Prediction]) => Option[Prediction]
