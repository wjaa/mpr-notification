package br.com.mpr.notification.utils

import java.io.InputStream
import java.io.InputStreamReader

fun getString(resourceAsStream: InputStream?): String {
    println(resourceAsStream)
    val fileReader = InputStreamReader(resourceAsStream)
    val body = StringBuilder()
    val bff = CharArray(1024)
    var c = fileReader.read(bff, 0, 1024)
    while ( c != -1) {
        body.append(bff, 0, c)
        c = fileReader.read(bff, 0, 1024)
    }
    fileReader.close()
    return body.toString()
}