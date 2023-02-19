package ch.koch.scala.traits.convoluted.onepredictionimpl

import ch.koch.scala.traits.convoluted.{OnePredictionCaseManager, Prediction}

trait SimpleOnePredictionCaseManagerOnePrediction extends OnePredictionCaseManager:
  override val caseManager: (Prediction, Option[Prediction]) => Boolean =
    (predicate: Prediction, maybePrediction: Option[Prediction]) =>
      maybePrediction match
        case Some(alreadyDeliveredPrediction) =>
          predicate.value != alreadyDeliveredPrediction.value
        case _ => true
