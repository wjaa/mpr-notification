package br.com.mpr.notification.service

import br.com.mpr.notification.vo.ParamEmail
import br.com.mpr.notification.vo.ParamJsonEmail
import com.google.gson.GsonBuilder
import java.lang.StringBuilder

fun buildBody(param : ParamEmail): String {
    var strBody = param.template.htmlPrincipal

    param.params.forEach { key, value ->

        //SE TIVER UM PARAMETRO JSON É PORQUE É UM PARAMETRO ESPECIAL
        //ex.: para itens do pedido virá uma lista values para montar os itens.
        //o template precisa ter um resource separado para isso.
        if (!key.contains("JSON")){
            strBody = strBody.replace(Regex.fromLiteral(key),value)
        }else{
            strBody = strBody.replaceFirst(key,getReplaceJson(value,param.template.htmlExtra))
        }


    }

    return strBody

}

fun getReplaceJson(json: String, html: String): String {
    val strBuilder = StringBuilder()
    val gson = GsonBuilder().create()
    val param = gson.fromJson<ParamJsonEmail>(json,ParamJsonEmail::class.java)

    param.items.forEach { i ->
        var item = html
        i.values.forEach { v -> item = item.replace(Regex.fromLiteral(v.key), v.value) }
        strBuilder.append(item)
    }
    println(strBuilder)
    return strBuilder.toString()

}
