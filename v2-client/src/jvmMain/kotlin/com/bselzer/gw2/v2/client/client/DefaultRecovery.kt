package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.model.extension.base.Identifiable

/**
 * Represents recovery by defaulting by reflection.
 */
actual class DefaultRecovery actual constructor() {
    /**
     * Creates a new instance from an optional constructor.
     */
    actual inline fun <reified T> defaultSingle(): T {
        val constructor = T::class.constructors.find { it.parameters.all { parameter -> parameter.isOptional } }
            ?: throw NotImplementedError("Default recovery mode: ${T::class} is missing a completely optional constructor")

        return constructor.callBy(emptyMap())
    }

    /**
     * Creates a new instance from an optional constructor with the id populated.
     */
    actual inline fun <reified T : Identifiable<Id>, Id> defaultSingle(id: Id): T {
        val constructor = T::class.constructors.find { it.parameters.all { parameter -> parameter.isOptional } }
            ?: throw NotImplementedError("Default recovery mode: ${T::class} is missing a completely optional constructor")

        val idParameter = constructor.parameters.firstOrNull { parameter -> parameter.name == "id" }
            ?: throw Exception("Default recovery mode: ${T::class} is missing the id parameter with a name of 'id'.")

        // Populate the id instead of leaving it defaulted.
        return constructor.callBy(mapOf(idParameter to id))
    }
}