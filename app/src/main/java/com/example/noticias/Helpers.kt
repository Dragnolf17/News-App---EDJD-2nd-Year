package com.example.noticias

import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.parseDate() : Date? {
    val pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    return SimpleDateFormat(pattern, Locale.getDefault()).parse(this)
}

fun String.encodUrl() :String {
    return URLEncoder.encode(this, "UTF-8")
}

fun Date.toYYYYMMDD() : String {
    val pattern = "yyyy-MM-dd"
    return SimpleDateFormat(pattern, Locale.getDefault()).format(this)
}