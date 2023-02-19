package ch.koch.scala.traits.convoluted.oneprediction

import ch.koch.scala.traits.convoluted.model.Prediction
import ch.koch.scala.traits.convoluted.oneprediction.LastChangedOneOnePredictionDecider
import ch.koch.scala.traits.convoluted.impl.FromMapPredictionProvider
import ch.koch.scala.traits.convoluted.oneprediction.impl.{
  SimpleOnePredictionCaseManagerOnePrediction,
  SinglePredictionByKeySelector
}
import munit.Clue.generate
import munit.FunSuite

import java.util.Date
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}

class ConcreteLastChangedOnePredictionDeciderSpec extends FunSuite:
  test("Happy case") {
    val testee = Testee()

    def forceDecision(
        expectedDecision: Boolean,
        prediction: Prediction
    ): Unit =
      val result = Await.ready(testee(prediction), Duration.Inf).value.get
      result match
        case Success(deliverIt: Boolean) =>
          assert(deliverIt == expectedDecision)
        case Failure(e) => fail(s"We screwed up with: $e")

    forceDecision(true, Prediction("b", 0, new Date()))
    forceDecision(false, Prediction("a", 23, new Date()))
    forceDecision(true, Prediction("c", 43, new Date()))
  }

private case class Testee()
    extends LastChangedOneOnePredictionDecider
    with FromMapPredictionProvider(
      Map("a" -> Prediction("a", 23, new Date()), "c" -> Prediction("c", 42, new Date()))
    )
    with SinglePredictionByKeySelector
    with SimpleOnePredictionCaseManagerOnePrediction
