package com.bselzer.gw2.v2.model.identifier

interface LongIdentifier : Identifier<Long> {
    override val isDefault: Boolean
        get() = value <= 0
}