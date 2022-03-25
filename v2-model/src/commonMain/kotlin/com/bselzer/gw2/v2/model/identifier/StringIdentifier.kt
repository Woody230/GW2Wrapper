package com.bselzer.gw2.v2.model.identifier

interface StringIdentifier : Identifier<String> {
    override val isDefault: Boolean
        get() = value.isBlank()

    fun compareTo(other: String): Int = value.compareTo(other)
    fun compareTo(other: Identifier<String>): Int = value.compareTo(other.value)
}