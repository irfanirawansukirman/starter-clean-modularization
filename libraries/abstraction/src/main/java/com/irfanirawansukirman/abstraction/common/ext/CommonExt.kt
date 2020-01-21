package com.irfanirawansukirman.abstraction.common.ext

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.irfanirawansukirman.abstraction.common.DATE_DEFAULT
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.net.URLDecoder
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

fun showSnackbar(@StringRes message: Int, rootView: View) =
    Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()

fun showSnackbar(message: String, rootView: View) =
    Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()

fun showToast(context: Context, message: String) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

fun shareIntentLink(title: String, content: String): Intent {
    val finalShareLink = URLDecoder.decode(content, "UTF-8")

    val sharingIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, finalShareLink)
    }
    return Intent.createChooser(sharingIntent, title)
}

fun getJson() = Json(JsonConfiguration.Stable)

fun getCurrentDate(dateFormat: String): String {
    val simpleDateFormat = SimpleDateFormat(dateFormat, Locale("id", "ID"))
    return simpleDateFormat.format(Date())
}

fun getCurrentTime(timeFormat: String): String {
    val simpleDateFormat = SimpleDateFormat(timeFormat, Locale("id", "ID"))
    return simpleDateFormat.format(Date())
}

fun logD(TAG: Class<*>, message: String) {
    Log.d(TAG.simpleName, message)
}

fun logE(TAG: Class<*>, message: String) {
    Log.d(TAG.simpleName, message)
}

fun convertCurrencyToRupiah(currency: Any): String {
    val localeId = Locale("id", "ID")
    val rupiahFormat = NumberFormat.getCurrencyInstance(localeId)

    return rupiahFormat.format(currency.toString().toDouble()).replace("Rp", "Rp ")
}

fun convertDateToNewFormat(date: String, format: String): String {
    val timeMillis = (SimpleDateFormat(DATE_DEFAULT, Locale("id", "ID")).parse(date) as Date).time
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = timeMillis

    return SimpleDateFormat(format, Locale("id", "ID")).format(calendar.time)
}

fun isEmailValid(email: String): Boolean {
    val emailPattern = Pattern.compile(
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    )
    return emailPattern.matcher(email.trim()).matches()
}

fun isPhoneValid(phone: String): Boolean {
    val phonePattern = Pattern.compile(
        "[+]?[0-9]+"
    )

    return phonePattern.matcher(phone).matches()
}

inline fun <reified T> List<*>.asListOfType(): List<T>? =
    if (all { it is T })
        @Suppress("UNCHECKED_CAST")
        this as List<T> else
        null

inline fun <reified T : AppCompatActivity> navigator(context: Context) {
    val intent = Intent(context, T::class.java)
    context.startActivity(intent)

    //=========== How to using it ===========
    // navigator<YourActivity>()
    //=======================================
}

inline fun <reified T : AppCompatActivity> navigator(
    context: Context,
    intentParams: Intent.() -> Unit
) {
    val intent = Intent(context, T::class.java)
    intent.intentParams()
    context.startActivity(intent)

    //=========== How to using it ===========
    // navigator<DetailActivity> {
    //        putExtra("KEY1" , "VALUE1")
    //        putExtra("KEY2" , "VALUE2")
    //    }
    //=======================================
}