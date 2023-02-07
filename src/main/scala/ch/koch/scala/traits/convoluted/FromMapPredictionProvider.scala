package ch.koch.scala.traits.convoluted

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait FromMapPredictionProvider(staticPredictions: Map[String, Prediction])
    extends PredictionProvider:
  override val futurePredictions: Future[Map[String, Prediction]] = Future(
    staticPredictions
  )
