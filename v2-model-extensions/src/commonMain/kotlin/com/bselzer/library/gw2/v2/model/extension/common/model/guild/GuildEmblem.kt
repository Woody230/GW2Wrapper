package com.bselzer.library.gw2.v2.model.extension.common.model.guild

import com.bselzer.library.gw2.v2.model.common.guild.emblem.GuildEmblem
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.guild.GuildEmblemFlag
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [GuildEmblem.flags] as a collection of [GuildEmblemFlag]
 */
fun GuildEmblem.flags(): List<GuildEmblemFlag> = flags.validEnumValues()