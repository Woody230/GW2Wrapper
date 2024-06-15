package com.bselzer.gw2.v2.chatlink

import com.bselzer.ktx.function.collection.encodeBase64ToString
import com.bselzer.ktx.function.objects.decodeBase64ToByteArray

abstract class ChatLink {
    /**
     * The first byte of a chat link.
     */
    abstract val header: Byte

    /**
     * @return the link with base64 encoding
     */
    fun encode(): String {
        val bytes = byteArrayOf(header) + getData()
        return "[&${bytes.encodeBase64ToString()}]"
    }

    /**
     * Extracts the components from the [encoded] link.
     * @param encoded the encoded link
     */
    fun decode(encoded: String) {
        // Need to remove the enclosing square brackets and ampersand before decoding, if it exists.
        val input = encoded.removeSurrounding("[&", "]")
        val bytes = ArrayDeque(input.decodeBase64ToByteArray().toList())

        // Verify that the header byte exists.
        if (bytes.isEmpty()) {
            throw IllegalArgumentException("Unable to decode an invalid link: '$encoded' produces an empty byte array")
        }
        // Verify that the header matches the current type of object.
        else if (bytes.removeFirst() != header) {
            throw IllegalArgumentException("Unable to decode an invalid link: the header byte of '$encoded' does not equal '$header'")
        }

        // Let the subclass populate itself using the data.
        decode(bytes)
    }

    /**
     * Populate the components from the [bytes].
     * @param bytes the decoded link with the header removed
     */
    protected abstract fun decode(bytes: ArrayDeque<Byte>)

    /**
     * @return the link data
     */
    protected abstract fun getData(): ByteArray

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ChatLink

        if (header != other.header) return false
        return encode() == other.encode()
    }

    override fun hashCode(): Int {
        return encode().hashCode()
    }
}