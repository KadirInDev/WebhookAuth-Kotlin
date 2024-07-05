package main

import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

fun Mesajyolla(webhookUrl: String, message: String) {
    val url = URL(webhookUrl)
    val connection = url.openConnection() as HttpURLConnection

    connection.requestMethod = "POST"
    connection.doOutput = true
    connection.setRequestProperty("Content-Type", "application/json")

    val jsonPayload = """{"content": "$message"}"""
    val outputBytes = jsonPayload.toByteArray(StandardCharsets.UTF_8)
    connection.outputStream.write(outputBytes)

    val responseCode = connection.responseCode
    val responseMessage = connection.responseMessage


    connection.inputStream.bufferedReader().use {
        it.lines().forEach { line ->
            println(line)
        }
    }
}