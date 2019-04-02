package br.com.mpr.notification.rest

import br.com.mpr.notification.vo.SendResult
import org.apache.commons.logging.LogFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@RestController
class ResponseExceptionHandler : ResponseEntityExceptionHandler(){
    private val LOG = LogFactory.getLog(ResponseExceptionHandler::class.java)

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException,
                                              headers: HttpHeaders, status: HttpStatus,
                                              request: WebRequest): ResponseEntity<Any> {
        LOG.error("m=handleMethodArgumentNotValid, error=" + ex.message)
        val sendResult = SendResult(true, getStrMessageErrors(ex.bindingResult))
        return ResponseEntity(sendResult, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Throwable::class)
    fun handleException(ex: Throwable, request: WebRequest): ResponseEntity<SendResult> {
        LOG.error("m=handleException, error=" + ex.message)
        return ResponseEntity<SendResult>(SendResult(true,ex.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleException(ex: RuntimeException, request: WebRequest): ResponseEntity<SendResult> {
        LOG.error("m=handleException, error=" + ex.message)
        return ResponseEntity<SendResult>(SendResult(true,ex.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }


    private fun getStrMessageErrors(bindingResult: BindingResult): String? {
        var strErros = ""
        var count = 0
        for (error in bindingResult.allErrors) {
            strErros += error.defaultMessage + " | "
        }
        return strErros
    }
}