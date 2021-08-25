package com.bselzer.library.gw2.v2.model.extension.token

import com.bselzer.library.gw2.v2.model.extension.base.Validate
import kotlinx.serialization.Serializable

/**
 * An API key wrapper.
 *
 * @param key the api key in the form of two UUIDs cont
 */
@Serializable
data class ApiKey(val key: String) : Validate
{
    private companion object
    {
        /**
         * The validation regex. Example value: 5954509A-5EE9-B24A-AD70-84181D85457D4F38FAB3-3AF5-4E87-8BA5-CA0988519447
         */
        val regex: Regex = Regex("(?i)[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{20}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}")
    }

    override fun isValid(): Boolean = regex.matches(key)
}