package com.proyecto404.pokerHands.gameFinders

import com.proyecto404.pokerHands.gameTypes.Game
import com.proyecto404.pokerHands.Hand

interface GameFinder {
    fun getGame(hand: Hand): Game
}