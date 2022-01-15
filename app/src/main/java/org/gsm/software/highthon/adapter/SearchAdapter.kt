package org.gsm.software.highthon.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.gsm.software.highthon.R
import org.gsm.software.highthon.databinding.ResultItemBinding
import org.gsm.software.highthon.model.schoolinfo.Row
import org.gsm.software.highthon.viewmodel.activity.SearchViewModel

class SearchAdapter() : ListAdapter<Row, SearchAdapter.ViewHolder>(MainDiffUtil) {
    companion object MainDiffUtil: DiffUtil.ItemCallback<Row>(){
        override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
            //각 아이템들의 고유한 값을 비교해야 한다.
            return oldItem.ORG_RDNMA == newItem.ORG_RDNMA
        }

        override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
            return oldItem==newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ResultItemBinding>(
            layoutInflater,
            viewType,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.result_item
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))

        //item 간의 사이 조절
        val layoutParams = holder.itemView.layoutParams
        layoutParams.height = 200
        holder.itemView.requestLayout()

    }

    inner class ViewHolder(private val binding: ResultItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item : Row){
            binding.row = item
            binding.executePendingBindings()
        }
    }

}