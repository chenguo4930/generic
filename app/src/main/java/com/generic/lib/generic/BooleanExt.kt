package com.generic.lib.generic

//
///**
// * 对Boolean进行扩展
// *
// * @author ChengGuo
// * @date 2018/10/8
// */
//sealed class BooleanExt<out T>
//
//object OtherWise : BooleanExt<Nothing>()
//
//class WithData<T>(val data: T) : BooleanExt<T>()
//
//inline fun <T> Boolean.yes(block: () -> T) =
////        if (this) {
////            WithData(block())
////        } else {
////            OtherWise
////        }
//        when {
//            this -> WithData(block())
//            else -> OtherWise
//        }
//
//inline fun <T> BooleanExt<T>.otherwise(block: () -> T): T =
//        when (this) {
//            is OtherWise -> block()
//            is WithData -> data
//        }
//
//
//fun main(args: Array<String>) {
//
//    val result1 = true.yes {
//        1
//    }.otherwise {
//        "123"
//    }
//    println("result1 = $result1")
//
//    val result2 = false.yes {
//        1
//    }.otherwise {
//        2
//    }
//    println("result2 = $result2")
//}


//fun Boolean.yes(block: () -> Unit) {
//    if (this) {
//        block()
//    }
//}

//sealed class BooleanExt

//object Otherwise : BooleanExt()
//class WithData : BooleanExt()
//class WithData(val data: Any?) : BooleanExt()
sealed class BooleanExt<out T>

//Nothing是任意类的子类
object Otherwise : BooleanExt<Nothing>()

class WithData<T>(val data: T) : BooleanExt<T>()

//fun Boolean.yes(block: () -> Unit): BooleanExt =
//        if (this) {
//            block()
//            WithData()
//        } else {
//            Otherwise
//        }
//
//fun BooleanExt.otherwise(block: () -> Unit) =
//        when (this) {
//            is WithData -> Unit
//            is Otherwise -> block()
//        }

fun <T> Boolean.yes(block: () -> T): BooleanExt<T> =
        if (this) {
//            block()
//            WithData()
            WithData(block())
        } else {
            Otherwise
        }

//fun <T> BooleanExt.otherwise(block: () -> T): T =
//        when (this) {
////            is WithData -> Unit
//            is WithData -> data as T
//            is Otherwise -> block()
//        }

fun <T> BooleanExt<T>.otherwise(block: () -> T): T =
        when (this) {
            is WithData<T> -> data
            is Otherwise -> block()
        }


fun main(args: Array<String>) {

    getABoolean().yes {
        println("yes")
    }

    val result = if (getABoolean()) {
        1
    } else {
        2
    }
    println("result = $result")

//    getABoolean().yes {
//        println("yes")
//    }.otherwise {
//        println("otherwise")
//    }

    val result2 = getABoolean().yes {
        1
    }.otherwise {
        2
    }
    println("result2 = $result2")


}

//fun getABoolean() = true
fun getABoolean() = false

