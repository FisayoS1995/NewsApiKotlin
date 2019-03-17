package com.example.newsapidemokotlin.home

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.newsapidemokotlin.API_KEY
import com.example.newsapidemokotlin.Article
import com.example.newsapidemokotlin.Data.DataSource
import com.example.newsapidemokotlin.Data.LocalDataSource
import com.example.newsapidemokotlin.Data.NewsRepository
import com.example.newsapidemokotlin.Data.RemoteDataSource
import com.example.newsapidemokotlin.NEWS_SOURCE
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlin.math.log

class HomeViewModel : ViewModel() {
    private val articleObservable: MutableLiveData<List<Article>> = MutableLiveData()
    private  val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getArticleObservable(): LiveData<List<Article>> = articleObservable
    private lateinit var repository: DataSource

    fun getArticle(application: Application) {
        repository = NewsRepository(remoteDataSource = RemoteDataSource(),
            localDataSource = LocalDataSource(application))
        compositeDisposable.add(repository.getTopNewsHeadlines(NEWS_SOURCE, API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ Log.d("News Description:", it[0].description)}, {
                it.printStackTrace()
            }))

    }
}