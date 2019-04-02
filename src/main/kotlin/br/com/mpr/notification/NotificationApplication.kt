package br.com.mpr.notification

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotificationApplication

fun main(args: Array<String>) {

	println(""" http://patorjk.com - font:Small

  _  _  ___ _____ ___ ___ ___ ___   _ _____ ___ ___  _  _
 | \| |/ _ \_   _|_ _| __|_ _/ __| /_\_   _|_ _/ _ \| \| |
 | .` | (_) || |  | || _| | | (__ / _ \| |  | | (_) | .` |
 |_|\_|\___/ |_| |___|_| |___\___/_/ \_\_| |___\___/|_|\_|
  :: mpr-notification ::                         (v1.0.0)

""".trimIndent())


	runApplication<NotificationApplication>(*args)
}
