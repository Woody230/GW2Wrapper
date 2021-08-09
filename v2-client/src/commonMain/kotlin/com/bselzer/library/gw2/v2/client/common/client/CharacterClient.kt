package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Characters
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.model.common.account.build.BuildTemplateTab
import com.bselzer.library.gw2.v2.model.common.account.build.EquipmentTemplateTab
import com.bselzer.library.gw2.v2.model.common.character.*
import com.bselzer.library.gw2.v2.model.common.character.superadventurebox.SabProgress
import io.ktor.client.*
import io.ktor.client.request.*

// NOTE: most individual endpoints deserialize into a Character since they simply omit data from the overview as opposed to providing the unwrapped objects/arrays directly
/**
 * The character client. For information about characters for a specific account.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
@Scope(Requirement.OPTIONAL, Permission.BUILDS, Permission.INVENTORIES, Permission.PROGRESSION)
class CharacterClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the account's character names
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Response">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun ids(token: String? = null): List<String> = httpClient.get(path = Characters.CHARACTERS) {
        ensureBearer(token)
    }

    /**
     * @return the character overview associated with the [name]. Excludes hero point and super adventure box information.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun overview(name: String, token: String? = null): Character = httpClient.get(path = "${Characters.CHARACTERS}/${name}") {
        ensureBearer(token)
    }

    /**
     * @return the character overviews associated with the [names]. Excludes hero point and super adventure box information.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun overviews(names: List<String>, token: String? = null): List<Character> = chunkedIds(names, Characters.CHARACTERS) {
        ensureBearer(token)
    }

    /**
     * @return all the character overviews. Excludes hero point and super adventure box information.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun overviews(token: String? = null): List<Character> = allIds(Characters.CHARACTERS) {
        ensureBearer(token)
    }

    /**
     * @return the character with only the core information populated.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun core(name: String, token: String? = null): Character = httpClient.get(path = "${Characters.CHARACTERS}/${name}/${Characters.CORE}") {
        ensureBearer(token)
    }

    /**
     * @return the backstory answer ids for the character with the given [name]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Backstory">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun backstory(name: String, token: String? = null): List<String> = httpClient.get<Character>(path = "${Characters.CHARACTERS}/${name}/${Characters.BACKSTORY}") {
        ensureBearer(token)
    }.backstory

    /**
     * @return the ids of the character's build template tabs
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/buildtabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun buildTabIds(name: String, token: String? = null): List<Int> = httpClient.get(path = "${Characters.CHARACTERS}/${name}/${Characters.BUILD_TABS}") {
        ensureBearer(token)
    }

    /**
     * @return the build template tabs associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/buildtabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun buildTabs(name: String, ids: Collection<Int>, token: String? = null): List<BuildTemplateTab> =
        chunkedTabs(ids, "${Characters.CHARACTERS}/${name}/${Characters.BUILD_TABS}") {
            ensureBearer(token)
        }

    /**
     * @return all the build template tabs
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/buildtabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun buildTabs(name: String, token: String? = null): List<BuildTemplateTab> = allTabs("${Characters.CHARACTERS}/${name}/${Characters.BUILD_TABS}") {
        ensureBearer(token)
    }

    /**
     * @return the currently active build template tab
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/buildtabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun activeBuildTab(name: String, token: String? = null): BuildTemplateTab =
        httpClient.get(path = "${Characters.CHARACTERS}/${name}/${Characters.BUILD_TABS}/${Characters.ACTIVE}") {
            ensureBearer(token)
        }

    /**
     * @return the unlocked crafting disciplines.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Crafting">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun crafting(name: String, token: String? = null): List<CharacterCrafting> =
        httpClient.get<Character>(path = "${Characters.CHARACTERS}/${name}/${Characters.CRAFTING}") {
            ensureBearer(token)
        }.crafting

    /**
     * @return the equipped items.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Equipment">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.ACCOUNT)
    suspend fun equipment(name: String, token: String? = null): List<CharacterEquipment> =
        httpClient.get<Character>(path = "${Characters.CHARACTERS}/${name}/${Characters.EQUIPMENT}") {
            ensureBearer(token)
        }.equipment

    /**
     * @return the ids of the character's equipment template tabs
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/equipmenttabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun equipmentTabIds(name: String, token: String? = null): List<Int> = httpClient.get(path = "${Characters.CHARACTERS}/${name}/${Characters.EQUIPMENT_TABS}") {
        ensureBearer(token)
    }

    /**
     * @return the equipment template tabs associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/equipmenttabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun equipmentTabs(name: String, ids: Collection<Int>, token: String? = null): List<EquipmentTemplateTab> =
        chunkedTabs(ids, "${Characters.CHARACTERS}/${name}/${Characters.EQUIPMENT_TABS}") {
            ensureBearer(token)
        }

    /**
     * @return all the equipment template tabs
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/equipmenttabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun equipmentTabs(name: String, token: String? = null): List<EquipmentTemplateTab> = allTabs("${Characters.CHARACTERS}/${name}/${Characters.EQUIPMENT_TABS}") {
        ensureBearer(token)
    }

    /**
     * @return the currently active equipment template tab
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters/:id/equipmenttabs">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.BUILDS, Permission.CHARACTERS)
    suspend fun activeEquipmentTab(name: String, token: String? = null): EquipmentTemplateTab =
        httpClient.get(path = "${Characters.CHARACTERS}/${name}/${Characters.EQUIPMENT_TABS}/${Characters.ACTIVE}") {
            ensureBearer(token)
        }

    /**
     * @return the ids of the skill challenges.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Heropoints">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.PROGRESSION)
    suspend fun heroPoints(name: String, token: String? = null): List<String> = httpClient.get(path = "${Characters.CHARACTERS}/${name}/${Characters.HEROPOINTS}") {
        ensureBearer(token)
    }

    /**
     * @return the equipped bags.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.INVENTORIES)
    suspend fun bags(name: String, token: String? = null): List<Bag?> = httpClient.get<Character>(path = "${Characters.CHARACTERS}/${name}/${Characters.INVENTORY}") {
        ensureBearer(token)
    }.bags

    /**
     * @return the skills in each game mode.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Skills">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun skills(name: String, token: String? = null): ModeSkills = httpClient.get<Character>(path = "${Characters.CHARACTERS}/${name}/${Characters.SKILLS}") {
        ensureBearer(token)
    }.skills

    /**
     * @return the specializations in each game mode.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Specialization">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun specializations(name: String, token: String? = null): ModeSpecializations =
        httpClient.get<Character>(path = "${Characters.CHARACTERS}/${name}/${Characters.SPECIALIZATIONS}") {
            ensureBearer(token)
        }.specializations

    /**
     * @return the skill tree trainings.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Training">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS)
    suspend fun trainings(name: String, token: String? = null): List<CharacterTraining> =
        httpClient.get<Character>(path = "${Characters.CHARACTERS}/${name}/${Characters.TRAINING}") {
            ensureBearer(token)
        }.trainings

    /**
     * @return the super adventure box progress.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Super_Adventure_Box_.28sab.29">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.CHARACTERS, Permission.PROGRESSION)
    suspend fun superAdventureBox(name: String, token: String? = null): SabProgress =
        httpClient.get(path = "${Characters.CHARACTERS}/${name}/${Characters.SUPER_ADVENTURE_BOX}") {
            ensureBearer(token)
        }

    /**
     * @return the unlocked recipes. Note that recipes have been account bound since the July 26, 2016 release.
     * @see <a href="https://github.com/arenanet/api-cdi/blob/master/v2/characters/characters.js">the cdi</a>
     * @see <a href="https://wiki.guildwars2.com/wiki/Game_updates/2016-07-26#Update_-_July_26.2C_2016">the release notes</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.INVENTORIES)
    suspend fun recipes(name: String, token: String? = null): List<Int> = httpClient.get<Character>(path = "${Characters.CHARACTERS}/${name}/${Characters.RECIPES}") {
        ensureBearer(token)
    }.recipes

    /**
     * @return the ids for quests related to the character's story progression
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/characters/:id/quests">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.CHARACTERS, Permission.PROGRESSION)
    suspend fun quests(name: String, token: String? = null): List<Int> = httpClient.get(path = "${Characters.CHARACTERS}/${name}/${Characters.QUESTS}") {
        ensureBearer(token)
    }
}