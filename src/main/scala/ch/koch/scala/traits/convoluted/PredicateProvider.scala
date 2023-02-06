package ch.koch.scala.traits.convoluted

import scala.concurrent.Future

trait PredicateProvider:
  val futurePredicates: Future[Map[String, Predicate]]
