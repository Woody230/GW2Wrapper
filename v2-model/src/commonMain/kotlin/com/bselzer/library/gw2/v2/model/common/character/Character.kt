package com.bselzer.library.gw2.v2.model.common.character

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.model.common.serialization.SecondDurationSerializer
import com.bselzer.library.kotlin.extension.datetime.common.function.minValue
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Serializable
data class Character constructor(
    /**
     * The ids of the backstory answers to character creation questions.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("backstory")
    val backstory: List<String> = emptyList(),

    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("name")
    val name: String = "",

    /**
     * The name of the race.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("race")
    val race: String = "",

    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("gender")
    val gender: String = "",

    /**
     * The name of the profession.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("profession")
    val profession: String = "",

    /**
     * The level from 1 to 80.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("level")
    val level: Int = 1,

    /**
     * The guild id in the form of a UUID.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("guild")
    val guild: String = "",

    /**
     * The amount of seconds the character has been played.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @Serializable(with = SecondDurationSerializer::class)
    @SerialName("age")
    val playedFor: Duration = Duration.ZERO,

    /**
     * The creation time.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("created")
    val createdAt: LocalDateTime = LocalDateTime.minValue(),

    /**
     * The number of times the character has been defeated.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("deaths")
    val deathCount: Int = 0,

    /**
     * The id of the character's currently selected title.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("title")
    val title: Int = 0,

    /**
     * The crafting disciplines the character has unlocked.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("crafting")
    val crafting: List<CharacterCrafting> = emptyList(),

    /**
     * The equipped items.
     */
    // TODO multiple required scopes => verify any set is valid
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.INVENTORIES)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.BUILDS)
    @SerialName("equipment")
    val equipment: List<CharacterEquipment> = emptyList(),

    /**
     * The ids of the skill challenges.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.PROGRESSION)
    @SerialName("heropoints")
    val heropoints: List<String> = emptyList(),

    /**
     * The equipped bags.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.INVENTORIES)
    @SerialName("bags")
    val bags: List<Bag?> = emptyList(),

    /**
     * The ids of the unlocked recipes. Note that recipes have been account bound since the July 26, 2016 release.
     * @see <a href="https://github.com/arenanet/api-cdi/blob/master/v2/characters/characters.js">the cdi</a>
     * @see <a href="https://wiki.guildwars2.com/wiki/Game_updates/2016-07-26#Update_-_July_26.2C_2016">the release notes</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.INVENTORIES)
    @SerialName("recipes")
    val recipes: List<Int> = emptyList(),

    /**
     * The skills in each game mode.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.BUILDS)
    @SerialName("skills")
    val skills: ModeSkills = ModeSkills(),

    /**
     * The specializations and traits in each game mode.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.BUILDS)
    @SerialName("specializations")
    val specializations: ModeSpecializations = ModeSpecializations(),

    /**
     * The skill tree trainings.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.BUILDS)
    @SerialName("trainings")
    val trainings: List<CharacterTraining> = emptyList(),

    /**
     * The world vs. world ability progression.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.PROGRESSION)
    @SerialName("wvw_abilities")
    val wvwAbilities: List<WvwAbility> = emptyList(),

    /**
     * The player vs. player equipment.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.PROGRESSION)
    @SerialName("equipment_pvp")
    val pvpEquipment: PvpEquipment = PvpEquipment(),

    @SerialName("flags")
    val flags: List<String> = emptyList()
)