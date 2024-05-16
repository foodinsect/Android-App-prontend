package com.example.sook.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sook.fragment.MainFragment
import com.example.sook.fragment.Sook2Fragment
import com.example.sook.fragment.Sook3Fragment

// 예시로 ViewPager2에 사용되는 어댑터입니다.
class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val NUM_PAGES = 3 // 페이지 수

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment() // 첫 번째 페이지에 해당하는 Fragment
            1 -> Sook2Fragment() // 두 번째 페이지에 해당하는 Fragment
            2 -> Sook3Fragment() // 세 번째 페이지에 해당하는 Fragment
            else -> Fragment() // 그 외의 경우
        }
    }
}
