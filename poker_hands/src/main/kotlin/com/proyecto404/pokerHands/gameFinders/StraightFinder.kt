package com.proyecto404.pokerHands.gameFinders

import com.proyecto404.pokerHands.Hand
import com.proyecto404.pokerHands.gameTypes.NoGame
import com.proyecto404.pokerHands.gameTypes.StraightGame

class StraightFinder: GameFinder {
    override fun getGame(hand: Hand) = if (isStraight(hand)) StraightGame(hand) else NoGame()

    private fun isStraight(hand: Hand): Boolean {
        return hand.cards
            .sorted()
            .zipWithNext()
            .all { (current, next) -> current.isNextCard(next) }
    }
}
