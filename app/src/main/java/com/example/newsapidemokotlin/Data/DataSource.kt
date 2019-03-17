package com.example.newsapidemokotlin.Data

import com.example.newsapidemokotlin.Article
import io.reactivex.Maybe
import java.nio.channels.spi.AbstractSelectionKey

interface DataSource {
    fun getTopNewsHeadlines(source: String, apiKey: String): Maybe<List<Article>>
    fun addNewsHeadline(article: Article)
}