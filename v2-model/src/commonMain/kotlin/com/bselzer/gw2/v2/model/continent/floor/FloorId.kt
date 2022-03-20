package com.bselzer.gw2.v2.model.continent.floor

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable

@Serializable
value class FloorId(override val value: Int = 0) : IntIdentifier