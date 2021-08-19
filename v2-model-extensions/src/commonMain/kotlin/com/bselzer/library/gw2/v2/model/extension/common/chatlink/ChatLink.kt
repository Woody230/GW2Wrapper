package com.bselzer.library.gw2.v2.model.extension.common.chatlink

import com.bselzer.library.kotlin.extension.base64.common.decodeBase64ToByteArray
import com.bselzer.library.kotlin.extension.base64.common.encodeBase64ToString
import com.bselzer.library.kotlin.extension.function.common.collection.toByteArray
import com.bselzer.library.kotlin.extension.function.common.objects.toBoolean
import com.bselzer.library.kotlin.extension.function.common.objects.toInt
import kotlin.experimental.or

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

    /**
     * Combine bit flags into a byte.
     * @return a byte of flags in big endian format
     */
    protected fun encodeFlags(vararg flags: Boolean): Byte
    {
        var byte: Byte = 0
        var shift = 7
        flags.forEach { flag ->
            byte = byte or (flag.toInt() shl shift).toByte()

            // Move the shifting to the right to apply the next flag.
            shift -= 1
        }
        return byte
    }

    /**
     * Extracts the flag bits from the byte.
     * @return the flags
     */
    protected fun decodeFlags(byte: Byte): List<Boolean>
    {
        val flags = mutableListOf<Boolean>()
        (7 downTo 0).forEach { index ->
            val bit = (byte.toInt() shr index) and 1
            flags.add(bit.toBoolean())
        }
        return flags
    }

    /**
     * @return [this] as a byte array in little endian format with [slots] number of bytes
     */
    protected fun Int.bytes(take: Int, slots: Int): List<Byte>
    {
        val bytes = this.toByteArray().take(3).toMutableList()

        // Fill the remaining slots with zero.
        (1..slots - take).forEach { _ -> bytes.add(0) }

        return bytes
    }

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