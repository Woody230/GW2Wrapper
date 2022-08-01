package com.bselzer.gw2.v2.client.exception

class AggregateException(
    override val message: String? = null,
    vararg val causes: Throwable
) : Gw2ClientException(message, causes.firstOrNull())