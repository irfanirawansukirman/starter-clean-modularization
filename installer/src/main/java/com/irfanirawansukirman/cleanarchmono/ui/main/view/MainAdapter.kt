package com.irfanirawansukirman.cleanarchmono.ui.main.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.irfanirawansukirman.cleanarchmono.databinding.MainItemBinding
import com.irfanirawansukirman.data.network.model.MoviesResult
import com.irfanirawansukirman.lib_recyclerviewgenericadapter.BaseViewHolder
import com.irfanirawansukirman.lib_recyclerviewgenericadapter.GenericRecyclerViewAdapter
import com.irfanirawansukirman.lib_recyclerviewgenericadapter.OnRecyclerItemClickListener

class MainAdapter(context: Context, private val onMovieSelected: (MoviesResult?) -> Unit) :
    GenericRecyclerViewAdapter<MoviesResult, OnRecyclerItemClickListener, MainAdapter.ItemHolder>(
        context
    ) {

    inner class ItemHolder(
        private val mainItemBinding: MainItemBinding
    ) :
        BaseViewHolder<MoviesResult>(mainItemBinding) {

        override fun onBind(item: MoviesResult?) {
            mainItemBinding.apply {
                movieTitle = item?.title
                posterUrl = item?.posterPath
                root.setOnClickListener {
                    onMovieSelected(item)
                }
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            MainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}