package ch.koch.scala.traits.convoluted

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait DBPredicateProvider() extends PredicateProvider:
  override val futurePredicates: Future[Map[String, Predicate]] =
    Future(Map("a" -> Predicate("a", 42), "c" -> Predicate("c", 23)))
