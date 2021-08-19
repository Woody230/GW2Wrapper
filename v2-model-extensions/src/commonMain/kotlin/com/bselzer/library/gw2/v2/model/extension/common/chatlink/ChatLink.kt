package com.bselzer.library.gw2.v2.model.extension.common.chatlink

import com.bselzer.library.kotlin.extension.base64.common.decodeBase64ToByteArray
import com.bselzer.library.kotlin.extension.base64.common.encodeBase64ToString

abstract class ChatLink<Link> where Link : ChatLink<Link>
{
    /**
     * The first byte of a chat link.
     */
    abstract val header: Byte

    /**
     * @return the link with base64 encoding
     */
    fun encode(): String
    {
        val bytes = byteArrayOf(header) + getData()
        return "[&${bytes.encodeBase64ToString()}]"
    }

    /**
     * Extracts the components from the [encoded] link.
     * @param encoded the encoded link
     * @return the [Link] with the components populated
     */
    fun decode(encoded: String): Link
    {
        // Need to remove the enclosing square brackets and ampersand before decoding, if it exists.
        val input = encoded.removeSurrounding("[&", "]")
        val bytes = input.decodeBase64ToByteArray()

        // Verify that the header byte exists.
        if (bytes.isEmpty())
        {
            throw IllegalArgumentException("Unable to decode an invalid link: '$encoded' produces an empty byte array")
        }
        // Verify that the header matches the current type of object.
        else if (bytes.first() != header)
        {
            throw IllegalArgumentException("Unable to decode an invalid link: the header byte of '$encoded' does not equal '$header'")
        }

        // Let the subclass create itself using the data.
        return decode(bytes.copyOfRange(1, bytes.size - 1))
    }

    /**
     * @param bytes the decoded link with the header removed
     * @return the [Link] with the components populated
     */
    protected abstract fun decode(bytes: ByteArray): Link

    /**
     * @return the link data
     */
    protected abstract fun getData(): ByteArray

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ChatLink<*>

        if (header != other.header) return false
        return encode() == other.encode()
    }

    override fun hashCode(): Int
    {
        return encode().hashCode()
    }
}