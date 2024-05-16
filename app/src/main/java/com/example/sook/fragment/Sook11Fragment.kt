package com.example.sook.fragment

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.sook.PageChangeCallback
import com.example.sook.R
import com.example.sook.databinding.ActivitySook11Binding

class Sook11Fragment : Fragment() {
    private var binding: ActivitySook11Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySook11Binding.inflate(inflater, container, false)
        val view = binding!!.root

        val linearLayout: LinearLayout = view.findViewById(R.id.themapark1)
        linearLayout.setOnClickListener {
            openUrl("https://map.naver.com/p/entry/place/13293402?lng=126.99801530265998&lat=37.5391392806593&placePath=%2Fhome&entry=plt&searchType=place&c=15.00,0,0,0,dh")
        }

        // 홈 화면 전환 버튼
        binding!!.home.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

        // 상품특가 화면 전환 버튼
        binding!!.event.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(1) // sookActivity6로 이동
        }

        // 식단 화면 전환 버튼
        binding!!.food.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(2) // sookActivity7로 이동
        }

        // 육아일기 화면 전환 버튼
        binding!!.diary.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(4) // sookActivity9로 이동
        }

        // 커뮤니티 화면 전환 버튼
        binding!!.pt.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(5) // sookActivity10으로 이동
        }


        // 탭바 홈 화면 전환 버튼
        binding!!.taphome.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

        binding!!.taphome1.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

        // 탭바 상품특가 화면 전환 버튼
        binding!!.tapevent.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(1) // sookActivity5로 이동
        }

        binding!!.tapevent1.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(1) // sookActivity5로 이동
        }

        // 탭바 식단 화면 전환 버튼
        binding!!.tapfood.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(2) // sookActivity7로 이동
        }

        binding!!.tapfood1.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(2) // sookActivity7로 이동
        }

        // 탭바 커뮤니티 화면 전환 버튼
        binding!!.tappt.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(5) // sookActivity10으로 이동
        }

        binding!!.tappt1.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(5) // sookActivity10으로 이동
        }


        return view
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
