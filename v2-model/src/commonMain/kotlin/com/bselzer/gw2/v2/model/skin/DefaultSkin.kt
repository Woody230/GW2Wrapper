package com.bselzer.gw2.v2.model.skin

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Default")
class DefaultSkin(private val identifier: Int = 0) : Skin(id = identifier)