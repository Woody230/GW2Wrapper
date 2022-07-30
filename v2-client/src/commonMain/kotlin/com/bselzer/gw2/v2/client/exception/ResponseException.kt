package com.bselzer.gw2.v2.client.exception

/**
 * An exception that occurs while trying to handle the response.
 */
open class ResponseException : Gw2ClientException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}