package io.xiandan.ktx.json

import android.util.ArrayMap
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken


/**
 * Created by xiandanin on 2022-04-10 14:23
 */

val gsonKtx: Gson = newGsonBuilder().create()
private val gsonPrettyKtx = newGsonBuilder().setPrettyPrinting().create()

fun newGsonBuilder(): GsonBuilder {
    val gsonBuilder = GsonBuilder()
    try {
        val toNumberPolicyClass = Class.forName("com.google.gson.ToNumberPolicy")
        val longOrDouble = toNumberPolicyClass.getField("LONG_OR_DOUBLE")[null]
        val toNumberStrategyClass = Class.forName("com.google.gson.ToNumberStrategy")
        GsonBuilder::class.java.getMethod("setObjectToNumberStrategy", toNumberStrategyClass)
            .invoke(gsonBuilder, longOrDouble)
        //            gsonBuilder.setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
    } catch (ignored: Exception) {
        Log.w("GsonKtx", "gson version requires 2.8.9 or above")
    }
    gsonBuilder.disableHtmlEscaping()
    return gsonBuilder
}

fun Any.toJson(): String {
    return gsonKtx.toJson(this)
}

fun Any.toFormattedJson(): String {
    return gsonPrettyKtx.toJson(this)
}

@Throws(JsonSyntaxException::class)
fun String.toMap(): Map<*, *> {
    return gsonKtx.fromJson(this, ArrayMap::class.java)
}

fun String.toMapOrNull(): Map<*, *>? {
    return try {
        toMap()
    } catch (e: Exception) {
        null
    }
}

@Throws(JsonSyntaxException::class)
inline fun <reified T> String.toAny(): T {
    return gsonKtx.fromJson(this, T::class.java) as T
}

inline fun <reified T> String.toAnyOrNull(): T? {
    return try {
        toAny<T>()
    } catch (e: Exception) {
        null
    }
}

@Throws(JsonSyntaxException::class)
inline fun <reified T> String.toList(): List<T> {
    return gsonKtx.fromJson(this, object : TypeToken<List<T>>() {}.type)
}

inline fun <reified T>  String.toListOrNull(): List<T>? {
    return try {
        toList<T>()
    } catch (e: Exception) {
        null
    }
}
inline fun <reified T>  String.toListNotNull(): List<T> {
    return try {
        toList<T>()
    } catch (e: Exception) {
        return arrayListOf()
    }
}
