package com.bselzer.gw2.v2.model.build

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable

@Serializable
value class BuildId(override val value: Int = 0) : IntIdentifier