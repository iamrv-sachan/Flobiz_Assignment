package com.rajdroid.flobizassignment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajdroid.flobizassignment.entity.Article
import com.rajdroid.flobizassignment.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val newsResponse1 = MutableLiveData<List<Article>>()
    val newsResponse: LiveData<List<Article>>
        get() = newsResponse1

    init {
        getAllNews()
    }

    private fun getAllNews()
    {
        Log.i("rajeev","dada")
        viewModelScope.launch {
            repository.getNews().let {
                if(it.isSuccessful)
                {
                    Log.i("rajeev",it.toString())
                    newsResponse1.postValue(it.body()!!.articles)
                }
                else{
                    Log.i("rajeev",it.toString())
                    //Log.d("raj", "Error: ${it.code()}")
                }
            }
        }
    }
}