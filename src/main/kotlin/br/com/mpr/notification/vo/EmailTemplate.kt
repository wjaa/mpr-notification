package br.com.mpr.notification.vo

import br.com.mpr.notification.utils.getString

enum class EmailTemplate( val htmlPrincipal: String, val from: String, val title : String,
                          val htmlExtra: String = "") {

    PEDIDO_ENVIADO(
            getString(this.javaClass.classLoader.getResourceAsStream("templates/pedido_enviado.html")),
            "noreply@meuportaretrato.com",
            "Pedido Enviado!",
            getString(this.javaClass.classLoader.getResourceAsStream("templates/itens_pedido.html"))),


    PEDIDO_CRIADO(
            getString(this.javaClass.classLoader.getResourceAsStream("templates/pedido_criado.html")),
            "noreply@meuportaretrato.com",
            "Pedido Criado!",
            getString(this.javaClass.classLoader.getResourceAsStream("templates/itens_pedido.html"))),

    PEDIDO_CRIADO_BOLETO(
            getString(this.javaClass.classLoader.getResourceAsStream("templates/pedido_criado_boleto.html")),
            "noreply@meuportaretrato.com",
            "Pedido Criado!",
            getString(this.javaClass.classLoader.getResourceAsStream("templates/itens_pedido.html"))),

    PEDIDO_CANCELADO(
            getString(this.javaClass.classLoader.getResourceAsStream("templates/pedido_cancelado.html")),
            "noreply@meuportaretrato.com",
            "Pedido Cancelado!",
            getString(this.javaClass.classLoader.getResourceAsStream("templates/itens_pedido.html"))),

    USUARIO_CRIADO(
            getString(this.javaClass.classLoader.getResourceAsStream("templates/usuario_criado.html")),
            "noreply@meuportaretrato.com",
            "Usuário Criado!"),

    ESQUECEU_SENHA(
            getString(this.javaClass.classLoader.getResourceAsStream("templates/esqueceu_senha.html")),
            "noreply@meuportaretrato.com",
            "Altere sua senha.");


}
