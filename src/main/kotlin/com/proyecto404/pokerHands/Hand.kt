package com.proyecto404.pokerHands

class Hand(val cards: List<Card>) {

    constructor(cards: String): this(cards.split('-').map {Card(it)})

    fun maxCard(): Card {
        return cards.maxOf { it }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hand

        if (cards != other.cards) return false

        return true
    }

    override fun hashCode(): Int {
        return cards.hashCode()
    }

    override fun toString(): String {
        return "Hand(cards=$cards)"
    }
}
