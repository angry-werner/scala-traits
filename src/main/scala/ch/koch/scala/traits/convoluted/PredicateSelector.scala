package ch.koch.scala.traits.convoluted

trait PredicateSelector:
  val predicateByKeySelector: (
      Predicate,
      Map[String, Predicate]
  ) => Option[Predicate]
