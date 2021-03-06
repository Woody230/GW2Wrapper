package com.bselzer.gw2.v2.model.quest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestGoal(
    /**
     * The description of the quest when active.
     */
    @SerialName("active")
    val active: String = "",

    /**
     * The description of the quest when complete.
     */
    @SerialName("complete")
    val complete: String = ""
)