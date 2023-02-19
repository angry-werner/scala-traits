package ch.koch.scala.traits.convoluted.oneprediction.impl

import ch.koch.scala.traits.convoluted.model.Prediction
import ch.koch.scala.traits.convoluted.oneprediction.OnePredictionSelector

trait SinglePredictionByKeySelector extends OnePredictionSelector:
  override val predictionSelector: (Prediction, Map[String, Prediction]) => Option[Prediction] =
    (selector: Prediction, predictions: Map[String, Prediction]) => predictions.get(selector.name)
