package com.proyecto404.pokerHands

import com.proyecto404.pokerHands.gameFinders.GameFinder
import com.proyecto404.pokerHands.gameFinders.HighCardFinder
import com.proyecto404.pokerHands.gameFinders.PairFinder
import com.proyecto404.pokerHands.gameFinders.StraightFinder
import com.proyecto404.pokerHands.gameTypes.Game
import com.proyecto404.pokerHands.gameTypes.NoGame

class WinnerCalculator {
    private val finders = listOf(StraightFinder(), PairFinder(), HighCardFinder())

    fun execute(playerOne: Hand, playerTwo: Hand): GameResult {
        val playerOneGame = findBestGame(finders, playerOne)
        val playerTwoGame = findBestGame(finders, playerTwo)

        return getResult(playerOneGame, playerTwoGame)
    }

    private fun findBestGame(finders: List<GameFinder>, hand: Hand) =
        finders.map { it.getGame(hand) }.first { it !is NoGame }

    private fun getResult(playerOneGame: Game, playerTwoGame: Game): GameResult {
        return when {
            playerOneGame > playerTwoGame -> GameResult.winner(1, playerOneGame)
            playerOneGame < playerTwoGame -> GameResult.winner(2, playerTwoGame)
            else -> GameResult.tie()
        }
    }
}
