package com.generic.lib.generic

fun main(args: Array<String>) {
    testGenerics<String>()
//    println(String::class.simpleName)
}

fun <T> testGenerics() {
//    val t: T? = null //  LOCALVARIABLE t Ljava/lang/Object; L1 L2 0
//    println(T::class.simpleName)
}

/**
 * inline：植入到调用点处
 * reified: 让泛型参数具体化
 */
//inline fun <reified T> testGenerics() {
//    println(T::class.simpleName)
//}
