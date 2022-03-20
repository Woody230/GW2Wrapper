package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.bearer
import com.bselzer.gw2.v2.model.account.build.BuildTemplateTab
import com.bselzer.gw2.v2.model.account.equipment.EquipmentTemplateTab
import com.bselzer.gw2.v2.model.character.*
import com.bselzer.gw2.v2.model.character.bag.Bag
import com.bselzer.gw2.v2.model.character.progression.CharacterCrafting
import com.bselzer.gw2.v2.model.character.progression.CharacterTraining
import com.bselzer.gw2.v2.model.character.pve.CharacterEquipment
import com.bselzer.gw2.v2.model.character.skill.CharacterModeSkills
import com.bselzer.gw2.v2.model.character.specialization.CharacterModeSpecializations
import com.bselzer.gw2.v2.model.superadventurebox.SabProgress
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import io.ktor.client.*

// NOTE: most individual endpoints deserialize into a Character since they simply omit data from the overview as opposed to providing the unwrapped objects/arrays directly
/**
 * The character client. For information about characters for a specific account.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
@Scope(Requirement.OPTIONAL, Permission.BUILDS, Permission.INVENTORIES, Permission.PROGRESSION)
class CharacterClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val CHARACTERS = "characters"
        const val BUILD_TABS = "buildtabs"
        const val ACTIVE = "active"
        const val BACKSTORY = "backstory"
        const val CORE = "core"
        const val CRAFTING = "crafting"
        const val EQUIPMENT = "equipment"
        const val EQUIPMENT_TABS = "equipmenttabs"
        const val HEROPOINTS = "heropoints"
        const val INVENTORY = "inventory"
        const val QUESTS = "quests"
        const val RECIPES = "recipes"
        const val SUPER_ADVENTURE_BOX = "sab"
        const val SKILLS = "skills"
        const val SPECIALIZATIONS = "specializations"
        const val TRAINING = "training"
    }

    /**
     * @return the account's character names
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Response">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun ids(token: String? = null): List<String> = getList(path = CHARACTERS) {
        bearer(token)
    }

    /**
     * @return the character overview associated with the [name]. Excludes hero point and super adventure box information.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun overview(name: String, token: String? = null): Character = getIdentifiableSingle(name, path = "${CHARACTERS}/${name}", instance = { Character(name = it) }) {
        bearer(token)
    }

    /**
     * @return the character overviews associated with the [names]. Excludes hero point and super adventure box information.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun overviews(names: List<String>, token: String? = null): List<Character> = chunkedIds(names, CHARACTERS, instance = { Character(name = it) }) {
        bearer(token)
    }

    /**
     * @return all the character overviews. Excludes hero point and super adventure box information.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun overviews(token: String? = null): List<Character> = allIds(CHARACTERS) {
        bearer(token)
    }

    /**
     * @return the character with only the core information populated.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun core(name: String, token: String? = null): Character = character(name = name, subPath = CORE, token = token)

    /**
     * @return the backstory answer ids for the character with the given [name]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Backstory">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun backstory(name: String, token: String? = null): List<String> = character(name = name, subPath = BACKSTORY, token = token).backstory

    /**
     * @return the ids of the character's build template tabs
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/buildtabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun buildTabIds(name: String, token: String? = null): List<Int> = getList(path = "${CHARACTERS}/${name}/${BUILD_TABS}") {
        bearer(token)
    }

    /**
     * @return the build template tabs associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/buildtabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun buildTabs(name: String, ids: Collection<Int>, token: String? = null): List<BuildTemplateTab> =
        chunkedTabs(ids, "${CHARACTERS}/${name}/${BUILD_TABS}", instance = { BuildTemplateTab(id = it) }) {
            bearer(token)
        }

    /**
     * @return all the build template tabs
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/buildtabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun buildTabs(name: String, token: String? = null): List<BuildTemplateTab> = allTabs("${CHARACTERS}/${name}/${BUILD_TABS}") {
        bearer(token)
    }

    /**
     * @return the currently active build template tab
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/buildtabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun activeBuildTab(name: String, token: String? = null): BuildTemplateTab =
        getSingle(path = "${CHARACTERS}/${name}/${BUILD_TABS}/${ACTIVE}", instance = { BuildTemplateTab() }) {
            bearer(token)
        }

    /**
     * @return the unlocked crafting disciplines.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Crafting">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun crafting(name: String, token: String? = null): List<CharacterCrafting> = character(name = name, subPath = CRAFTING, token = token).crafting

    /**
     * @return the equipped items.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Equipment">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.ACCOUNT)
    suspend fun equipment(name: String, token: String? = null): List<CharacterEquipment> = character(name = name, subPath = EQUIPMENT, token = token).equipment

    /**
     * @return the ids of the character's equipment template tabs
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/equipmenttabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun equipmentTabIds(name: String, token: String? = null): List<Int> = getList(path = "${CHARACTERS}/${name}/${EQUIPMENT_TABS}") {
        bearer(token)
    }

    /**
     * @return the equipment template tabs associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/equipmenttabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun equipmentTabs(name: String, ids: Collection<Int>, token: String? = null): List<EquipmentTemplateTab> =
        chunkedTabs(ids, "${CHARACTERS}/${name}/${EQUIPMENT_TABS}", instance = { EquipmentTemplateTab(id = it) }) {
            bearer(token)
        }

    /**
     * @return all the equipment template tabs
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/equipmenttabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun equipmentTabs(name: String, token: String? = null): List<EquipmentTemplateTab> = allTabs("${CHARACTERS}/${name}/${EQUIPMENT_TABS}") {
        bearer(token)
    }

    /**
     * @return the currently active equipment template tab
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/equipmenttabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun activeEquipmentTab(name: String, token: String? = null): EquipmentTemplateTab =
        getSingle(path = "${CHARACTERS}/${name}/${EQUIPMENT_TABS}/${ACTIVE}", instance = { EquipmentTemplateTab() }) {
            bearer(token)
        }

    /**
     * @return the ids of the skill challenges.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Heropoints">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.PROGRESSION)
    suspend fun heroPoints(name: String, token: String? = null): List<String> = getList(path = "${CHARACTERS}/${name}/${HEROPOINTS}") {
        bearer(token)
    }

    /**
     * @return the equipped bags.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.INVENTORIES)
    suspend fun bags(name: String, token: String? = null): List<Bag?> = character(name = name, subPath = INVENTORY, token = token).bags

    /**
     * @return the skills in each game mode.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Skills">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun skills(name: String, token: String? = null): CharacterModeSkills = character(name = name, subPath = SKILLS, token = token).skills

    /**
     * @return the specializations in each game mode.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Specialization">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun specializations(name: String, token: String? = null): CharacterModeSpecializations =
        character(name = name, subPath = SPECIALIZATIONS, token = token).specializations

    /**
     * @return the skill tree trainings.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Training">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun trainings(name: String, token: String? = null): List<CharacterTraining> = character(name = name, subPath = TRAINING, token = token).trainings

    /**
     * @return the super adventure box progress.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Super_Adventure_Box_.28sab.29">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.CHARACTERS, Permission.PROGRESSION)
    suspend fun superAdventureBox(name: String, token: String? = null): SabProgress =
        getSingle(path = "${CHARACTERS}/${name}/${SUPER_ADVENTURE_BOX}", instance = { SabProgress() }) {
            bearer(token)
        }

    /**
     * @return the unlocked recipes. Note that recipes have been account bound since the July 26, 2016 release.
     * @see <a href="https://github.com/arenanet/api-cdi/blob/master/v2/characters/js">the cdi</a>
     * @see <a href="https://wiki.guildwars2.com/wiki/Game_updates/2016-07-26#Update_-_July_26.2C_2016">the release notes</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.INVENTORIES)
    suspend fun recipes(name: String, token: String? = null): List<Int> = character(name = name, subPath = RECIPES, token = token).recipes

    /**
     * @return the ids for quests related to the character's story progression
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/characters/:id/quests">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.PROGRESSION)
    suspend fun quests(name: String, token: String? = null): List<Int> = getList(path = "${CHARACTERS}/${name}/${QUESTS}") {
        bearer(token)
    }

    /**
     * Get an instance of a character with a partial population based on the [subpath] endpoint.
     */
    private suspend fun character(name: String, subPath: String, token: String? = null) =
        getIdentifiableSingle(id = name, path = "${CHARACTERS}/${name}/${subPath}", instance = { Character(name = it) }) {
            bearer(token)
        }
}