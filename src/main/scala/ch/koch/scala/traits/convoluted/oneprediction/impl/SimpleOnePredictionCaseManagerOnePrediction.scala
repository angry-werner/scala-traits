package ch.koch.scala.traits.convoluted.oneprediction.impl

import ch.koch.scala.traits.convoluted.model.Prediction
import ch.koch.scala.traits.convoluted.oneprediction.OnePredictionCaseManager

trait SimpleOnePredictionCaseManagerOnePrediction extends OnePredictionCaseManager:
  override val caseManager: (Prediction, Option[Prediction]) => Boolean =
    (predicate: Prediction, maybePrediction: Option[Prediction]) =>
      maybePrediction match
        case Some(alreadyDeliveredPrediction) =>
          predicate.value != alreadyDeliveredPrediction.value
        case _ => true
