package io.marinina.ass04.bullsandcows

fun bulls(ans: String, word: String): Int {
    var bulls = 0
    var i = 0
    while (i < word.length) {
        if (word[i] == ans[i]) bulls++
        i++
    }
    return bulls
}

fun cows(ans: String, word: String): Int {
    var cows = 0
    var i = 0
    var j = 0
    while (i < word.length) {
        while (j < word.length) {
            if (ans[i] == word[j]) cows += 1
            j++
        }
        i++
    }
    return cows
}