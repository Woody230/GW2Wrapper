package com.bselzer.library.gw2.v2.model.common.achievement.daily

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The level requirements.
     */
    @SerialName("level")
    val level: DailyLevel = DailyLevel(),

    /**
     * The access requirement.
     *
     * @since 2019-05-16T00:00:00.000Z or later, the access object before this schema date is NOT supported by this wrapper
     */
    @SerialName("access")
    val access: DailyAccess = DailyAccess()
) : Identifiable<Int>