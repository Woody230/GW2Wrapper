package com.bselzer.gw2.v2.model.home.node

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class NodeId(override val value: String = "") : StringIdentifier