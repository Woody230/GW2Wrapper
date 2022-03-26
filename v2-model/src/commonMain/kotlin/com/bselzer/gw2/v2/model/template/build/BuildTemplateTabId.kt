package com.bselzer.gw2.v2.model.template.build

import com.bselzer.ktx.value.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The position of the tab.
 */
@Serializable
@JvmInline
value class BuildTemplateTabId(override val value: Int = 0) : IntIdentifier {
    override fun toString(): String = value.toString()
}