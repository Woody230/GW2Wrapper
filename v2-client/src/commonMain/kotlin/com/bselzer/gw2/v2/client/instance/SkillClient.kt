package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.skill.Skill
import com.bselzer.gw2.v2.model.skill.SkillId
import io.ktor.client.*

/**
 * The skill client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
 */
class SkillClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val SKILLS = "skills"
    }

    /**
     * @return the ids of the available skills
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    suspend fun ids(): List<SkillId> = getIds(path = SKILLS)

    /**
     * @return the skill associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    suspend fun skill(id: SkillId, language: Language? = null): Skill = getSingleById(id, SKILLS, instance = { Skill(id = it) }) {
        language(language)
    }

    /**
     * @return the skills associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    suspend fun skills(ids: Collection<SkillId>, language: Language? = null): List<Skill> = chunkedIds(ids, SKILLS, instance = { Skill(id = it) }) {
        language(language)
    }

    /**
     * @return all the skills
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    suspend fun skills(language: Language? = null): List<Skill> = allIds(SKILLS) {
        language(language)
    }
}