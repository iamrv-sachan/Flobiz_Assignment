package com.rajdroid.flobizassignment.repo

import com.rajdroid.flobizassignment.retrofit.NewsApi
import javax.inject.Inject

class Repository @Inject constructor(private val newsApi: NewsApi) {

    suspend fun getNews() = newsApi.getDataFromAPI("cricket")

}