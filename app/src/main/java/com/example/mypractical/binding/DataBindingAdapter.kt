package com.example.mypractical.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractical.data.model.TopicModel
import com.example.mypractical.ui.main.adapter.MainAdapter

@BindingAdapter("bindMainAdapter")
fun bindMainAdapter(view: RecyclerView, list: List<TopicModel.Data.Topic>) {
    val layoutManager = view.layoutManager
    if (layoutManager == null)
        view.layoutManager = LinearLayoutManager(view.context)
    var adapter : MainAdapter? = view.adapter as? MainAdapter
    if (adapter == null) {
        adapter = MainAdapter(view.context, list.toMutableList())
        view.adapter = adapter
    } else {
        adapter.updateDataList(list)
    }
}


