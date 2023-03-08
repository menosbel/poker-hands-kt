package com.proyecto404.pokerHands.gameTypes

import com.proyecto404.pokerHands.Card

class PairGame(private val card1: Card, private val card2: Card): Game(){

    constructor(cards: String): this(Card(cards.split('-')[0]), Card(cards.split('-')[1]))

    override fun compareEqualGames(other: Game) = card1.compareTo((other as PairGame).card1)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PairGame

        if (card1 != other.card1) return false
        if (card2 != other.card2) return false

        return true
    }

    override fun hashCode(): Int {
        var result = card1.hashCode()
        result = 31 * result + card2.hashCode()
        return result
    }
}