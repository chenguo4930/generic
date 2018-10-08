package com.generic.lib.generic

import com.google.gson.Gson
import java.io.File

fun main(args: Array<String>) {

    val person = Person("ChengGuo", 18)
    //将person写入一个json文件
    Gson().toJson(person).let {
        File("person.json").writeText(it)
    }

    //读取一个json文件，并转化为person对象
    val person1: Person = Gson().fromJson(File("person.json").readText())
    val person2 = Gson().fromJson<Person>(File("person.json").readText())
}


inline fun <reified T> Gson.fromJson(json: String): T = fromJson(json, T::class.java)

data class Person(val name: String, val age: Int)