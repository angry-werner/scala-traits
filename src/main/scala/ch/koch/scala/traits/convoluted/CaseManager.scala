package ch.koch.scala.traits.convoluted

trait CaseManager:
  val caseManager: (Predicate, Option[Predicate]) => Boolean
