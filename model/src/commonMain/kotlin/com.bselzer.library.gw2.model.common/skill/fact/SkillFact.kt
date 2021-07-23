package com.bselzer.library.gw2.model.common.skill.fact

import com.bselzer.library.gw2.model.common.AttributeName
import com.bselzer.library.gw2.model.common.combo.ComboFieldName
import com.bselzer.library.gw2.model.common.combo.ComboFinisherName
import com.bselzer.library.kotlin.extension.serialization.common.serializer.IntegerSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SkillFact(
    @SerialName("text")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("type")
    val type: SkillFactType? = null,

    // NOTE: This can be an int OR a bool. Ex: range -> int, unblockable -> bool
    @Serializable(with = IntegerSerializer::class)
    @SerialName("value")
    val value: Int = 0,

    @SerialName("target")
    val target: AttributeName? = null, // Attribute affected

    @SerialName("status")
    val effect: String = "",

    @SerialName("description")
    val effectDescription: String = "",

    @SerialName("apply_count")
    val stacksApplied: Int = 0,

    // NOTE: some facts want to display the buff icon with text and do so with a duration = 0 or an omitted duration
    @SerialName("duration")
    val duration: Int = 0,

    @SerialName("field_type")
    val comboField: ComboFieldName? = null,

    @SerialName("finisher_type")
    val comboFinisher: ComboFinisherName? = null,

    @SerialName("percent")
    val percent: Double = 0.0,

    @SerialName("hit_count")
    val hitCount: Int = 0,

    @SerialName("dmg_multiplier")
    val damageMultiplier: Double = 0.0,

    @SerialName("distance")
    val distance: Int = 0,

    @SerialName("prefix")
    val prefix: Prefix = Prefix()
)
