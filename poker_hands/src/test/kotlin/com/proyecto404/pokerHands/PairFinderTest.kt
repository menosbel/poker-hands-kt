package com.proyecto404.pokerHands

import com.proyecto404.pokerHands.gameFinders.PairFinder
import com.proyecto404.pokerHands.gameTypes.NoGame
import com.proyecto404.pokerHands.gameTypes.PairGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PairFinderTest {

    @Test
    fun `find pair in hand`() {
        val hand = Hand("1S-1C-5S-4D-6H")

        val result = PairFinder().getGame(hand)

        assertThat(result).isEqualTo(PairGame("1S-1C"))
    }

    @Test
    fun `not find pair in hand`() {
        val hand = Hand("2S-3C-9S-4D-6H")

        val result = PairFinder().getGame(hand)

        assertThat(result).isEqualTo(NoGame())
    }
}
