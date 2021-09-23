package com.rajdroid.flobizassignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajdroid.flobizassignment.databinding.ActivityMainBinding
import com.rajdroid.flobizassignment.entity.Article
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),NewsAdapter.onitemClick {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter
    lateinit var list:ArrayList<Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList()

        viewModel.newsResponse.observe(this,
            {
                Log.i("rajeev",it.toString())
                list.clear()
                list.addAll(ArrayList(it))
                newsAdapter = NewsAdapter(ArrayList(it),this@MainActivity)
                binding.recycler.layoutManager = LinearLayoutManager(this)
                binding.recycler.adapter = newsAdapter
            })

    }

    override fun onItemClicked(d: Int) {
        val url = list.get(d).url
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}