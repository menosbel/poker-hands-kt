package com.proyecto404.pokerHands.gameTypes

import com.proyecto404.pokerHands.Comparator

abstract class Game {
    operator fun compareTo(other: Game): Int {
        val result = Comparator().compareTo(this, other)
        return if (result == 0 && this.javaClass == other.javaClass) {
            compareEqualGames(other)
        } else {
            result
        }
//
    }

    abstract fun compareEqualGames(other: Game): Int
}
