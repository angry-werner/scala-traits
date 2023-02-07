package ch.koch.scala.traits.convoluted

import munit.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

class FromMapPredictionProviderSpec extends FunSuite:
  test("Happy case wired up") {
    case class Testee() extends FromMapPredictionProvider(Map())
    val result =
      Await.ready(Testee().futurePredictions, Duration.Inf).value.get
    result match
      case Success(predictions) => assert(predictions.size == 0)
      case Failure(e)           => fail(s"We screwed up with: $e")
  }

  test("Happy case with content") {
    case class Testee()
        extends FromMapPredictionProvider(
          Map("a" -> Prediction("a", 23), "c" -> Prediction("c", 42))
        )
    val result =
      Await.ready(Testee().futurePredictions, Duration.Inf).value.get
    result match
      case Success(predictions) =>
        assert(predictions.size == 2)
        assert(predictions.get("a").get.value == 23)
        assert(predictions.get("c").get.value == 42)
      case Failure(e) => fail(s"We screwed up with: $e")
  }
