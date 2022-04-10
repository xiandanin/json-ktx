package io.xiandan.ktx.json

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONTokener

/**
 * Created by xiandanin on 2022-04-10 14:22
 */

@Throws(JSONException::class)
fun String.toJSONObject(): JSONObject {
    return JSONObject(this)
}

fun String.toJSONObjectOrNull(): JSONObject? {
    return try {
        JSONObject(this)
    } catch (e: Exception) {
        null
    }
}

fun JSONObject.keySet(): Set<String> {
    val set = LinkedHashSet<String>()
    keys().forEach { set.add(it) }
    return set
}

fun JSONObject.keyList(): List<String> {
    val list = ArrayList<String>()
    keys().forEach { list.add(it) }
    return list
}

fun JSONObject.getOrNull(name: String?): Any? {
    try {
        if (name != null) return get(name)
    } catch (e: Exception) {
    }
    return null
}

fun JSONObject.getStringOrNull(name: String?): String? {
    try {
        if (name != null) return getString(name)
    } catch (e: Exception) {
    }
    return null
}

fun JSONObject.getIntOrNull(name: String?): Int? {
    try {
        if (name != null) return getInt(name)
    } catch (e: Exception) {
    }
    return null
}

fun JSONObject.getBooleanOrNull(name: String?): Boolean? {
    try {
        if (name != null) return getBoolean(name)
    } catch (e: Exception) {
    }
    return null
}

fun JSONObject.getDoubleOrNull(name: String?): Double? {
    try {
        if (name != null) return getDouble(name)
    } catch (e: Exception) {
    }
    return null
}

fun JSONObject.getLongOrNull(name: String?): Long? {
    try {
        if (name != null) return getLong(name)
    } catch (e: Exception) {
    }
    return null
}

fun JSONObject.getJSONArrayOrNull(name: String?): JSONArray? {
    try {
        if (name != null) return getJSONArray(name)
    } catch (e: Exception) {
    }
    return null
}

fun JSONObject.getJSONObjectOrNull(name: String?): JSONObject? {
    try {
        if (name != null) return getJSONObject(name)
    } catch (e: Exception) {
    }
    return null
}

fun JSONObject.getFloatOrNull(name: String?): Float? {
    return getDoubleOrNull(name)?.toFloat()
}

fun JSONObject.optFloat(name: String?): Float {
    return optDouble(name).toFloat()
}

fun JSONObject.optFloat(name: String?, fallback: Float): Float {
    return optDouble(name, fallback.toDouble()).toFloat()
}

fun JSONObject.toUnescapeString(): String {
    return StringEscapeUtils.unescapeJson(toString())
}

fun JSONObject.toUnescapeString(indentSpaces: Int): String {
    return StringEscapeUtils.unescapeJson(toString(indentSpaces))
}

fun JSONArray.getOrNull(index: Int): Any? {
    try {
        return get(index)
    } catch (e: Exception) {
    }
    return null
}

fun JSONArray.getStringOrNull(index: Int): String? {
    try {
        return getString(index)
    } catch (e: Exception) {
    }
    return null
}

fun JSONArray.getIntOrNull(index: Int): Int? {
    try {
        return getInt(index)
    } catch (e: Exception) {
    }
    return null
}

fun JSONArray.getBooleanOrNull(index: Int): Boolean? {
    try {
        return getBoolean(index)
    } catch (e: Exception) {
    }
    return null
}

fun JSONArray.getDoubleOrNull(index: Int): Double? {
    try {
        return getDouble(index)
    } catch (e: Exception) {
    }
    return null
}

fun JSONArray.getLongOrNull(index: Int): Long? {
    try {
        return getLong(index)
    } catch (e: Exception) {
    }
    return null
}

fun JSONArray.getJSONArrayOrNull(index: Int): JSONArray? {
    try {
        return getJSONArray(index)
    } catch (e: Exception) {
    }
    return null
}

fun JSONArray.getJSONObjectOrNull(index: Int): JSONObject? {
    try {
        return getJSONObject(index)
    } catch (e: Exception) {
    }
    return null
}

fun JSONArray.getFloatOrNull(index: Int): Float? {
    return getDoubleOrNull(index)?.toFloat()
}

fun JSONArray.optFloat(index: Int): Float {
    return optDouble(index).toFloat()
}

fun JSONArray.optFloat(index: Int, fallback: Float): Float {
    return optDouble(index, fallback.toDouble()).toFloat()
}

fun JSONArray.toUnescapeString(): String {
    return StringEscapeUtils.unescapeJson(toString())
}

fun JSONArray.toUnescapeString(indentSpaces: Int): String {
    return StringEscapeUtils.unescapeJson(toString(indentSpaces))
}

@Throws(JSONException::class)
fun String.toJSONArray(): JSONArray {
    return JSONArray(this)
}

fun String.toJSONArrayOrNull(): JSONArray? {
    return try {
        JSONArray(this)
    } catch (e: Exception) {
        null
    }
}

inline fun <T> JSONArray.toList(transform: (src: JSONArray, index: Int) -> T?): List<T> {
    val list = ArrayList<T>()
    for (i in 0 until length()) {
        val it = transform(this, i)
        if (it != null) {
            list.add(it)
        }
    }
    return list
}

inline fun <reified T> JSONArray.toArray(transform: (src: JSONArray, index: Int) -> T?): Array<T?> {
    val array = arrayOfNulls<T?>(length())
    for (i in array.indices) {
        array[i] = transform(this, i)
    }
    return array
}

inline fun JSONArray.forEachIndexed(action: (src: JSONArray, index: Int) -> Unit) {
    for (i in 0 until length()) {
        action(this, i)
    }
}

fun JSONTokener.nextValueOrNull(): Any? {
    return try {
        nextValue()
    } catch (e: Exception) {
        null
    }
}

