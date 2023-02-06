package ch.koch.scala.traits.convoluted

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait FromMapPredicateProvider(staticPredicates: Map[String, Predicate])
    extends PredicateProvider:
  override val futurePredicates: Future[Map[String, Predicate]] = Future(
    staticPredicates
  )
