package br.com.urbbox.cepespapp.services

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.*

fun <T> api(type: Class<T>): T {
    return Service.retrofit.create(type)
}

fun gson(): Gson {
    return Service.gson
}

fun formatDate(date: Date?): String? {
    return if (date != null)
        formatDate(date)
    else
        null
}

fun <T> serialize(obj: T): String {
    return gson().toJson(obj, object : TypeToken<T>() {}.type)
}

fun <T> deserialize(data: String): T {
    val type = object : TypeToken<T>() {}.type
    return gson().fromJson<T>(data, type)
}

fun <T> deserialize(data: String, type: Type): T {
    return gson().fromJson<T>(data, type)
}

fun <T> deserialize(data: String, type: Class<T>): T {
    return gson().fromJson<T>(data, type)
}

object Service {

    val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()!!

    val retrofit = Retrofit.Builder()
            .baseUrl("http://cepesp-app.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()!!

}