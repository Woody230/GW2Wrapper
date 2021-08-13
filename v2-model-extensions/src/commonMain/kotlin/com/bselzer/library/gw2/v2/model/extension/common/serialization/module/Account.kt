package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.account.token.ApiKeyInfo
import com.bselzer.library.gw2.v2.model.common.account.token.SubTokenInfo
import com.bselzer.library.gw2.v2.model.common.account.token.TokenInfo
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

object Account
{
    // TODO all serializer modules: make base class not abstract and default to it?
    val TOKEN_INFO = SerializersModule {
        polymorphic(TokenInfo::class) {
            subclass(ApiKeyInfo::class, serializer())
            subclass(SubTokenInfo::class, serializer())
            default { serializer() }
        }
    }
}