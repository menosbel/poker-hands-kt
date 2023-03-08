package com.proyecto404.pokerHands.gameTypes

import com.proyecto404.pokerHands.Card

class HighCardGame(val maxCard: Card) : Game() {
    constructor(cards: String): this(Card(cards))

    override fun compareEqualGames(other: Game) = maxCard.compareTo((other as HighCardGame).maxCard)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HighCardGame

        if (maxCard != other.maxCard) return false

        return true
    }

    override fun hashCode(): Int {
        return maxCard.hashCode()
    }
}
