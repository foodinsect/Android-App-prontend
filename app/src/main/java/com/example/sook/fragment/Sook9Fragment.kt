package com.example.sook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sook.PageChangeCallback
import com.example.sook.databinding.ActivitySook9Binding

class Sook9Fragment : Fragment() {
    private var binding: ActivitySook9Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySook9Binding.inflate(inflater, container, false)
        val view = binding!!.root

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

        // 커뮤니티 화면 전환 버튼
        binding!!.pt.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(5) // sookActivity10으로 이동
        }

        // 키즈존 화면 전환 버튼
        binding!!.kidzone.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(6) // sookActivity11로 이동
        }

        // 탭바 홈 화면 전환 버튼
        binding!!.taphome.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

        binding!!.taphome1.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
        }

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

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
