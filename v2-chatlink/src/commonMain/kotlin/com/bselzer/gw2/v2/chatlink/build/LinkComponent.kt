package com.bselzer.gw2.v2.chatlink.build

abstract class LinkComponent {
    /**
     * The number of bytes required in the data.
     */
    abstract val size: Int

    /**
     * Populate the components from the first [size] bytes of the [bytes]
     * @param bytes all of the data bytes
     */
    open fun decode(bytes: ArrayDeque<Byte>) {
        if (bytes.size < size) {
            throw IllegalArgumentException("Unable to decode ${this::class.simpleName} data: $size bytes are required")
        }
    }

    /**
     * @return the link data
     */
    abstract fun getData(): ByteArray
}