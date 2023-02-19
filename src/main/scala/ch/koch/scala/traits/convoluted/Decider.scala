package ch.koch.scala.traits.convoluted
import ch.koch.scala.traits.convoluted.model.Prediction

import scala.concurrent.Future

trait Decider:
  def apply(theNewPrediction: Prediction): Future[Boolean]
