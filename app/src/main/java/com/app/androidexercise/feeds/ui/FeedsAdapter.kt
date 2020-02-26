package com.app.androidexercise.feeds.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.androidexercise.databinding.FeedItemsBinding
import com.app.androidexercise.feeds.data.Rows

class FeedsAdapter : ListAdapter<Rows, FeedsAdapter.ViewHolder>(FeedsDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feeds = getItem(position)
        feeds?.let {
            holder.apply {
                bind(feeds)
                itemView.tag = feeds
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FeedItemsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    class ViewHolder(
        private val binding: FeedItemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Rows) {
            binding.apply {
                feedData = item
                executePendingBindings()
            }
        }
    }
}

private class FeedsDiffCallback : DiffUtil.ItemCallback<Rows>() {

    override fun areItemsTheSame(oldItem: Rows, newItem: Rows): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Rows, newItem: Rows): Boolean {
        return oldItem == newItem
    }
}