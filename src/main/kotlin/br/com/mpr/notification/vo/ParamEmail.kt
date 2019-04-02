package br.com.mpr.notification.vo

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class ParamEmail(@field:NotEmpty(message = "Atributo 'to' nao pode ser null")
                      @field:NotNull(message = "Atributo 'to' nao pode ser null")
                      @field:Email(message = "Atributo 'to' não é um email válido!")
                      val to : String,
                      @field:NotNull(message = "Atributo 'template' nao pode ser null")
                      val template : EmailTemplate,
                      val params : Map<String,String>)