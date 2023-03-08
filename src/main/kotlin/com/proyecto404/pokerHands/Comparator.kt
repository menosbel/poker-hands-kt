package com.proyecto404.pokerHands

import com.proyecto404.pokerHands.gameTypes.Game
import com.proyecto404.pokerHands.gameTypes.HighCardGame
import com.proyecto404.pokerHands.gameTypes.PairGame
import com.proyecto404.pokerHands.gameTypes.StraightGame

class Comparator {
    private val games = listOf(HighCardGame::class, PairGame::class, StraightGame::class)

    fun compareTo(currentGame: Game, other: Game): Int {
        val currentGamePriority = games.indexOf(currentGame::class)
        val otherGamePriority = games.indexOf(other.javaClass.kotlin)
        return if (currentGamePriority > otherGamePriority) 1
        else -1
    }
}
