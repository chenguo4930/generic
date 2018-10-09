package com.generic.lib.generic

/**
 * 子类型 ： 任何时候如果需要的是类型 A 的值，你的偶能够使用类型 B 的值，当作 A 的值，类型 B 就称为类型 A 的子类型
 *            比如：Int 是 Number的子类型，但 Int 不是 String 的子类型，Int 也是 Int 的子类型，
 *            任何类型都可以被认为是它自己的子类型
 *
 * 超类型：子类型的反义词，如果 A 是 B 的子类型，那么 B 就是 A 的超类型。
 *
 *          非空类型 A 是可空类型 A? 的子类型
 *
 *
 *
 *
 *
 * @author ChengGuo
 * @date 2018/9/28
 */

fun main(args: Array<String>) {

//    JVM把[-128,127]的所有int数字全部缓存了，任何指向这个范围的对象，都不可能被另外"创建"，又何谈“装箱”
//    val a: Int? = 10
//    val b: Int = 10
//    val a: Int? = 1000
//    val b: Int = 1000
//
//    println("a == b ${a == b}")
//    println("a === b ${a === b}")


}


/**
 * out : 声明为协变，只读  两层含义 1、子类型化会被保留  2、T 只能在out位置  例如：List 接口
 * in : 声明为协变，只写
 * Function1
 *
 */
interface Producer<in T, out R> {
    //    fun produce(t: T): T
    fun produce(t: T): R
}

open class Animal {
    fun feed() {
    }
}

/**
 * T没有任何变型修饰符的情况
 */
//class Herd<T : Animal> {
class Herd<out T : Animal> {
    val size: Int get() = 5
    tailrec operator fun get(i: Int): T {
        return get(0)
    }
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() {
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
    }
    //        feedAll(cats)
}

/**
 * out 的其他注意事项
 */
interface List<out T> : Collection<T> {
    fun subList(fromIndex: Int, toIndex: Int): List<T>  //这里的T也在Out位置上
}

/**
 * 构造方法的参数既不在in位置，也不在out的位置，即使声明为了out，也可以在构造方法中使用
 * 因为构造方法不是那种在实例创建完成之后还能调用的方法，没有潜在的危险
 * 私有方法 private 的参数即不在 in 位置和 out 位置
 */
class Herd2<out T : Animal>(vararg animals: T) {

}