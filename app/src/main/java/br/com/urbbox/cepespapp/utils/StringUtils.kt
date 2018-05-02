package br.com.urbbox.cepespapp.utils

fun String.beginWithLowerCase(): String {
    return when (this.length) {
        0 -> ""
        1 -> this.toLowerCase()
        else -> this[0].toLowerCase() + this.substring(1)
    }
}

fun String.beginWithUpperCase(): String {
    return when (this.length) {
        0 -> ""
        1 -> this.toUpperCase()
        else -> this[0].toUpperCase() + this.substring(1)
    }
}

fun String.toCamelCase(): String {
    return this.split('_').joinToString("") {
        it.beginWithUpperCase()
    }
}

fun String.toSnakeCase(): String {
    var text: String = ""
    var isFirst = true
    this.forEach {
        if (it.isUpperCase()) {
            if (isFirst) isFirst = false
            else text += "_"
            text += it.toLowerCase()
        } else {
            text += it
        }
    }
    return text
}
