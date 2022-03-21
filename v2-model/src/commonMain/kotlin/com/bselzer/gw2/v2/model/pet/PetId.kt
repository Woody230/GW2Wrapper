package com.bselzer.gw2.v2.model.pet

import com.bselzer.gw2.v2.model.identifier.IntIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The id of a pet.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pets">the wiki</a>
 */
@Serializable
@JvmInline
value class PetId(override val value: Int = 0) : IntIdentifier {
    override fun toString(): String = value.toString()
}