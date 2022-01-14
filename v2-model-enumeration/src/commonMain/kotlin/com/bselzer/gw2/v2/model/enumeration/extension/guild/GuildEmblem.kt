package com.bselzer.gw2.v2.model.enumeration.extension.guild

import com.bselzer.gw2.v2.model.enumeration.guild.GuildEmblemFlag
import com.bselzer.gw2.v2.model.guild.emblem.GuildEmblem
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [GuildEmblem.flags] as a collection of [GuildEmblemFlag]
 */
fun GuildEmblem.flags(): List<GuildEmblemFlag> = flags.validEnumValues()