package br.com.mpr.notification.rest

import br.com.mpr.notification.service.MailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NotificationRest{

    @Autowired
    private lateinit var mail : MailService


    @GetMapping(path = ["/send"])
    fun sendMail(){
        mail.sendMail()
    }


}