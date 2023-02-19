package ch.koch.scala.traits.convoluted.oneprediction

import ch.koch.scala.traits.convoluted.model.Prediction

trait OnePredictionSelector:
  val predictionByKeySelector: (
      Prediction,
      Map[String, Prediction]
  ) => Option[Prediction]
