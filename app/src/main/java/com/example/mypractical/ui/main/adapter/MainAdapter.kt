package com.example.mypractical.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractical.data.model.TopicModel
import com.example.mypractical.databinding.AdapterMainBinding
import com.example.mypractical.listner.MainListner

class MainAdapter (
    private val context: Context,
    private var dataList: List<TopicModel.Data.Topic>
) : RecyclerView.Adapter<MainAdapter.BindingViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView: ViewDataBinding =
            AdapterMainBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(
            rootView
        )
    }

    fun updateDataList(list: List<TopicModel.Data.Topic>) {
        this.dataList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val model = dataList[position]
        holder.itemBinding.setVariable(BR.mainModel, model)
        holder.itemBinding.executePendingBindings()
        //Set Item click listner in Adapte
        holder.itemBinding.setVariable(BR.listner,holder.itemBinding.root.context as MainListner)
    }

    class BindingViewHolder(val itemBinding: ViewDataBinding) : RecyclerView.ViewHolder(itemBinding.root)

}
