package com.bselzer.gw2.v2.client.validation

import com.bselzer.ktx.logging.Logger

data class UnsuccessfulResult(val cause: Throwable? = null, val message: () -> String) : ValidationResult {
    internal fun log() = Logger.e(cause, message)
}