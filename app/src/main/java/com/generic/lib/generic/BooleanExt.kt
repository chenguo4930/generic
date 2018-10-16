package com.generic.lib.generic

/**
 * @author ChengGuo
 * @date 2018/10/16
 */

fun main(args: Array<String>) {
    val result = if (getABoolean()) {
        1
    } else {
        2
    }
    println("$result")

    val result2 = getABoolean().yes {
        1
    }.otherwise {
        2
    }
    println("$result2")
}

fun getABoolean() = false

sealed class BooleanExt<out T>

object OtherWise : BooleanExt<Nothing>()

class Yes<T>(val data: T) : BooleanExt<T>()

inline fun <T> Boolean.yes(block: () -> T) =
        when {
            this -> {
                Yes(block())
            }
            else -> OtherWise
        }

inline fun <T> BooleanExt<T>.otherwise(block: () -> T): T =
        when (this) {
            is Yes -> data
            else -> block()
        }




