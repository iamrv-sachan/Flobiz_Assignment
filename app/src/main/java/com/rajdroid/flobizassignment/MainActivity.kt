package com.rajdroid.flobizassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajdroid.flobizassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),NewsAdapter.onitemClick {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.newsResponse.observe(this,
            {
                Log.i("rajeev",it.toString())
                newsAdapter = NewsAdapter(ArrayList(it),this@MainActivity)
                binding.recycler.layoutManager = LinearLayoutManager(this)
                binding.recycler.adapter = newsAdapter
            })

    }

    override fun onItemClicked(d: Int) {
        TODO("Not yet implemented")
    }
}