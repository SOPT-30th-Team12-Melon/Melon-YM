package org.sopt.jointseminar.melon.presentation.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.jointseminar.melon.data.home.ResponseHomeBanner
import org.sopt.jointseminar.melon.databinding.ItemHomeBannerBinding

class HomeViewPagerAdapter : RecyclerView.Adapter<HomeViewPagerAdapter.PagerViewHolder>() {

    val bannerList = mutableListOf<ResponseHomeBanner>()

    class PagerViewHolder(private val binding : ItemHomeBannerBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data : ResponseHomeBanner){
            binding.bannerData = data
            Glide.with(binding.ivBanner.context).load(data.image).into(binding.ivBanner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeBannerBinding.inflate(layoutInflater, parent, false)
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        return holder.onBind(bannerList[position])
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }

}