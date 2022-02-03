package fr.khalypso.statesearchlib.model.exception

import java.lang.RuntimeException

/**
 * Exception thrown when an [fr.khalypso.statesearchlib.model.Operator] can not be applied to a [fr.khalypso.statesearchlib.model.State].
 */
class OperatorApplicationException : RuntimeException("The operator can not be applied to the current state")
