package com.example.mypractical.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractical.BR
import com.example.mypractical.data.model.MoviesModel
import com.example.mypractical.databinding.MoviesAdpaterBinding

class MoviePagingAdapter
    : PagingDataAdapter<MoviesModel.Search, MoviePagingAdapter.MyViewHolder>(DiffUtil) {
    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<MoviesModel.Search>() {
            override fun areItemsTheSame(
                oldItem: MoviesModel.Search,
                newItem: MoviesModel.Search
            ): Boolean {
                return oldItem.imdbID == newItem.imdbID
            }

            override fun areContentsTheSame(
                oldItem: MoviesModel.Search,
                newItem: MoviesModel.Search
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class MyViewHolder(val moviewAdapterBinding: MoviesAdpaterBinding): RecyclerView.ViewHolder(moviewAdapterBinding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.moviewAdapterBinding.setVariable(BR.filmModel,getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MoviesAdpaterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

}