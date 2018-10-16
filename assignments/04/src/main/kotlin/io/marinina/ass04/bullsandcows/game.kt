package io.marinina.ass04.bullsandcows

import java.util.Scanner

fun game(word: String, len: Int) {
    var j = 9
    while (j >= 0) {
        val input = Scanner(System.`in`)
        val ans = input.nextLine().toLowerCase()
        if (len == ans.length) {
            if (ans.all { it.isLetter() }) {
                if (ans == word) {
                    println("You win! Will you play again?\n" + "(y for 'Yes'/any bottom for 'No')")
                    val input = Scanner(System.`in`)
                    val yn = input.nextLine().toLowerCase()
                    if (yn == "y") main()
                    else {
                        println("Goodbye!")
                        break
                    }
                } else {
                    println("Bulls ${(bulls(ans, word))} and Cows ${(cows(ans, word))}")
                    println("$j attempts left")
                }
                j--
            } else {
                println("Please, enter only letters:")
            }
        } else {
            println("Wrong number of letters, enter again. Try again:")
        }
    }
}