package com.bselzer.gw2.v2.client.result

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import io.ktor.client.statement.*

sealed class Gw2Result {
    class Success(val response: HttpResponse) : Gw2Result()
    sealed class Failure(val message: String) : Gw2Result() {
        /**
         * Failed to make the request.
         */
        class Request(message: String, val cause: Throwable? = null) : Failure(message)

        /**
         * Successfully made the request, but the response is unsuccessful.
         */
        class Response(message: String, val error: HttpError) : Failure(message)

        fun exception(): Gw2ClientException = when (this) {
            is Request -> Gw2ClientException(message, cause)
            is Response -> Gw2ClientException("$message $error")
        }
    }
}