package ch.koch.scala.traits.convoluted

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait DBPredictionProvider() extends PredictionProvider:
  override val futurePredictions: Future[Map[String, Prediction]] =
    Future(Map("a" -> Prediction("a", 42), "c" -> Prediction("c", 23)))
