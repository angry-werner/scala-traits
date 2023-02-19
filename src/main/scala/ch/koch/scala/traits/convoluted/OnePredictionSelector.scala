package ch.koch.scala.traits.convoluted

trait OnePredictionSelector:
  val predictionByKeySelector: (
      Prediction,
      Map[String, Prediction]
  ) => Option[Prediction]
