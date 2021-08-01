package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.account.token.ApiKeyInfo
import com.bselzer.library.gw2.v2.model.common.account.token.SubTokenInfo
import com.bselzer.library.gw2.v2.model.common.account.token.TokenInfo
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

@OptIn(InternalSerializationApi::class)
object Account
{
    val TOKEN_INFO = SerializersModule {
        polymorphic(TokenInfo::class) {
            subclass(ApiKeyInfo::class, ApiKeyInfo::class.serializer())
            subclass(SubTokenInfo::class, SubTokenInfo::class.serializer())
        }
    }
}