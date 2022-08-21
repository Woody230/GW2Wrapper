package com.bselzer.gw2.v2.client.exception

open class Gw2ClientException : Exception {
    internal constructor() : super()
    internal constructor(message: String?) : super(message)
    internal constructor(message: String?, cause: Throwable?) : super(message, cause)
    internal constructor(cause: Throwable?) : super(cause)
}