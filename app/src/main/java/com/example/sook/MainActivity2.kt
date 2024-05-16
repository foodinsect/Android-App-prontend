package com.example.sook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.sook.adapters.ViewPagerAdapter2
import com.example.sook.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), PageChangeCallback {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ViewPagerAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager2 // viewBinding을 사용하여 찾기
        adapter = ViewPagerAdapter2(this)
        viewPager.adapter = adapter
    }

    override fun changePage(pageIndex: Int) {
        viewPager.setCurrentItem(pageIndex)
    }
}
