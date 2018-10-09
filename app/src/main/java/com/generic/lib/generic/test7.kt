package com.generic.lib.generic

import java.util.ArrayList
import kotlin.collections.List

/**
 * @author ChengGuo
 * @date 2018/10/9
 */
fun main(args: Array<String>) {
    //声明的时候可以用星投影，需要真正泛型实参的时候不能用

    val list: List<*> = listOf(1, 2)
//    val list: List<Any?> = listOf(1, 2)
//    val list: List<*> = listOf<*>(1, 2)
//    list[1]
//    val list2: ArrayList<*> = ArrayList<Int>()
//    list2.add(123)
//    list2[0]

    val comparable: Comparable<*> = object : Comparable<Any> {
        override fun compareTo(other: Any): Int {
            return 0
        }
    }

}




