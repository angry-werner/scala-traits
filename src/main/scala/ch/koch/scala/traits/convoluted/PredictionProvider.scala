package ch.koch.scala.traits.convoluted

import scala.concurrent.Future

trait PredictionProvider:
  val pastPredictions: Future[Map[String, Prediction]]
