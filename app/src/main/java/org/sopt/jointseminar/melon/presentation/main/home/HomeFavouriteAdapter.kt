package org.sopt.jointseminar.melon.presentation.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.jointseminar.melon.data.home.ResponseHomeFavourite
import org.sopt.jointseminar.melon.databinding.ItemHomeFavouriteBinding

class HomeFavouriteAdapter(private val onFavouriteClick: ((ResponseHomeFavourite)->Unit)?=null) : ListAdapter<ResponseHomeFavourite, HomeFavouriteAdapter.HomeFavouriteViewHolder>(
    FavouriteComparator()
){

    class HomeFavouriteViewHolder(private val binding : ItemHomeFavouriteBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: ResponseHomeFavourite, onFavouriteCick:((ResponseHomeFavourite)->Unit)? = null){
            binding.favouriteData=data
            binding.root.setOnClickListener{
                onFavouriteCick?.invoke(data)
            }
        }
    }

    private class FavouriteComparator: DiffUtil.ItemCallback<ResponseHomeFavourite>(){
        override fun areItemsTheSame(
            oldItem: ResponseHomeFavourite,
            newItem: ResponseHomeFavourite
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: ResponseHomeFavourite,
            newItem: ResponseHomeFavourite
        ): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFavouriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeFavouriteBinding.inflate(layoutInflater, parent, false)
        return HomeFavouriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeFavouriteViewHolder, position: Int) {
        return holder.onBind(getItem(position), onFavouriteClick)
    }
}