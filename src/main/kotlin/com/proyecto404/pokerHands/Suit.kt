package com.proyecto404.pokerHands

enum class Suit {
    Spades,
    Diamonds,
    Clubs,
    Hearts;

    companion object {
        fun startingWith(letter: Char) = values().single { it.name.first() == letter }
    }
}
