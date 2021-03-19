package ru.andlancer.kdcsozvezdie.network.Adapters


import com.google.gson.*
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class DateDeserializer: JsonDeserializer<Date> {


    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date {
        val dateStr: String? = json?.getAsString()
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        try {
            return format.parse(dateStr)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return Date()
    }
}
