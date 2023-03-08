package com.proyecto404.pokerHands

import com.proyecto404.pokerHands.gameTypes.Game

class GameResult private constructor(private val result: String = "") {
    override fun toString(): String {
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameResult

        if (result != other.result) return false

        return true
    }

    override fun hashCode(): Int {
        return result.hashCode()
    }

    companion object {
        fun tie() = GameResult("Tie.")

        fun winner(player: Int, game: Game) = GameResult("${game.javaClass.simpleName} wins: $player")
    }
}
