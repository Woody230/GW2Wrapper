package com.bselzer.gw2.v2.client.exception

/**
 * An exception that occurs during validation of the response.
 */
class ValidationException : ResponseException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}