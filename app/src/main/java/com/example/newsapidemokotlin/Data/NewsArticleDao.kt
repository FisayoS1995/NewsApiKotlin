package com.example.newsapidemokotlin.Data

import android.arch.persistence.room.*
import com.example.newsapidemokotlin.Article
import io.reactivex.Maybe

@Dao
interface NewsArticleDao{
    @Query("SELECT * FROM articles")
    fun getAllArticles(): Maybe<List<Article>>

    @Insert
    fun addArticle(article: Article)

    @Update
    fun updateArticle(article: Article)

    @Delete
    fun deleteArticle(article: Article)
}