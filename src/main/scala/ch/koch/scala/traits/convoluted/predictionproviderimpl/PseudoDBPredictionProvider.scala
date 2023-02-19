package ch.koch.scala.traits.convoluted.predictionproviderimpl

import ch.koch.scala.traits.convoluted.{Prediction, PredictionProvider}

import java.util.Date
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait PseudoDBPredictionProvider() extends PredictionProvider:
  override val pastPredictions: Future[Map[String, Prediction]] =
    Future(Map("a" -> Prediction("a", 42, new Date()), "c" -> Prediction("c", 23, new Date())))
