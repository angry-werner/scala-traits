package ch.koch.scala.traits.convoluted

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

trait LastChangedOneOnePredictionDecider
    extends Decider
    with PredictionProvider
    with OnePredictionSelector
    with OnePredictionCaseManager:

  def apply(theNewPrediction: Prediction): Future[Boolean] =
    pastPredictions.map { predictions =>
      val maybeLastDeliveredPrediction: Option[Prediction] =
        predictionByKeySelector(theNewPrediction, predictions)
      caseManager(theNewPrediction, maybeLastDeliveredPrediction)
    }
