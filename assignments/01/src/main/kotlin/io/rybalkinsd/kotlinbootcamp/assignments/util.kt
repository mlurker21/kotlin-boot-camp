package io.rybalkinsd.kotlinbootcamp.assignments

fun max(values: List<Int>) = values.max()

fun sum(values: List<Int>): Long {
    var sum: Long = 0
    for (i in values)
        sum += i
    return sum
}