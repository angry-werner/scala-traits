package ch.koch.scala.traits.convoluted

trait PredictionByKeySelector extends PredictionSelector:
  override val predictionByKeySelector: (Prediction, Map[String, Prediction]) => Option[Prediction] =
    (selector: Prediction, predictions: Map[String, Prediction]) => predictions.get(selector.name)
