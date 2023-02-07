package ch.koch.scala.traits.convoluted

trait SimpleCaseManager extends CaseManager:
  override val caseManager: (Prediction, Option[Prediction]) => Boolean =
    (predicate: Prediction, maybePrediction: Option[Prediction]) =>
      maybePrediction match
        case Some(alreadyDeliveredPrediction) =>
          predicate.value != alreadyDeliveredPrediction.value
        case _ => true
