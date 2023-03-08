package com.proyecto404.pokerHands

import com.proyecto404.pokerHands.gameFinders.StraightFinder
import com.proyecto404.pokerHands.gameTypes.StraightGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StraightFinderTest {

    @Test
    fun `find straight in hand`() {
        val hand = Hand("2S-3C-4S-5D-6H")

        val result = StraightFinder().getGame(hand)

        assertThat(result).isEqualTo(StraightGame("2S-3C-4S-5D-6H"))
    }
}
