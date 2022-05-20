package org.sopt.jointseminar.melon.presentation.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import org.sopt.jointseminar.melon.R
import org.sopt.jointseminar.melon.data.home.ResponseHomeBanner
import org.sopt.jointseminar.melon.data.home.ResponseHomeFavourite
import org.sopt.jointseminar.melon.data.home.ResponseHomeTrendy
import org.sopt.jointseminar.melon.data.home.ResponseNewMusic
import org.sopt.jointseminar.melon.databinding.FragmentHomeBinding
import org.sopt.jointseminar.melon.util.ZoomOutPageTransformer

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")
    private lateinit var homeFavouriteAdapter: HomeFavouriteAdapter
    private lateinit var homeBannerAdapter: HomeViewPagerAdapter
    private lateinit var homeNewAdapter: HomeNewAdapter
    private lateinit var homeTrendyAdapter: HomeTrendyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        initFavouriteAdapter()
        initBannerAdapter()
        initNewAdapter()
        initTrendyAdapter()
        return binding.root
    }

    private fun initFavouriteAdapter() {
        homeFavouriteAdapter = HomeFavouriteAdapter()
        with(binding) {
            rvFavouriteMusic.adapter = homeFavouriteAdapter
            rvFavouriteMusic.addItemDecoration(FavouriteItemDecorationHorizontal())
            homeFavouriteAdapter.submitList(
                listOf(
                    ResponseHomeFavourite("이번 주 인기 플레이리스트", 0, "POP 갬성 폭발 분위기 끝내주는", "#분위기 #팝송"),
                    ResponseHomeFavourite("믿고 듣는 DJ PICK", 0, "풋풋했던 그때 그시절, 첫사랑", "#설렘 #사랑"),
                    ResponseHomeFavourite("이번 주 인기 플레이리스트", 0, "청춘드라마 주인공처럼", "#기분전환 #기분좋아지는"),
                    ResponseHomeFavourite("야미", 0, "짧은 컨텐츠", "#쇼츠"),
                )
            )

        }
    }

    private fun initBannerAdapter() {
        homeBannerAdapter = HomeViewPagerAdapter()
        homeBannerAdapter.bannerList.addAll(
            listOf(
                ResponseHomeBanner("제목에 대해 고민중", R.drawable.group_33683),
                ResponseHomeBanner("얘도 이미지 좀 줘요", R.drawable.img_banner_rect),
                ResponseHomeBanner("이미지 기다립니다", R.drawable.group_33683),
                ResponseHomeBanner("오매불망 기다립니다", R.drawable.img_banner_rect),
            )
        )
        homeBannerAdapter.notifyDataSetChanged()

        binding.vpBanner.adapter = homeBannerAdapter
        val display = activity?.applicationContext?.resources?.displayMetrics
        val deviceWidth = display?.widthPixels
        val ratio: Double = 320 / 360.0
        val itemWidth = ratio * deviceWidth!!
        val itemPadding = ((deviceWidth - itemWidth) / 2).toInt()
        val innerPadding = (itemPadding / 2).toInt()
        Log.d("viewpager", "$itemPadding")
        Log.d("viewpager", "$innerPadding")
        with(binding.vpBanner) {
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            offscreenPageLimit = 1
            setPadding(itemPadding, 0, itemPadding, 0)
            setPageTransformer(CompositePageTransformer().apply {
                addTransformer(ZoomOutPageTransformer())
                addTransformer { page, position -> page.translationX = position * -(innerPadding) }
            })

//            addItemDecoration(object : RecyclerView.ItemDecoration() {
//                override fun getItemOffsets(
//                    outRect: Rect,
//                    view: View,
//                    parent: RecyclerView,
//                    state: RecyclerView.State
//                ) {
//                    super.getItemOffsets(outRect, view, parent, state)
//                    outRect.left = itemPadding
//                    outRect.right = itemPadding
//                }
//            })
//            setPageTransformer { page, position -> translationX = position * (-innerPadding) }
        }
        homeBannerAdapter.notifyDataSetChanged()
    }

    private fun initNewAdapter() {
        homeNewAdapter = HomeNewAdapter()
        homeNewAdapter.submitList(
            listOf(
                ResponseNewMusic(0, "봄여름가을겨울", "빅뱅"),
                ResponseNewMusic(0, "SelfMadeOrange", "창모"),
                ResponseNewMusic(0, "Meteor", "창모"),
                ResponseNewMusic(0, "나의 아이와 바다", "IU"),
                ResponseNewMusic(0, "빈컵", "IU")
            )
        )
        binding.rvNewMusic.adapter = homeNewAdapter
        binding.rvNewMusic.addItemDecoration(FavouriteItemDecorationHorizontal())
    }

    private fun initTrendyAdapter() {
        homeTrendyAdapter = HomeTrendyAdapter()
        homeTrendyAdapter.submitList(
            listOf(
                ResponseHomeTrendy(R.drawable.img_ugrs, "센치한", "#감성힙합 #트렌디"),
                ResponseHomeTrendy(R.drawable.img_ugrs, "신나는", "#케이팝 #아이돌"),
                ResponseHomeTrendy(R.drawable.img_ugrs, "빡센", "#드릴 #외국힙합"),
                ResponseHomeTrendy(R.drawable.img_ugrs, "부드러운", "#발라드 #이별노래"),
                ResponseHomeTrendy(R.drawable.img_ugrs, "센치한", "#감성힙합 #트렌디"),
                ResponseHomeTrendy(R.drawable.img_ugrs, "신나는", "#케이팝 #아이돌"),
                ResponseHomeTrendy(R.drawable.img_ugrs, "빡센", "#드릴 #외국힙합"),
                ResponseHomeTrendy(R.drawable.img_ugrs, "부드러운", "#발라드 #이별노래")
            )
        )
        binding.rvMelonTrendy.addItemDecoration(TrendyItemDecoration())
        binding.rvMelonTrendy.adapter = homeTrendyAdapter
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}