package com.example.newsapidemokotlin.Data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.newsapidemokotlin.Article
import com.example.newsapidemokotlin.DATABASE_VERSION

@Database(entities = [Article::class], version = DATABASE_VERSION)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsArticleDao(): NewsArticleDao
}