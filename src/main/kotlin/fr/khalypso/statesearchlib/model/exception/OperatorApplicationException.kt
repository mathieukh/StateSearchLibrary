package fr.khalypso.statesearchlib.model.exception

import java.lang.RuntimeException

/**
 * Exception thrown when an [Operator] can not be applied to a [State].
 */
class OperatorApplicationException : RuntimeException("The operator can not be applied to the current state")
