package ch.koch.scala.traits.convoluted

trait CaseManager:
  val caseManager: (Prediction, Option[Prediction]) => Boolean
