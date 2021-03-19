package ru.andlancer.kdcsozvezdie.network.Adapters


import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*


class DateSerializer: JsonSerializer<Date> {

    override fun serialize(
        date: Date?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
//        val formatter = SimpleDateFormat("yyyy-MM-dd")
//        formatter.setTimeZone(TimeZone.getDefault())
//        val dateFormatAsString: String = formatter.format(date)
//        return JsonPrimitive(dateFormatAsString)
        return JsonPrimitive(date?.time ?: 0L)
    }
}
