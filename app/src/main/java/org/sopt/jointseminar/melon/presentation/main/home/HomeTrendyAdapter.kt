package org.sopt.jointseminar.melon.presentation.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.jointseminar.melon.data.home.ResponseHomeTrendy
import org.sopt.jointseminar.melon.databinding.ItemMelonTrendyBinding

class HomeTrendyAdapter : ListAdapter<ResponseHomeTrendy, HomeTrendyAdapter.HomeTrendyViewHolder>(HomeTrendyComparator()) {
    class HomeTrendyViewHolder(private val binding : ItemMelonTrendyBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data : ResponseHomeTrendy){
            binding.trendyData=data
            Glide.with(binding.ivAlbumCover.context).load(data.albumCover).into(binding.ivAlbumCover)
        }
    }

    private class HomeTrendyComparator() : DiffUtil.ItemCallback<ResponseHomeTrendy>(){
        override fun areItemsTheSame(
            oldItem: ResponseHomeTrendy,
            newItem: ResponseHomeTrendy
        ): Boolean {
            return oldItem.albumCover==newItem.albumCover
        }

        override fun areContentsTheSame(
            oldItem: ResponseHomeTrendy,
            newItem: ResponseHomeTrendy
        ): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTrendyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMelonTrendyBinding.inflate(layoutInflater, parent, false)
        return HomeTrendyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeTrendyViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }
}