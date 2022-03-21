package com.bselzer.gw2.v2.model.template.equipment

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The position of the tab.
 */
@Serializable
@JvmInline
value class EquipmentTemplateTabId(override val value: Int = 0) : IntIdentifier