package br.com.mpr.notification.service

import br.com.mpr.notification.vo.ParamEmail
import org.apache.commons.mail.HtmlEmail

fun sendMail(param: ParamEmail){

    val body = buildBody(param)

    val mail = HtmlEmail()
    param.to.split(Regex.fromLiteral(";")).forEach { e -> mail.addTo(e) ; println(e)}
    mail.hostName = "smtp.gmail.com"
    mail.setSmtpPort(465)
    mail.setAuthentication("noreply@meuportaretrato.com", "*f071212*")
    mail.setFrom(param.template.from, "MeuPortaRetrato.com", "UTF-8")
    mail.setHtmlMsg(body)
    mail.subject = param.template.title
    mail.isSSLOnConnect = true
    mail.setCharset("UTF-8")
    mail.send()
}
