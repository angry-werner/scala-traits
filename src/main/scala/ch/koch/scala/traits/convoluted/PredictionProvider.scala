package ch.koch.scala.traits.convoluted

import ch.koch.scala.traits.convoluted.model.Prediction

import scala.concurrent.Future

trait PredictionProvider:
  val pastPredictions: Future[Map[String, Prediction]]
