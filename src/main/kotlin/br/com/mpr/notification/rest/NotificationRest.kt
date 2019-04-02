package br.com.mpr.notification.rest

import br.com.mpr.notification.service.MailService
import br.com.mpr.notification.vo.ParamEmail
import br.com.mpr.notification.vo.SendResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class NotificationRest{


    @Autowired
    lateinit var mailService: MailService

    @PostMapping(path = ["/email/send"])
    fun send(@RequestBody @Valid emailParam: ParamEmail): SendResult {
        return mailService.sendMail(emailParam)
    }


}