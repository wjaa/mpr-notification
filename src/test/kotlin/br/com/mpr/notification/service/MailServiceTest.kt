package br.com.mpr.notification.service

import br.com.mpr.notification.vo.EmailTemplate
import br.com.mpr.notification.vo.ParamEmail
import org.junit.Test
import java.lang.StringBuilder

class MailServiceTest {



    @Test
    fun send() {
        val param = ParamEmail("wag182@gmail.com",
                EmailTemplate.PEDIDO_CRIADO,mapOf("{NOME_CLIENTE}" to "Wagner Jeronimo",
                "{NUMERO_PEDIDO}" to "123456789",
                "{LINK_PEDIDO}" to "https://meuportaretrato.com",
                "{JSON_ITEMS}" to createJsonItens()
                )
        )
        sendMail(param)
    }

    private fun createJsonItens(): String {
        val json = StringBuilder()
        json.append("{'items':[")
                .append("{'values':[")
                .append("{'key': '{URL_IMAGEM}',")
                .append("'value': 'http://stc.meuportaretrato.com/images/d/58c4299ab99a01b6c5b2c8742baf1ed6.png'},")
                .append("{'key': '{QUANTIDADE}',")
                .append("'value': '1'},")
                .append("{'key': '{VALOR_PRODUTO}',")
                .append("'value': '59,99'},")
                .append("{'key': '{DESCRICAO_PRODUTO}',")
                .append("'value': 'Porta retrato 10x15 laqueado amarelo'}]},")
                .append("{'values':[")
                .append("{'key': '{URL_IMAGEM}',")
                .append("'value': 'http://stc.meuportaretrato.com/images/email/impressao_foto.png'},")
                .append("{'key': '{QUANTIDADE}',")
                .append("'value': '1'},")
                .append("{'key': '{VALOR_PRODUTO}',")
                .append("'value': '0,00'},")
                .append("{'key': '{DESCRICAO_PRODUTO}',")
                .append("'value': 'Foto impressa'}]}")

        json.append("]}")
        return json.toString()
    }

}
