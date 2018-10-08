package com.generic.lib.generic

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import java.io.File
import java.util.*

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

/**
 * 使用实化类型参数代替类引用
 */
inline fun <reified T> Gson.fromJson(json: String): T = fromJson(json, T::class.java)

data class Person(val name: String, val age: Int)


/**
 * 简化startActivity函数
 */
inline fun <reified T : Activity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}
