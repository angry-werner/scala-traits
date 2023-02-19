package ch.koch.scala.traits.convoluted

import munit.Clue.generate
import munit.FunSuite

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

class ConcreteChangedPredictionDeciderSpec extends FunSuite:
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

    forceDecision(true, Prediction("b", 0))
    forceDecision(false, Prediction("a", 23))
    forceDecision(true, Prediction("c", 43))
  }

private case class Testee()
    extends ChangedPredictionDecider
    with FromMapPredictionProvider(
      Map("a" -> Prediction("a", 23), "c" -> Prediction("c", 42))
    )
    with PredictionByKeySelector
    with SimpleCaseManager
