package ch.koch.scala.traits.convoluted.predictionproviderimpl

import ch.koch.scala.traits.convoluted.{Prediction, PredictionProvider}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait FromMapPredictionProvider(staticPredictions: Map[String, Prediction]) extends PredictionProvider:
  override val pastPredictions: Future[Map[String, Prediction]] = Future(
    staticPredictions
  )
