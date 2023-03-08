package com.proyecto404.pokerHands.gameFinders

import com.proyecto404.pokerHands.gameTypes.Game
import com.proyecto404.pokerHands.Hand
import com.proyecto404.pokerHands.gameTypes.NoGame
import com.proyecto404.pokerHands.gameTypes.PairGame

class PairFinder : GameFinder {

    override fun getGame(hand: Hand): Game {
        val pairs = findPairsInHand(hand)
        if (pairs.isEmpty()) return NoGame()
        val pair = pairs[0]
        return PairGame(pair.second[0], pair.second[1])
    }

    private fun findPairsInHand(hand: Hand) =
        hand.cards.groupBy { it.value }.filter { it.value.size == 2 }.toList()
}
