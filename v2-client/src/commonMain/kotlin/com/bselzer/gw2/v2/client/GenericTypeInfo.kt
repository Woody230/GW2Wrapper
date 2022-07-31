package com.bselzer.gw2.v2.client

import io.ktor.util.reflect.*
import kotlin.jvm.JvmInline

/**
 * A wrapper for enforcing the type associated with the reified usage of the [typeInfo] method.
 */
@JvmInline
@Suppress("UNUSED")
value class GenericTypeInfo<Model> @PublishedApi internal constructor(val value: TypeInfo) {
    internal fun toDisplayableString() = with(value) { kotlinType ?: type.simpleName }
}

inline fun <reified Model> genericTypeInfo(): GenericTypeInfo<Model> = GenericTypeInfo(typeInfo<Model>())