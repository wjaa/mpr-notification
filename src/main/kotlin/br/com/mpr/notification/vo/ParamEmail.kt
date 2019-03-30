package br.com.mpr.notification.vo

data class ParamEmail(val to : String, val template : EmailTemplate, val params : Map<String,String>)