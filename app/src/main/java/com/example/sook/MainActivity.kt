package com.example.sook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.sook.adapters.ViewPagerAdapter
import com.example.sook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PageChangeCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager // viewBinding을 사용하여 찾기
        adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter
    }

    override fun changePage(pageIndex: Int) {
        viewPager.setCurrentItem(pageIndex)
    }
}
