package br.com.mpr.notification.rest

import br.com.mpr.notification.service.sendMail
import br.com.mpr.notification.vo.ParamEmail
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class NotificationRest{


    @PostMapping(path = ["/email/send"])
    fun send(@RequestBody emailParam: ParamEmail){
        sendMail(emailParam)
    }


}