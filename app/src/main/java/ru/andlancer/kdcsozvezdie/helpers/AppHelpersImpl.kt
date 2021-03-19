package ru.andlancer.kdcsozvezdie.helpers

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.Toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AppHelpersImpl @Inject constructor(private val context: Context): AppHelpers {

    override fun getContext(): Context = context

    override fun showMessage(str: String) {
        Log.e("log", str)
    }

    override fun ToastMessage(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }

    override fun getDateFormat(date: Date): String = SimpleDateFormat("yyyy-MM-dd").format(date)

    override fun isDate(string: String): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        dateFormat.isLenient = false
        try {
            dateFormat.parse(string.trim())
        } catch (pe: ParseException) {
            return false
        }
        return true
    }


    override fun getStrings(inId: Int): String = context.getString(inId)

    override fun getDrawable(inId: Int): Drawable? = context.getDrawable(inId)

}