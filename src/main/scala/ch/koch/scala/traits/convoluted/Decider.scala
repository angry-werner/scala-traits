package ch.koch.scala.traits.convoluted
import scala.concurrent.Future

trait Decider:
  def apply(theNewPrediction: Prediction): Future[Boolean]
