package main

import kotlin.random.Random
import main.Mesajyolla
import kotlin.system.exitProcess

fun main() {
    val webhookUrl = "WebhookUrlyi yazın"
    val randomsayi = Random.nextInt(1111,9999)
    val gizlikod = randomsayi.toString()
    Mesajyolla(webhookUrl, gizlikod)  //Webhook Mesaj Gönderirken Mesajyolla("webhookurl", "message") şeklinde gönderilir
    print("Gizli Kodu Giriniz!\n>")
    val auth = readLine()

    if (auth != gizlikod) // eğer verilen mesaj gizlikod a eşit değilse uygulamayı kapat
    {
        print("Kod Hatalı!")
        exitProcess(0)
    }
    println("Kod Doğru")
}