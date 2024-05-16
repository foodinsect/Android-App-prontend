package com.example.sook.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sook.PageChangeCallback
import com.example.sook.databinding.ActivitySook7Binding

class Sook7Fragment : Fragment() {
    private var binding: ActivitySook7Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySook7Binding.inflate(inflater, container, false)
        val view = binding!!.root

        // 홈 화면 전환 버튼
        binding!!.home.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

        // 상품특가 화면 전환 버튼
        binding!!.event.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(1) // sookActivity6로 이동
        }

        // 육아일기 화면 전환 버튼
        binding!!.diary.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(4) // sookActivity9로 이동
        }

        // 커뮤니티 화면 전환 버튼
        binding!!.pt.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(5) // sookActivity10으로 이동
        }

        // 키즈존 화면 전환 버튼
        binding!!.kidzone.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(6) // sookActivity11로 이동
        }
        // 나만의 메뉴 화면 전환 버튼
        binding!!.mymenu.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(3) // sookActivity8로 이동
        }

        // 탭바 홈 화면 전환 버튼
        binding!!.taphome.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

        binding!!.taphome1.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

        // 탭바 홈 화면 전환 버튼
        binding!!.taphome.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

        binding!!.taphome1.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

        // 탭바 상품 화면 전환 버튼
        binding!!.tapevent.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(1) // sookActivity7로 이동
        }

        binding!!.tapevent1.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(1) // sookActivity7로 이동
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

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
