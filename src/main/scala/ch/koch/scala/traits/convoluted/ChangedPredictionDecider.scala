package ch.koch.scala.traits.convoluted

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

trait ChangedPredictionDecider
    extends PredictionProvider
    with PredictionSelector
    with CaseManager:

  def apply(theNewPrediction: Prediction): Future[Boolean] =
    futurePredictions.map { predictions =>
      val maybeLastDeliveredPrediction: Option[Prediction] =
        predictionByKeySelector(theNewPrediction, predictions)
      caseManager(theNewPrediction, maybeLastDeliveredPrediction)
    }
