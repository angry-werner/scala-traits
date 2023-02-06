package ch.koch.scala.traits.convoluted

trait SimpleCaseManager extends CaseManager:
  override val caseManager: (Predicate, Option[Predicate]) => Boolean =
    (predicate: Predicate, probablyPredicate: Option[Predicate]) =>
      probablyPredicate match {
        case Some(alreadyDeliveredPredicate) =>
          predicate.value != alreadyDeliveredPredicate.value
        case _ => false
      }
