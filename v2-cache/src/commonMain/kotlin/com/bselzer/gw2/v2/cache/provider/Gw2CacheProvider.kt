package com.bselzer.gw2.v2.cache.provider

import com.bselzer.gw2.v2.cache.instance.ContinentCache
import com.bselzer.gw2.v2.cache.instance.GuildCache
import com.bselzer.gw2.v2.cache.instance.WorldCache
import com.bselzer.gw2.v2.cache.instance.WvwCache
import com.bselzer.gw2.v2.client.client.Gw2Client

class Gw2CacheProvider(client: Gw2Client) {
    val continent: ContinentCache = ContinentCache(client)
    val guild: GuildCache = GuildCache(client)
    val world: WorldCache = WorldCache(client)
    val wvw: WvwCache = WvwCache(client)
}