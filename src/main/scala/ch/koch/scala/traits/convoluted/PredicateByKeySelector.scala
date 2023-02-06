package ch.koch.scala.traits.convoluted

trait PredicateByKeySelector extends PredicateSelector:
  override val predicateByKeySelector
      : (Predicate, Map[String, Predicate]) => Option[Predicate] =
    (selector: Predicate, predicates: Map[String, Predicate]) =>
      predicates.get(selector.name)
