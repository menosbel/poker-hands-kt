package com.proyecto404.pokerHands

import org.junit.jupiter.api.Test

class CardTest {

    @Test
    fun comparisons() {
        assert(Card("1H") < Card("2H"))
        assert(Card("3H") <= Card("3D"))
        assert(Card("4C") > Card("3S"))
        assert(Card("5C") >= Card("5S"))
        assert(Card("JC") > Card("10S"))
        assert(Card("AS") > Card("KH"))
        assert(Card("JC") <= Card("QD"))
    }
}
