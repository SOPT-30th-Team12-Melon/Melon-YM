package org.sopt.jointseminar.melon.presentation.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import org.sopt.jointseminar.melon.R
import org.sopt.jointseminar.melon.data.home.ResponseHomeFavourite
import org.sopt.jointseminar.melon.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding?:error("Binding이 초기화 되지 않았습니다.")
    private lateinit var homeFavouriteAdapter : HomeFavouriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        initAdapter()
        return binding.root
    }

    private fun initAdapter(){
        homeFavouriteAdapter = HomeFavouriteAdapter()
        with(binding){
            rvFavouriteMusic.adapter=homeFavouriteAdapter
            rvFavouriteMusic.addItemDecoration(ItemDecorationHomeHorizontal())
            homeFavouriteAdapter.submitList(
                listOf(
                    ResponseHomeFavourite(
                        title = "이번 주 인기 플레이리스트",
                        image = 0,
                        content = "POP 갬성 폭발 분위기 끝내주는",
                        hashTag = "#분위기 #팝송"
                    ),
                    ResponseHomeFavourite(
                        title = "믿고 듣는 DJ PICK",
                        image = 0,
                        content = "풋풋했던 그때 그시절, 첫사랑",
                        hashTag = "#설렘 #사랑"
                    ),
                    ResponseHomeFavourite(
                        title = "이번 주 인기 플레이리스트",
                        image = 0,
                        content = "청춘드라마 주인공처럼",
                        hashTag = "#기분전환 #기분좋아지는"
                    ),
                    ResponseHomeFavourite(
                        title = "야미",
                        image = 0,
                        content = "짧은 컨텐츠",
                        hashTag = "#쇼츠"
                    ),
                )
            )

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}