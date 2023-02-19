package ch.koch.scala.traits.convoluted.onepredictionimpl

import ch.koch.scala.traits.convoluted.{Prediction, OnePredictionSelector}

trait SinglePredictionByKeySelector extends OnePredictionSelector:
  override val predictionByKeySelector: (Prediction, Map[String, Prediction]) => Option[Prediction] =
    (selector: Prediction, predictions: Map[String, Prediction]) => predictions.get(selector.name)
