package io.marinina.ass04.bullsandcows

import java.io.File
import java.util.Random

fun main(vararg args: String) {
    val file = File("task/dictionary.txt")
    val list: List<String> = file.readLines()
    println("Welcome to the game 'Bulls & Cows'!")
    println("You have 10 attempts to guess the word.")
    val word = random(list).toLowerCase()
    println(word)
    val len = word.length
    println("I offered a $len-letter word, your guess?")
    println("Write your answer:")
    game(word, len)
}

fun random(list: List<String>): String {
    val num = Random().nextInt(list.size)
    return list[num]
}