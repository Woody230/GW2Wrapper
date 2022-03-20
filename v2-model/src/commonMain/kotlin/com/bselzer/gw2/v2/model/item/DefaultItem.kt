package com.bselzer.gw2.v2.model.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Default")
class DefaultItem(private val identifier: ItemId = ItemId()) : Item(id = identifier)