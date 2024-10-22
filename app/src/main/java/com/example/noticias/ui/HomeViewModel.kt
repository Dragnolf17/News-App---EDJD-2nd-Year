package com.example.noticias.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.noticias.Models.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

data class ArticleSate (
    val articles: ArrayList<Article> = arrayListOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ArticleSate())
    val uiState: StateFlow<ArticleSate> = _uiState.asStateFlow()

    fun fetchArticles(){
        _uiState.value = ArticleSate(
            isLoading = true,
            error = null)

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://newsapi.org/v2/top-headlines?country=us&apiKey=7e8580a647c44e288d00aa27c770bf01")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                _uiState.value = ArticleSate(
                    isLoading = true,
                    error = e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                    val articlesResult = arrayListOf<Article>()
                    val result = response.body!!.string()
                    val jsonResult = JSONObject(result)
                    val status = jsonResult.getString("status")
                    if (status == "ok"){
                        val articlesJson = jsonResult.getJSONArray("articles")
                        var articles = arrayListOf<Article>()
                        for (index in 0 until articlesJson.length()){
                            val articleJson = articlesJson.getJSONObject(index)
                            val article = Article.fromJson(articleJson)
                            articles.add(article)
                        }
                    }
                    _uiState.value = ArticleSate(
                        articles = articlesResult,
                        isLoading = false,
                        error = null)
                }
            }
        })
    }

}