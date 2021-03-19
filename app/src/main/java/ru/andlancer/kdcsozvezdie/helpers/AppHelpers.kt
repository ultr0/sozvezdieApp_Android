package ru.andlancer.kdcsozvezdie.helpers


import android.content.Context
import android.graphics.drawable.Drawable
import java.util.*

interface AppHelpers {

    fun getContext(): Context

    fun showMessage(str: String)

    fun getStrings(inId: Int): String

    fun getDrawable(inId: Int): Drawable?

    fun ToastMessage(str: String)

    fun getDateFormat(date: Date): String

    fun isDate(string: String): Boolean
}