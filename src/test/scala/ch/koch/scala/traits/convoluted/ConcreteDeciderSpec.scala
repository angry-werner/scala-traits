package ch.koch.scala.traits.convoluted

import munit.Clue.generate
import munit.FunSuite

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

class ConcreteDeciderSpec extends FunSuite:
  test("Happy case") {
    class Testee
        extends Decider
        with FromMapPredictionProvider(
          Map("a" -> Prediction("a", 23), "c" -> Prediction("c", 42))
        )
        with PredictionByKeySelector
        with SimpleCaseManager
    val testee: Decider = new Testee
    val result =
      Await.ready(testee(Prediction("a", 15)), Duration.Inf).value.get
    result match {
      case Success(deliverIt: Boolean) => assert(deliverIt)
      case Failure(e)                  => fail(s"We screwed up with: $e")
    }
  }
