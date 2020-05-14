package com.example.linguagensapp.HTTP

import android.util.Log
import com.example.linguagensapp.Models.LangReturn
import com.example.linguagensapp.Models.LanguageModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit


object HTTPlang {
    val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(10000, TimeUnit.MILLISECONDS)
        .connectTimeout(5,TimeUnit.SECONDS)
        .build()

    fun getLangs(): List<LanguageModel>?{
        val request = Request.Builder()
            .url("https://cultura-languages.herokuapp.com/languages?page=1")
            .build()
        Log.i("Teste", "$request")
        try {
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            val collectionType: Type = object :
                TypeToken<Collection<LanguageModel?>?>() {}.type
            val result: List<LanguageModel> =
                Gson().fromJson<List<LanguageModel>>(
                    json, collectionType
                )
            Log.i("teste", result.size.toString())

            return result
        } catch (e: Exception){
            e.printStackTrace()
            Log.i("Teste", "$e")
        }
        return null
    }
}