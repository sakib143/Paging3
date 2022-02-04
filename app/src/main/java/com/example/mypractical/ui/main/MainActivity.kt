package com.example.mypractical.ui.main

import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractical.R
import com.example.mypractical.base.BaseBindingActivity
import com.example.mypractical.data.model.TopicModel
import com.example.mypractical.databinding.ActivityMainBinding
import com.example.mypractical.ui.main.adapter.MoviePagingAdapter
import javax.inject.Inject

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    @Inject
    lateinit var viewModel: MovieViewModel
    override fun layoutId() = R.layout.activity_main
    private var binding: ActivityMainBinding? = null
    private var alMain: ArrayList<TopicModel.Data.Topic> = ArrayList()


    private lateinit var rvMovies: RecyclerView
    val movieAdapter = MoviePagingAdapter()
    private lateinit var edtSearchMovies: SearchView

    override fun initializeBinding(binding: ActivityMainBinding) {
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.listner = this
        binding.alMain = alMain
        this.binding = binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rvMovies = findViewById(R.id.rvMovies)
        edtSearchMovies= findViewById(R.id.edtSearchMovies)


        rvMovies.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

        viewModel.list.observe(this) {
            movieAdapter.submitData(lifecycle, it)
        }

        edtSearchMovies.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        viewModel.setQuery(it)
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
    }

}