package com.proyecto404.pokerHands.gameFinders

import com.proyecto404.pokerHands.gameTypes.Game
import com.proyecto404.pokerHands.Hand
import com.proyecto404.pokerHands.gameTypes.HighCardGame

class HighCardFinder: GameFinder {
    override fun getGame(hand: Hand): Game {
        return HighCardGame(hand.maxCard())
    }
}
