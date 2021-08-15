package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.MailCarriers
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.mailcarrier.MailCarrier
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The mail carrier client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
 */
class MailCarrierClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available mail carriers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = MailCarriers.MAIL_CARRIERS)

    /**
     * @return the mail carriers associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun mailCarriers(ids: Collection<Int>, language: String? = null): List<MailCarrier> = chunkedIds(ids, MailCarriers.MAIL_CARRIERS) {
        language(language)
    }

    /**
     * @return all the mail carriers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">the wiki</a>
     */
    suspend fun mailCarriers(language: String? = null): List<MailCarrier> = allIds(MailCarriers.MAIL_CARRIERS) {
        language(language)
    }
}