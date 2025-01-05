package de.leander.seinna.entities

import org.bukkit.util.Vector

class KinematicChain(
    val root: Vector,
    val segments: List<ChainSegment>,
    val MAX_INTERACTIONS: Int = 20,
    val TOLERANCE: Double = 0.01,
) {

    fun fabrik(target: Vector) {

    }

    fun fabrikForward(target: Vector) {
        val lastSegment = segments.last()
        lastSegment.position.copy(target)

        for (i in segments.size - 1 downTo 1) {
            val previousSegment = segments[i]
            val currentSegment = segments[i - 1]

            moveSegment(currentSegment.position, previousSegment.position, previousSegment.length)
        }
    }

    fun fabrikBackward() {
        moveSegment(segments.first().position, root, segments.first().length)

        for (i in 1 until segments.size) {
            val previousSegment = segments[i - 1]
            val currentSegment = segments[i]

            moveSegment(currentSegment.position, previousSegment.position, currentSegment.length)
        }
    }

    fun moveSegment(point: Vector, towards: Vector, length: Double) {
        val direction = towards.clone().subtract(point).normalize()
        point.copy(towards).subtract(direction.multiply(length))
    }

    fun clone() = KinematicChain(root.clone(), segments.map { it.clone() })

}

data class ChainSegment(
    var position: Vector,
    val length: Double,
    val initDirection: Vector,
) {
    fun clone() = ChainSegment(position.clone(), length, initDirection.clone())
}