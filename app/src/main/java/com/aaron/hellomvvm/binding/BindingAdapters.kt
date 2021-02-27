package com.aaron.hellomvvm.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aaron.hellomvvm.adapter.BaseRecyclerAdapter
import com.bumptech.glide.Glide

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/27
 */
@BindingAdapter("data")
fun <T> RecyclerView.setData(data: MutableList<T>?) {
    val adapter = this.adapter ?: return
    if (adapter !is BaseRecyclerAdapter<*>) {
        throw IllegalStateException("The adapter must extend BaseRecyclerAdapter.")
    }
    data?.reverse()
    (adapter as BaseRecyclerAdapter<T>).setData(data)
    adapter.notifyDataSetChanged()
}

@BindingAdapter("load_image")
fun <T> ImageView.loadImage(model: T?) {
    Glide.with(this)
        .load(model)
        .into(this)
}