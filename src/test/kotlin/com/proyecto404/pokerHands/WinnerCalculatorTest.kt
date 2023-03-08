package com.proyecto404.pokerHands

import com.proyecto404.pokerHands.gameTypes.HighCardGame
import com.proyecto404.pokerHands.gameTypes.PairGame
import com.proyecto404.pokerHands.gameTypes.StraightGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinnerCalculatorTest {

    @Test
    fun `execute when all cards had same value returns tie `() {
        val gameResult = winnerCalculator.execute(
            Hand("1C-2S-5H-4C-7D"),
            Hand("1S-2C-5S-4D-7H")
        )

        assertThat(gameResult).isEqualTo(GameResult.tie())
    }

    @ParameterizedTest
    @CsvSource(
        "1C-2S-5H-4C-7D, 1S-2C-5S-4D-6H, 1, 7D",
        "1C-2S-5H-4C-7D, 1S-2C-5S-4D-KS, 2, KS",
        "1C-2S-5H-4C-7D, 1S-2C-5S-4D-JS, 2, JS",
        "1C-2S-5H-4C-8D, 1S-2C-5S-QD-KS, 2, KS"
    )
    fun `execute when is highest card returns winner with highest card`(hand1: String, hand2: String, gameWinner: Int, cardWinner: String) {
        val gameResult = winnerCalculator.execute(Hand(hand1), Hand(hand2))

        assertThat(gameResult).isEqualTo(GameResult.winner(gameWinner, HighCardGame(cardWinner)))
    }

    @Test
    fun `hand 2 pair wins over high card`() {
        val hand1 = Hand("1C-2S-5H-4C-7D")
        val hand2 = Hand("1C-1S-5H-4C-7D")

        val gameResult = winnerCalculator.execute(hand1, hand2)

        assertThat(gameResult).isEqualTo(GameResult.winner(2, PairGame("1C-1S")))
    }

    @Test
    fun `hand 1 pair wins over high card`() {
        val hand1 = Hand("1C-1S-5H-4C-7D")
        val hand2 = Hand("1C-2S-5H-4C-7D")

        val gameResult = winnerCalculator.execute(hand1, hand2)

        assertThat(gameResult).isEqualTo(GameResult.winner(1, PairGame("1C-1S")))
    }

    @Test
    fun `highest pair wins`() {
        val hand1 = Hand("2C-2S-5H-4C-7D")
        val hand2 = Hand("1C-1S-5H-4C-7D")

        val gameResult = winnerCalculator.execute(hand1, hand2)

        assertThat(gameResult).isEqualTo(GameResult.winner(1, PairGame("2C-2S")))
    }

    @Test
    fun `straight wins over pair`() {
        val hand1 = Hand("2C-3S-5H-4C-6D")
        val hand2 = Hand("2D-2S-5S-4D-7D")

        val gameResult = winnerCalculator.execute(hand1, hand2)

        assertThat(gameResult).isEqualTo(GameResult.winner(1, StraightGame("2C-3S-5H-4C-6D")))
    }

//    @Test
//    fun `equal pairs, high card wins`() {
//        val hand1 = hand("2C-2S-5H-4C-7D")
//        val hand2 = hand("2D-2H-3H-QC-7D")
//        val pairFinder = mockk<PairFinder>()
//        every { pairFinder.getGame(hand1) } returns PairGame("2C-2S")
//        every { pairFinder.getGame(hand2) } returns PairGame("2D-2H")
//
//        val gameResult = WinnerCalculator(pairFinder).execute(hand1, hand2)
//
//        assertThat(gameResult).isEqualTo(GameResult.highCardWins(2))
//    }


    private val winnerCalculator = WinnerCalculator()

}
