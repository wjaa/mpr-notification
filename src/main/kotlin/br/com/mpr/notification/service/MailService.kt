package br.com.mpr.notification.service

import org.apache.commons.mail.HtmlEmail

fun sendMail(){
    val mail = HtmlEmail()
    mail.addTo("wag182@gmail.com")
    mail.hostName = "smtp.zoho.com"
    mail.setSmtpPort(465)
    mail.setAuthentication("noreply@meuportaretrato.com", "*F071212f*")
    mail.setFrom("noreply@meuportaretrato.com", "MeuPortaRetrato.com", "UTF-8")
    mail.setHtmlMsg("corpo do email ")
    mail.subject = "titulo do email"
    mail.isSSLOnConnect = true
    mail.setCharset("UTF-8")
    mail.send()
}
