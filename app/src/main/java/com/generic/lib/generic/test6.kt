package com.generic.lib.generic

import kotlin.collections.List

/**
 * @author ChengGuo
 * @date 2018/10/9
 */
fun main(args: Array<String>) {

    val anyComparator = Comparator<Any> { o1, o2 -> o1.hashCode() - o2.hashCode() }
    val strings: List<String> = listOf("a", "b", "c")
    //sortedWith期望的是一个Comparator<String>的比较器，但是传给他一个能够比较更一般的类型的比较器是安全的，
    //这说明Comparator<Any> 是Comparator<String>的子类型，而其中String是Any的子类型，
    //逆变：不同类型之间的子类型关系和这些类型的比较器之间的子类型化关系相反
    strings.sortedWith(anyComparator)

//    //协变 ：Number是Int的父类，List<Number>是List<Int>的超类型
//    val numberList: List<Number> = listOf(1, 2, 3)
//
//    //逆变 ：Comparator<Int>是Comparator<Number>的超类型
//    val intComparable: Comparator<Int> = object : Comparator<Number> {
//        override fun compare(e1: Number, e2: Number): Int {
//            return 0
//        }
//    }

    //不变：MutableList
//    val numberArrayList:MutableList<Int> = mutableListOf<Int>(1,2,3,4)
//    val numberArrayList:MutableList<Int> = mutableListOf<Number>(1,2,3,4)
//    val numberArrayList: MutableList<Number> = mutableListOf<Int>(1, 2, 3, 4)

}

/**
 * 逆变：反转 子类型化关系
 *
 */
interface Comparator<in T> {
    fun compare(e1: T, e2: T): Int
}

