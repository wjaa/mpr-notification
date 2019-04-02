package br.com.mpr.notification.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("mail.props")
class MailProperties{
    lateinit var hostName: String
    lateinit var port : Integer
    lateinit var user: String
    lateinit var pass: String
    lateinit var fromName: String
}
