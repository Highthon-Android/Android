package org.gsm.software.highthon.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.gsm.software.highthon.model.schoolinfo.Row

object BindingAdapter {

    @BindingAdapter("listData")
    @JvmStatic
    fun bindList(recyclerView: RecyclerView, items: List<Row>?) {
        val adapter = recyclerView.adapter as SearchAdapter
        adapter.submitList(items?.toMutableList())
        Log.d(TAG, "bindList: ${items?.size}")

    }

    @BindingAdapter("searchVisibility")
    @JvmStatic
    fun searchVisibility(view: RecyclerView, type: Boolean) {
        if (type) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @BindingAdapter("searchTextVisibility")
    @JvmStatic
    fun searchTextVisibility(view : TextView, type: Boolean){
        if (type) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

}