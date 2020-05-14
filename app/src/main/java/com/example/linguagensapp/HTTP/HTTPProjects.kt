package com.example.linguagensapp.HTTP

import android.util.Log
import com.example.linguagensapp.Models.ProjectModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

object HTTPProjects {
    val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(10000, TimeUnit.MILLISECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()
    fun getProjs(s: String?): List<ProjectModel>{
        var r = s
        if (r == "C++"){
            r = "cpp"
        }
        val request = Request.Builder()
            .url("https://ghapi.huchen.dev/developers?language=$r&since=weekly")
            .build()
        try{
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            val collectionType: Type = object :
                TypeToken<Collection<ProjectModel?>?>() {}.type
            val result: List<ProjectModel> =
                Gson().fromJson(
                    json, collectionType
                )
            Log.i("teste", result.size.toString())
            return result
        } catch (e: Exception){
            e.printStackTrace()
            Log.i("Teste", "$e")
        }
        return emptyList()
    }
}