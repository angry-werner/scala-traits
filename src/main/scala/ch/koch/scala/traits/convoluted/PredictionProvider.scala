package ch.koch.scala.traits.convoluted

import scala.concurrent.Future

trait PredictionProvider:
  val futurePredictions: Future[Map[String, Prediction]]
