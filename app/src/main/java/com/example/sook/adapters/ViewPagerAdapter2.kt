package com.example.sook.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sook.fragment.CalendarFragment
import com.example.sook.fragment.Sook5Fragment
import com.example.sook.fragment.Sook6Fragment
import com.example.sook.fragment.Sook7Fragment
import com.example.sook.fragment.Sook8Fragment
import com.example.sook.fragment.Sook9Fragment
import com.example.sook.fragment.Sook10Fragment
import com.example.sook.fragment.Sook11Fragment
import com.example.sook.fragment.TemperatureFragment

// 예시로 ViewPager2에 사용되는 어댑터입니다.
class ViewPagerAdapter2(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val NUM_PAGES = 9 // 페이지 수

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Sook5Fragment() // 첫 번째 페이지에 해당하는 Fragment - 홈
            1 -> Sook6Fragment() // 두 번째 페이지에 해당하는 Fragment - 상품특가
            2 -> Sook7Fragment() // 세 번째 페이지에 해당하는 Fragment - 식단
            3 -> Sook8Fragment() // 세 번째 페이지에 해당하는 Fragment - 식단-나만의메뉴
            4 -> Sook9Fragment() // 세 번째 페이지에 해당하는 Fragment - 육아일기
            5 -> Sook10Fragment() // 세 번째 페이지에 해당하는 Fragment- 커뮤니티
            6 -> Sook11Fragment() // 세 번째 페이지에 해당하는 Fragment - 키즈존
            7 -> CalendarFragment() // 달력 프래그먼트
            8 -> TemperatureFragment()
            else -> Fragment() // 그 외의 경우
        }
    }
}
