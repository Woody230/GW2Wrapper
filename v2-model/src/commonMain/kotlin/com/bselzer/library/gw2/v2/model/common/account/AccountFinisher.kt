package com.bselzer.library.gw2.v2.model.common.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountFinisher(
    /**
     * The id of the finisher.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0,

    /**
     * Whether the finisher is permanent or temporary.
     */
    @SerialName("permanent")
    val permanent: Boolean = false,

    /**
     * The number of uses, if the finisher is temporary.
     */
    @SerialName("quantity")
    val count: Int = 0
)