package com.aaron.hellomvvm.activity

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aaron.hellomvvm.R
import com.aaron.hellomvvm.adapter.MainAdapter
import com.aaron.hellomvvm.databinding.ActivityMainBinding
import com.aaron.hellomvvm.utils.PersonRandomUtils
import com.aaron.hellomvvm.utils.dp
import com.aaron.hellomvvm.utils.showToast
import com.aaron.hellomvvm.viewmodel.MainViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            clickListener = this@MainActivity
            vm = viewModels<MainViewModel> {
                MainViewModel.Factory()
            }.value
        }

        val listView = binding.listView
        listView.addItemDecoration(ItemDecoration())
        listView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listView.adapter = MainAdapter().apply {
            adapter = this
            setOnItemClickListener { person, pos ->
                person ?: return@setOnItemClickListener
                binding.vm?.delete(person)
                """
                    Delete person.
                    name: ${person.name}
                    age: ${person.age}
                    gender: ${person.gender}
                """.trimIndent().showToast()
            }
        }
    }

    override fun onClick(v: View?) {
        when (v ?: return) {
            binding.btnInsert -> {
                binding.vm?.add(PersonRandomUtils.randomPerson())
            }
            binding.btnDelete -> {
                binding.vm?.deleteAll()
            }
        }
    }

    private class ItemDecoration : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            val spacing = 16f.dp
            outRect.set(spacing, 0, spacing, spacing)
            val pos = parent.getChildAdapterPosition(view)
            if (pos == 0) {
                outRect.top = spacing
            }
        }
    }
}