package com.bselzer.gw2.v2.client.validation

data class UnsuccessfulResult(val message: String, val cause: Throwable? = null) : ValidationResult