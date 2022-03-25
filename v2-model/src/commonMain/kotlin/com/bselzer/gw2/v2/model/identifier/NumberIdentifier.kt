package com.bselzer.gw2.v2.model.identifier

interface NumberIdentifier<T> : Identifier<T> where T : Number {
    override val isDefault: Boolean
        get() = value.toLong() <= 0

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Byte): Int = value.toLong().compareTo(other)

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Short): Int = value.toLong().compareTo(other)

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Int): Int = value.toLong().compareTo(other)

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Long): Int = value.toLong().compareTo(other)

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Float): Int = value.toLong().compareTo(other)

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Double): Int = value.toLong().compareTo(other)

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    operator fun compareTo(other: Identifier<Number>): Int = value.toLong().compareTo(other.value.toLong())
}