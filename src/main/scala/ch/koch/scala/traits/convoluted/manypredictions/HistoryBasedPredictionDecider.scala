package ch.koch.scala.traits.convoluted.manypredictions

import ch.koch.scala.traits.convoluted.model.Prediction
import ch.koch.scala.traits.convoluted.{Decider, PredictionProvider}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait HistoryBasedPredictionDecider
    extends Decider
    with PredictionProvider
    with ManyPredictionsSelector
    with HistoryBasedPredictionCaseManager:

  override def apply(theNewPrediction: Prediction): Future[Boolean] =
    pastPredictions.map { predictions =>
      val historyPredictions: List[Prediction] = predictionsSelector(theNewPrediction, predictions)
      casemanager(theNewPrediction, historyPredictions)
    }
