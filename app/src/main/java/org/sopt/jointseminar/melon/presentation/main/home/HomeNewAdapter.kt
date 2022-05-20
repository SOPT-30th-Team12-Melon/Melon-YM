package org.sopt.jointseminar.melon.presentation.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.jointseminar.melon.data.home.ResponseNewMusic
import org.sopt.jointseminar.melon.databinding.ItemHomeNewBinding

class HomeNewAdapter :
    ListAdapter<ResponseNewMusic, HomeNewAdapter.HomeNewViewHolder>(NewComparator()) {
    class HomeNewViewHolder(private val binding: ItemHomeNewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseNewMusic) {
            binding.newData = data
        }
    }

    private class NewComparator : DiffUtil.ItemCallback<ResponseNewMusic>() {
        override fun areItemsTheSame(
            oldItem: ResponseNewMusic,
            newItem: ResponseNewMusic
        ): Boolean {
            return oldItem.song == newItem.song
        }

        override fun areContentsTheSame(
            oldItem: ResponseNewMusic,
            newItem: ResponseNewMusic
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeNewBinding.inflate(layoutInflater, parent, false)
        return HomeNewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeNewViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }
}