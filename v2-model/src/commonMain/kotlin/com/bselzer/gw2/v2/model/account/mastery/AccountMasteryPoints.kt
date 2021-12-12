package com.bselzer.gw2.v2.model.account.mastery

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountMasteryPoints(
    /**
     * The regions and their associated mastery point totals.
     */
    @SerialName("totals")
    val regions: List<AccountMasteryRegion> = emptyList(),

    /**
     * The ids of the unlocked masteries.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    @SerialName("unlocked")
    val unlocked: List<Int> = emptyList()
)