package com.aaron.hellomvvm.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.aaron.hellomvvm.R
import com.aaron.hellomvvm.bean.Person
import com.aaron.hellomvvm.databinding.RecyclerItemMainBinding
import com.aaron.hellomvvm.utils.PersonRandomUtils

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
class MainAdapter : BaseRecyclerAdapter<Person>() {

    private var onItemClickListener: ((Person?, Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbsHolder<Person> {
        val inflater = LayoutInflater.from(parent.context)
        return PersonHolder.create(inflater, parent).apply {
            itemView.setOnClickListener {
                val pos = adapterPosition
                val bean = data?.getOrNull(pos)
                onItemClickListener?.invoke(bean, pos)
            }
        }
    }

    override fun onBindViewHolder(holder: AbsHolder<Person>, position: Int) {
        holder.onBind(data, position)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    fun setOnItemClickListener(listener: ((Person?, Int) -> Unit)?) {
        this.onItemClickListener = listener
    }

    class PersonHolder(itemView: View) : AbsHolder<Person>(itemView) {

        companion object {
            private const val LAYOUT_RES = R.layout.recycler_item_main

            fun create(inflater: LayoutInflater, parent: ViewGroup): PersonHolder {
                val itemView = inflater.inflate(LAYOUT_RES, parent, false)
                return PersonHolder(itemView)
            }
        }

        val binding: RecyclerItemMainBinding? = DataBindingUtil.bind(itemView)

        override fun onBind(data: MutableList<Person>?, position: Int) {
            val person = data?.getOrNull(position)
            binding?.randomUtils = PersonRandomUtils
            binding?.person = person
        }

        override fun onUnbind() {
            Log.d("zzx", "onUnbind")
        }
    }
}