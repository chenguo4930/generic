package com.generic.lib.generic

fun main(args: Array<String>) {

    //------1-----
    val a = 4
    val b = 3
    val c = maxOf(a, b)
    println(c)

    //-----2------
//    val complex1 = Complex(3.0, 4.0)
//    val complex2 = Complex(4.0, 5.0)
//    println(maxOf(complex1, complex2))

    //-----3-------
    //Function22
//    (1..3).map { }

    //------4-------------
//    //Array<String>
//    //kotlin编译器智能，自动推断类型
//    val complex1 = Complex<Double>(3.0, 4.0)
//    val complex2 = Complex(4, 5)
//    println(complex1)
//    println(complex2)

}


/**
 * 1 、为函数声明泛型
 */
fun <T : Comparable<T>> maxOf(a: T, b: T): T {
    return if (a < b) b else a
}

/**
 * 2、实现比较接口的类
 */
//data class Complex(val a: Double, val b: Double) : Comparable<Complex> {
//
//    override fun compareTo(other: Complex): Int {
//        return (value() - other.value()).toInt()
//    }
//
//    fun value(): Double {
//        return a * a + b * b
//    }
//
//    override fun toString(): String {
//        return "($a + $b)"
//    }
//}

/**
 * 3、为类声明泛型
 */
//data class Complex<T : Number>(val a: T, val b: T)  {
////data class Complex<T : Number,R>(val a: T, val b: T)  {
//
//    override fun toString(): String {
//        return "($a + $b)"
//    }
//}