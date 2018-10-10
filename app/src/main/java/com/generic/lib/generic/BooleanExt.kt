package com.generic.lib.generic

/**
 * 对Boolean进行扩展
 *
 * @author ChengGuo
 * @date 2018/10/8
 */
sealed class BooleanExt<out T>

object OtherWise : BooleanExt<Nothing>()

class WithData<T>(val data: T) : BooleanExt<T>()

inline fun <T> Boolean.yes(block: () -> T) =
//        if (this) {
//            WithData(block())
//        } else {
//            OtherWise
//        }
        when {
            this -> WithData(block())
            else -> OtherWise
        }

inline fun <T> BooleanExt<T>.otherwise(block: () -> T): T =
        when (this) {
            is OtherWise -> block()
            is WithData -> this.data
        }


fun main(args: Array<String>) {

    val result1 = true.yes {
        1
    }.otherwise {
        "123"
    }
    println("result1 = $result1")

    val result2 = false.yes {
        1
    }.otherwise {
        2
    }
    println("result2 = $result2")
}