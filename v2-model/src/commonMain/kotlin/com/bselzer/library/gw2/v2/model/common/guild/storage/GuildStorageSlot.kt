package com.bselzer.library.gw2.v2.model.common.guild.storage

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildStorageSlot(
    /**
     * The id of the consumable.
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The number of the consumable in the stack.
     */
    @SerialName("count")
    val count: Int = 0
) : Identifiable<Int>