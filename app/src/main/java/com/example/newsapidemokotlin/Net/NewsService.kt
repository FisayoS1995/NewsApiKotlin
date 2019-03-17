package com.example.newsapidemokotlin.Net

import com.example.newsapidemokotlin.NewsItem
import com.example.newsapidemokotlin.TOP_HEADLINES_ENDPOINT
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?sources=talksport&apiKey=ff3fb238d6a946c4878d9f0842e30907
interface NewsService{
@GET (TOP_HEADLINES_ENDPOINT)
fun getTopHeadLine(@Query("sources") source: String,
                  @Query("apiKey")apiKey: String): Single<NewsItem>
}