package com.bselzer.gw2.v2.model.character

import com.bselzer.gw2.v2.model.backstory.answer.BackstoryAnswerId
import com.bselzer.gw2.v2.model.character.bag.Bag
import com.bselzer.gw2.v2.model.character.equipment.CharacterEquipment
import com.bselzer.gw2.v2.model.character.progression.CharacterCrafting
import com.bselzer.gw2.v2.model.character.progression.CharacterTraining
import com.bselzer.gw2.v2.model.character.pvp.CharacterPvpEquipment
import com.bselzer.gw2.v2.model.character.skill.CharacterModeSkills
import com.bselzer.gw2.v2.model.character.specialization.CharacterModeSpecializations
import com.bselzer.gw2.v2.model.character.wvw.CharacterWvwAbility
import com.bselzer.gw2.v2.model.continent.map.challenge.HeroChallengeId
import com.bselzer.gw2.v2.model.guild.GuildId
import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.profession.ProfessionId
import com.bselzer.gw2.v2.model.race.RaceId
import com.bselzer.gw2.v2.model.recipe.RecipeId
import com.bselzer.gw2.v2.model.title.TitleId
import com.bselzer.gw2.v2.model.wrapper.CharacterFlag
import com.bselzer.gw2.v2.model.wrapper.Gender
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.ktx.datetime.serialization.SecondDurationSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
data class Character(
    /**
     * The ids of the backstory answers to character creation questions.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("backstory")
    val backstory: List<BackstoryAnswerId> = emptyList(),

    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("name")
    val name: CharacterName = CharacterName(),

    /**
     * The name of the race.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("race")
    val race: RaceId = RaceId(),

    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("gender")
    val gender: Gender = Gender(),

    /**
     * The name of the profession.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    @SerialName("profession")
    val profession: ProfessionId = ProfessionId(),

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
    val guild: GuildId = GuildId(),

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
    val createdAt: Instant = Instant.DISTANT_PAST,

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
    val title: TitleId = TitleId(),

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
    val heropoints: List<HeroChallengeId> = emptyList(),

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
    val recipes: List<RecipeId> = emptyList(),

    /**
     * The skills in each game mode.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.BUILDS)
    @SerialName("skills")
    val skills: CharacterModeSkills = CharacterModeSkills(),

    /**
     * The specializations and traits in each game mode.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.BUILDS)
    @SerialName("specializations")
    val specializations: CharacterModeSpecializations = CharacterModeSpecializations(),

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
    val wvwAbilities: List<CharacterWvwAbility> = emptyList(),

    /**
     * The player vs. player equipment.
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.PROGRESSION)
    @SerialName("equipment_pvp")
    val pvpEquipment: CharacterPvpEquipment = CharacterPvpEquipment(),

    @SerialName("flags")
    val flags: List<CharacterFlag> = emptyList()
) : Identifiable<String> {
    override val id: CharacterName = name
}