package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.model.extension.base.Identifiable

/**
 * Represents recovery by defaulting.
 */
expect class DefaultRecovery() {
    /**
     * Creates a new default instance of a single object.
     */
    inline fun <reified T> defaultSingle(): T

    /**
     * Creates a new default instance of a single object with the id populated.
     */
    inline fun <reified T : Identifiable<Id>, Id> defaultSingle(id: Id): T
}