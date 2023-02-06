package ch.koch.scala.traits.convoluted

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

trait Decider extends PredicateProvider with PredicateSelector with CaseManager:

  def apply(theNewPredicate: Predicate): Future[Boolean] =
    futurePredicates.map { predicates =>
      val lastDeliveredPredicate: Option[Predicate] =
        predicateByKeySelector(theNewPredicate, predicates)
      caseManager(theNewPredicate, lastDeliveredPredicate)
    }
