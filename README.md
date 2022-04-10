## 导入
```
org.json的扩展
implementation 'io.xiandan:json-ktx:1.0.0'

gson的扩展
implementation 'io.xiandan:gson-ktx:1.0.0'
```

## API
### JSONObject
```
// json转非空JSONObject 转换异常时抛JSONException
val jsonObject: JSONObject = json.toJSONObject()

// json转可空JSONObject
val jsonObjectOrNull: JSONObject? = json.toJSONObjectOrNull()

// 以List形式获取JSONObject所有key
val keyList: List<String> = jsonObject.keyList()

// 以Set形式获取JSONObject所有key
val keySet: Set<String> = jsonObject.keySet()

// 从JSONObject中获取可空对象
val anyValue: Any? = jsonObject.getOrNull(key)

// 从JSONObject中获取可空String
val stringValue: String? = jsonObject.getStringOrNull(key)

// 从JSONObject中获取可空Boolean
val booleanValue: Boolean? = jsonObject.getBooleanOrNull(key)

// 从JSONObject中获取可空Double
val doubleValue: Double? = jsonObject.getDoubleOrNull(key)

// 从JSONObject中获取可空Float
val floatValue: Float? = jsonObject.getFloatOrNull(key)

// 从JSONObject中获取可空Int
val intValue: Int? = jsonObject.getIntOrNull(key)

// 从JSONObject中获取可空Long
val longValue: Long? = jsonObject.getLongOrNull(key)

// 从JSONObject中获取可空JSONObject
val jsonObjectValue: JSONObject? = jsonObject.getJSONObjectOrNull(key)

// 从JSONObject中获取可空JSONArray
val jsonArrayValue: JSONArray? = jsonObject.getJSONArrayOrNull(key)

// JSONObject转json并去除转义
val unescapeString: String = jsonObject.toUnescapeString()
```

### JSONArray
```
// json转非空JSONArray 转换异常时抛JSONException
val jsonArray: JSONArray = arrayJson.toJSONArray()

// json转可空JSONArray
val jsonArrayOrNull: JSONArray? = arrayJson.toJSONArrayOrNull()

// 遍历JSONArray
jsonArray.forEachIndexed { src, index ->
    val itemValue = src.optString(index)
}

// JSONArray转List
val listValue: List<String> = jsonArray.toList { src, index -> src.optString(index) }
// JSONArray转Array
val arrayValue: Array<String?> = jsonArray.toArray { src, index -> src.optString(index) }
```

### Gson
```
// 对象转json
val jsonString = exampleObject.toJson()
println("toJson $jsonString")

// 对象转格式化后的json
val formattedJsonString = exampleObject.toFormattedJson()
println("toFormattedJson $formattedJsonString")

// json转非空Map 解析异常时抛JsonSyntaxException
val map: Map<*, *> = json.toMap()
println("toMap ${map::class.java} $map")

// json转可空Map
val mapOrNull: Map<*, *>? = json.toMapOrNull()
println("toMapOrNull $mapOrNull")

// json转非空对象 解析异常时抛JsonSyntaxException
val any: People = json.toAny()
println("toAny ${any::class.java} $any")

// json转可空对象
val anyOrNull: People? = json.toAnyOrNull()
println("toAnyOrNull $anyOrNull")

// json转非空List 解析异常时抛JsonSyntaxException
val list: List<People> = exampleArrayJson.toList<People>()
println("toList ${list::class.java} $list")

// json转可空List
val listOrNull: List<People>? = arrayJson.toListOrNull<People>()
println("toListOrNull $listOrNull")

// json转非空List
val listNotNull: List<People> = arrayJson.toListNotNull<People>()
println("toListNotNull ${listNotNull::class.java} $listNotNull")
```