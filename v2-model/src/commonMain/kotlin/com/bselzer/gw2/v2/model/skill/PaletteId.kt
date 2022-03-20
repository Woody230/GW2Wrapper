package com.bselzer.gw2.v2.model.skill

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The id of a [Skill] for build templates.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">skills</a>
 * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Build_template_link">build template chat link</a>
 */
@Serializable
@JvmInline
value class PaletteId(override val value: Int = 0) : IntIdentifier