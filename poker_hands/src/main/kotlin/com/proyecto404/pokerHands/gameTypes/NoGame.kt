package com.proyecto404.pokerHands.gameTypes

class NoGame : Game() {
    override fun compareEqualGames(other: Game): Int = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
