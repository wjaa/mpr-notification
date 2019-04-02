package br.com.mpr.notification.service

import br.com.mpr.notification.vo.EmailTemplate
import br.com.mpr.notification.vo.ParamEmail
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import java.lang.StringBuilder

@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("test")
class MailServiceTest {

    @Autowired
    lateinit var mailService: MailService

    //val emails = "wag182@gmail.com;feehpinazo@gmail.com"
    val emails = "ti.wagnerj@braspress.com"

    @Test
    fun sendEmailPedidoCriado() {
        val param = ParamEmail(emails,
                EmailTemplate.PEDIDO_CRIADO,mapOf("{NOME_CLIENTE}" to "Wagner Jeronimo",
                "{NUMERO_PEDIDO}" to "123456789",
                "{LINK_PEDIDO}" to "https://meuportaretrato.com",
                "{JSON_ITEMS}" to createJsonItens(),
                "{IMG_TIPO_PAGAMENTO}" to "https://static.belezanaweb.com.br/email_template/images/17011302/mastercard.png",
                "{TIPO_PAGAMENTO}" to "Cartão de Crédito",
                "{SUB_TOTAL}" to "50,50",
                "{FRETE}" to "12,00",
                "{TOTAL}" to "62,50",
                "{NOME_ENDERECO}" to "Endereço de Casa",
                "{ENDERECO_1}" to "Rua antonio gomes, 135 apto 133 bloco natureza",
                "{ENDERECO_2}" to "07093090 GUARULHOS SP",
                "{ENDERECO_REFERENCIA}" to "Travessa da mae dos homens",
                "{TIPO_FRETE}" to "Express",
                "{DIAS_ENTREGA}" to "2"

                )
        )
        mailService.sendMail(param)
    }

    @Test
    fun sendEmailPedidoEnviado() {
        val param = ParamEmail(emails,
                EmailTemplate.PEDIDO_ENVIADO,mapOf("{NOME_CLIENTE}" to "Wagner Jeronimo",
                "{NUMERO_PEDIDO}" to "123456789",
                "{LINK_PEDIDO}" to "https://meuportaretrato.com",
                "{LINK_NOTAFISCAL}" to "https://meuportaretrato.com",
                "{NUMERO_NOTAFISCAL}" to "8745889",
                "{JSON_ITEMS}" to createJsonItens(),
                "{IMG_TIPO_PAGAMENTO}" to "https://static.belezanaweb.com.br/email_template/images/17011302/mastercard.png",
                "{TIPO_PAGAMENTO}" to "Cartão de Crédito",
                "{SUB_TOTAL}" to "50,50",
                "{FRETE}" to "12,00",
                "{TOTAL}" to "62,50",
                "{NOME_ENDERECO}" to "Endereço de Casa",
                "{ENDERECO_1}" to "Rua antonio gomes, 135 apto 133 bloco natureza",
                "{ENDERECO_2}" to "07093090 GUARULHOS SP",
                "{ENDERECO_REFERENCIA}" to "Travessa da mae dos homens",
                "{TIPO_FRETE}" to "Express",
                "{DIAS_ENTREGA}" to "2"
            )
        )
        mailService.sendMail(param)
    }

    @Test
    fun sendEmailPedidoCancelado() {
        val param = ParamEmail(emails,
                EmailTemplate.PEDIDO_CANCELADO,mapOf("{NOME_CLIENTE}" to "Wagner Jeronimo",
                "{NUMERO_PEDIDO}" to "123456789",
                "{LINK_PEDIDO}" to "https://meuportaretrato.com",
                "{JSON_ITEMS}" to createJsonItens()
            )
        )
        mailService.sendMail(param)
    }

    @Test
    fun sendEmailEsqueceuSenha() {
        val param = ParamEmail(emails,
                EmailTemplate.ESQUECEU_SENHA,mapOf("{NOME_CLIENTE}" to "Wagner Jeronimo",
                "{LINK_TROCA_SENHA}" to "https://meuportaretrato.com"
            )
        )
        mailService.sendMail(param)
    }

    @Test
    fun sendEmailNovoCliente() {
        val param = ParamEmail(emails,
                EmailTemplate.USUARIO_CRIADO,mapOf("{NOME_CLIENTE}" to "Wagner Jeronimo"
            )
        )
        mailService.sendMail(param)
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
