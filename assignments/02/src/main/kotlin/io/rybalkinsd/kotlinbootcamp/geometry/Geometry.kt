package io.rybalkinsd.kotlinbootcamp.geometry

interface Collider {
    fun isColliding(other: Collider): Boolean
}

data class Point(val x: Int, val y: Int) : Collider {
    override fun isColliding(other: Collider): Boolean = when (other) {
                is Point -> other == this
                is Bar -> other.poinInBar(this)
                else -> false
            }
}

class Bar(val firstCornerX: Int, val firstCornerY: Int, val secondCornerX: Int, val secondCornerY: Int) : Collider {
    override fun isColliding(other: Collider): Boolean = when (other) {
        is Point -> poinInBar(other)
        is Bar -> barInBar(other) || other.barInBar(this)
        else -> false
    }

    fun barInBar(other: Bar): Boolean =
            (other.firstCornerX in firstCornerX..secondCornerX || other.secondCornerX in firstCornerX..secondCornerX) &&
            (other.firstCornerY in firstCornerY..secondCornerY || other.secondCornerY in firstCornerY..secondCornerY)

    fun poinInBar(point: Point): Boolean =
            point.x in firstCornerX..secondCornerX && point.y in firstCornerY..secondCornerY

    override fun equals(other: Any?): Boolean {
        if (other is Bar) return(firstCornerX == other.firstCornerX || firstCornerX == other.secondCornerX) &&
                (secondCornerX == other.firstCornerX || secondCornerX == other.secondCornerX) &&
                (firstCornerY == other.secondCornerY || firstCornerY == other.firstCornerY) &&
                (secondCornerY == other.firstCornerY || secondCornerY == other.secondCornerY)
        else return false
    }
}
