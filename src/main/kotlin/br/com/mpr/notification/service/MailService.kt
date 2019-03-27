package br.com.mpr.notification.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component


@Component
class MailService{

    @Autowired
    private lateinit var mailSender: JavaMailSender


    fun sendMail(){

        val message = SimpleMailMessage()
        message.setTo("wag182@gmail.com")
        message.setSubject("mandou essa porra")
        message.setText("aeee caralho")
        message.setFrom("noreply@meuportaretrato.com")
        mailSender.send(message)


    }
}
