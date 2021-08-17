package com.bselzer.library.gw2.v2.model.common.extension.base

import kotlinx.serialization.SerialName

interface Identifiable<Id>
{
    @SerialName("id")
    val id: Id
}