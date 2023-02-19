package ch.koch.scala.traits.convoluted

trait OnePredictionCaseManager:
  val caseManager: (Prediction, Option[Prediction]) => Boolean
