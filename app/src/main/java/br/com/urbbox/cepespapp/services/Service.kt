package br.com.urbbox.cepespapp.services

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type


fun <T> api(type: Class<T>): T {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    val httpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

    return Retrofit.Builder()
            .baseUrl("http://cepesp-app.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson()))
            .client(httpClient)
            .build()
            .create(type)
}

fun gson(): Gson {
    return GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()
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