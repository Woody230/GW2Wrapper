package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build

abstract class LinkComponent
{
    /**
     * The number of bytes required in the data.
     */
    abstract val size: Int

    /**
     * Populate the components from the [bytes].
     * @param bytes the data bytes relevant to the component
     */
    open fun decode(bytes: ByteArray)
    {
        if (bytes.size != size)
        {
            throw IllegalArgumentException("Unable to decode link component data: exactly $size bytes are required")
        }
    }

    /**
     * @return the link data
     */
    abstract fun getData(): ByteArray
}