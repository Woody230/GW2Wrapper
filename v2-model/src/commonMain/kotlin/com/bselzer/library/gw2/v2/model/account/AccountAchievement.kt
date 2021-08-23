package com.bselzer.library.gw2.v2.model.account

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.gw2.v2.scope.core.Permission
import com.bselzer.library.gw2.v2.scope.core.Requirement
import com.bselzer.library.gw2.v2.scope.core.Scope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The account achievement information.
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
@Serializable
data class AccountAchievement(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * Reference ids indicating progress of the achievement.
     */
    @SerialName("bits")
    val bits: List<Int> = emptyList(),

    /**
     * The current progress of the achievement.
     */
    @SerialName("current")
    val current: Int = 0,

    /**
     * The amount of progress needed to complete the achievement.
     */
    @SerialName("max")
    val maximum: Int = 0,

    /**
     * Whether the achievement is complete.
     */
    @SerialName("done")
    val done: Boolean = false,

    /**
     * The number of times the achievement has been completed, if the achievement is repeatable.
     */
    @SerialName("repeated")
    val timesRepeated: Int = 0,

    /**
     * Whether the achievement is unlocked. Null if the achievement does not support locking.
     */
    @SerialName("unlocked")
    val unlocked: Boolean? = null
) : Identifiable<Int>