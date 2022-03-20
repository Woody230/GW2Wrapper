package com.bselzer.gw2.v2.model.character.bag

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable

@Serializable
value class BagId(override val value: Int = 0) : IntIdentifier