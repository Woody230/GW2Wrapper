package com.bselzer.gw2.v2.client.result

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import io.ktor.client.statement.*

sealed class GetResult<Model> {
    class Success<Model>(val response: HttpResponse, val body: Model) : GetResult<Model>()
    sealed class Failure<Model> : GetResult<Model>() {
        /**
         * Failed to make a successful request.
         */
        class Gw2<Model>(val failure: Gw2Result.Failure) : Failure<Model>()

        /**
         * Unable to convert the response body into the [Model].
         */
        class Serialization<Model>(val response: HttpResponse, val message: String, val cause: Throwable? = null) : Failure<Model>()

        /**
         * Unable to convert from an intermediate model into the result [Model].
         */
        class Conversion<Model>(val response: HttpResponse, val message: String, val cause: Throwable? = null) : Failure<Model>()

        fun exception(): Gw2ClientException = when (this) {
            is Gw2<Model> -> failure.exception()
            is Serialization<Model> -> Gw2ClientException(message, cause)
            is Conversion<Model> -> Gw2ClientException(message, cause)
        }

        @PublishedApi
        internal fun <OtherModel> persistFailure(): Failure<OtherModel> = when (this) {
            is Gw2<Model> -> Gw2(failure)
            is Serialization<Model> -> Serialization(response, message, cause)
            is Conversion<Model> -> Conversion(response, message, cause)
        }
    }

    fun getOrThrow(): Model = when (this) {
        is Success -> body
        is Failure -> throw exception()
    }

    fun getOrNull(): Model? = when (this) {
        is Success -> body
        else -> null
    }
}