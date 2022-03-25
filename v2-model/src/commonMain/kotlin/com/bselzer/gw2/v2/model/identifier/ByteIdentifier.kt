package com.bselzer.gw2.v2.model.identifier

interface ByteIdentifier : Identifier<Byte> {
    override val isDefault: Boolean
        get() = value <= 0
}