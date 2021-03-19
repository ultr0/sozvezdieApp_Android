package ru.andlancer.kdcsozvezdie.helpers

import android.graphics.drawable.Drawable
import java.text.DateFormat
import java.text.SimpleDateFormat

object DataBindingHelpers {

    @JvmStatic
    fun getWeekDay(date: String): String {

        val week = arrayOf(
            "Воскресенье",
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница",
            "Суббота"
        )

        val date = SimpleDateFormat("yyyy-MM-dd").parse(date)

        val dateInfo = DateFormat.getDateInstance(DateFormat.FULL).format(date)

        return week.get(date.day)

    }


    @JvmStatic
    fun getOsadki(type: String): Drawable? {
        return when (type) {
//            "ovc_sn" -> DI.appComponent.context().getDrawable(R.drawable.ic_ovc_sn)
//            "ovc_-sn" -> DI.appComponent.context().getDrawable(R.drawable.ic_ovc__sn)
//            "bkn_d" -> DI.appComponent.context().getDrawable(R.drawable.ic_bkn_d)
//            "bkn_-sn_d" -> DI.appComponent.context().getDrawable(R.drawable.ic_bkn__sn_d)
//            "skc_d" -> DI.appComponent.context().getDrawable(R.drawable.ic_skc_d)
            else -> null
        }

    }

    @JvmStatic
    fun getGradus(temp: Int): String ="$temp \u2103"

}