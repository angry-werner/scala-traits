package ch.koch.scala.traits.convoluted.impl

import ch.koch.scala.traits.convoluted.PredictionProvider
import ch.koch.scala.traits.convoluted.model.Prediction

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait FromMapPredictionProvider(staticPredictions: Map[String, Prediction]) extends PredictionProvider:
  override val pastPredictions: Future[Map[String, Prediction]] = Future(
    staticPredictions
  )
