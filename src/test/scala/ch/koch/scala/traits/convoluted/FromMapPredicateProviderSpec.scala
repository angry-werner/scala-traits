package ch.koch.scala.traits.convoluted

import munit.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

class FromMapPredicateProviderSpec extends FunSuite:
  test("Happy case wired up") {
    class Testee extends FromMapPredicateProvider(Map())
    val result =
      Await.ready((new Testee).futurePredicates, Duration.Inf).value.get
    result match {
      case Success(predicates) => assert(predicates.size == 0)
      case Failure(e)          => fail(s"We screwed up with: $e")
    }
  }

  test("Happy case with content") {
    class Testee
        extends FromMapPredicateProvider(
          Map("a" -> Predicate("a", 23), "c" -> Predicate("c", 42))
        )
    val result =
      Await.ready((new Testee).futurePredicates, Duration.Inf).value.get
    result match {
      case Success(predicates) =>
        assert(predicates.size == 2)
        assert(predicates.get("a").get.value == 23)
        assert(predicates.get("c").get.value == 42)
      case Failure(e) => fail(s"We screwed up with: $e")
    }
  }
