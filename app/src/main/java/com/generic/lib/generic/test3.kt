package com.generic.lib.generic

fun main(args: Array<String>) {
    //---------1----------
    testGenerics<String>()
//    println(String::class.simpleName)

    //----------2----------
    println(isA<String>("Kotlin"))
    println(isA<String>(123))
}

fun <T> testGenerics() {
    val t: T? = null //  LOCALVARIABLE t Ljava/lang/Object; L1 L2 0
//    println(T::class.simpleName)
}

/**
 * inline：植入到调用点处
 * reified: 让泛型参数具体化
 */
//inline fun <reified T> testGenerics() {
//    println(T::class.simpleName)
//}

//fun <T> isA(value : Any) = value is T
inline fun <reified T> isA(value: Any) = value is T


inline fun <reified R> List<Any>.filterAndForEach(eachEveryData: (R) -> Unit) {
    this.filter { it is R }.map { it as R }.forEach { eachEveryData(it) }
}



