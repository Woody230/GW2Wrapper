package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.skill.Skill
import io.ktor.client.*

/**
 * The skill client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
 */
class SkillClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val SKILLS = "skills"
    }

    /**
     * @return the ids of the available skills
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = SKILLS)

    /**
     * @return the skill associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    suspend fun skill(id: Int, language: String? = null): Skill = single(id, SKILLS) {
        language(language)
    }

    /**
     * @return the skills associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    suspend fun skills(ids: Collection<Int>, language: String? = null): List<Skill> = chunkedIds(ids, SKILLS) {
        language(language)
    }

    /**
     * @return all the skills
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    suspend fun skills(language: String? = null): List<Skill> = allIds(SKILLS) {
        language(language)
    }
}