package ch.koch.scala.traits.convoluted

trait PredictionSelector:
  val predictionByKeySelector: (
      Prediction,
      Map[String, Prediction]
  ) => Option[Prediction]
