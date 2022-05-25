package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.mailcarrier.MailCarrier
import com.bselzer.gw2.v2.model.mailcarrier.MailCarrierId
import io.ktor.client.*

/**
 * The mail carrier client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
 */
class MailCarrierClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val MAIL_CARRIERS = "mailcarriers"
    }

    /**
     * @return the ids of the available mail carriers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun ids(): List<MailCarrierId> = getIds(path = MAIL_CARRIERS)

    /**
     * @return the mail carrier associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun mailCarrier(id: MailCarrierId, language: Language? = null): MailCarrier = getSingleById(id, MAIL_CARRIERS, instance = { MailCarrier(id = it) }) {
        language(language)
    }

    /**
     * @return the mail carriers associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun mailCarriers(ids: Collection<MailCarrierId>, language: Language? = null): List<MailCarrier> =
        chunkedIds(ids, MAIL_CARRIERS, instance = { MailCarrier(id = it) }) {
            language(language)
        }

    /**
     * @return all the mail carriers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun mailCarriers(language: Language? = null): List<MailCarrier> = allIds(MAIL_CARRIERS) {
        language(language)
    }
}