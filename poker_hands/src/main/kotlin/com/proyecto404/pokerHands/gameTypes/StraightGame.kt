package com.proyecto404.pokerHands.gameTypes

import com.proyecto404.pokerHands.Card
import com.proyecto404.pokerHands.Hand

class StraightGame(val hand: Hand): Game() {

    constructor(cards: String): this(Hand(cards.split('-').map { Card(it) }))

    override fun compareEqualGames(other: Game) = hand.maxCard().compareTo((other as StraightGame).hand.maxCard())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

}
