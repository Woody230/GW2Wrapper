package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.mailcarrier.MailCarrier
import io.ktor.client.*

/**
 * The mail carrier client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
 */
class MailCarrierClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val MAIL_CARRIERS = "mailcarriers"
    }

    /**
     * @return the ids of the available mail carriers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun ids(): List<Int> = get(path = MAIL_CARRIERS)

    /**
     * @return the mail carrier associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun mailCarrier(id: Int, language: String? = null): MailCarrier = single(id, MAIL_CARRIERS) {
        language(language)
    }

    /**
     * @return the mail carriers associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun mailCarriers(ids: Collection<Int>, language: String? = null): List<MailCarrier> = chunkedIds(ids, MAIL_CARRIERS) {
        language(language)
    }

    /**
     * @return all the mail carriers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun mailCarriers(language: String? = null): List<MailCarrier> = allIds(MAIL_CARRIERS) {
        language(language)
    }
}