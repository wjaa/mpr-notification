package br.com.mpr.notification.service

import br.com.mpr.notification.props.MailProperties
import br.com.mpr.notification.vo.ParamEmail
import br.com.mpr.notification.vo.SendResult
import org.apache.commons.mail.EmailException
import org.apache.commons.mail.HtmlEmail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

@Service
class MailService{

    @Autowired
    lateinit var properties : MailProperties

    @Autowired
    lateinit var environment: Environment

    fun sendMail(param: ParamEmail): SendResult {

        try{
            val body = buildBody(param)
            val mail = HtmlEmail()
            param.to.split(Regex.fromLiteral(";")).forEach { e -> mail.addTo(e) ; println(e)}
            mail.hostName = properties.hostName
            mail.setSmtpPort(properties.port.toInt())
            mail.setAuthentication(properties.user, properties.pass)
            mail.setFrom(param.template.from, properties.fromName, Charsets.UTF_8.name())
            mail.setHtmlMsg(body)
            mail.subject = param.template.title
            mail.isSSLOnConnect = true
            mail.setCharset(Charsets.UTF_8.name())


            if ( !environment.activeProfiles.contains("test") ){
                mail.send()
            }
        }catch (e : EmailException){
            return SendResult(true,e.message.toString())

        }catch (e : Exception){
            return SendResult(true,e.message.toString())
        }

        return SendResult(false,"ok")
    }

}
