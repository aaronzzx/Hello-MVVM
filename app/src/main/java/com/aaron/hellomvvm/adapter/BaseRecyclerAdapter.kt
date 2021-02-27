package com.aaron.hellomvvm.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
abstract class BaseRecyclerAdapter<T>() : RecyclerView.Adapter<BaseRecyclerAdapter.AbsHolder<T>>() {

    protected var data: MutableList<T>? = mutableListOf()
        private set

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        for (i in 0 until itemCount) {
            val holder = recyclerView.findViewHolderForAdapterPosition(i) as? AbsHolder<*>
            holder?.onUnbind()
        }
    }

    fun setData(data: MutableList<T>?) {
        this.data = data
    }

    abstract class AbsHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun onBind(data: MutableList<T>?, position: Int)

        abstract fun onUnbind()
    }
}