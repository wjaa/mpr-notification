package br.com.mpr.notification.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NotificationRest{


    @GetMapping(path = ["/send"])
    fun sendMail(){
        sendMail()
    }


}