package ch.koch.scala.traits.convoluted.oneprediction

import ch.koch.scala.traits.convoluted.model.Prediction

trait OnePredictionCaseManager:
  val caseManager: (Prediction, Option[Prediction]) => Boolean
