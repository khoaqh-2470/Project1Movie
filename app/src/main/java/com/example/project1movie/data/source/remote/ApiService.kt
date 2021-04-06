package com.example.project1movie.data.source.remote

import com.example.project1movie.utils.Constants
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ApiService {

    fun httpGet(myURL: String?): String {
        val url = URL(myURL)
        val httpURLConnection = url.openConnection().let {
            it as HttpURLConnection
        }.apply {
            connectTimeout = 15000
            readTimeout = 15000
            requestMethod = Constants.METHOD_GET
            doOutput = true
            connect()
        }

        val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        val stringBuilder = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuilder.toString()
    }
}
