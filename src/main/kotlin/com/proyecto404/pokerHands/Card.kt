package com.proyecto404.pokerHands

class Card(val value: String, Suit: Suit): Comparable<Card> {
    private val ordinal: Int = getOrdinal(value)

    constructor(cardStr: String) : this(cardStr.dropLast(1), Suit.startingWith(cardStr.last()))

    private fun getOrdinal(value: String) = when (value) {
        "J" -> 11
        "Q" -> 12
        "K" -> 13
        "A" -> 14
        else -> value.toInt()
    }

    override operator fun compareTo(other: Card): Int {
        return ordinal.compareTo(other.ordinal)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (value != other.value) return false
        if (ordinal != other.ordinal) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + ordinal
        return result
    }

    override fun toString(): String {
        return "Card(value='$value', ordinal=$ordinal)"
    }

    fun isNextCard(card: Card) = card.ordinal == ordinal + 1


}
