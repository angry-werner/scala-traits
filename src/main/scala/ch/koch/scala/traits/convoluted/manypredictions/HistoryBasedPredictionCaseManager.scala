package ch.koch.scala.traits.convoluted.manypredictions

import ch.koch.scala.traits.convoluted.model.Prediction

trait HistoryBasedPredictionCaseManager:
  val casemanager: (Prediction, List[Prediction]) => Boolean
