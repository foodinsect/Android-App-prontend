package com.example.sook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sook.PageChangeCallback
import com.example.sook.R
import com.example.sook.databinding.ActivitySook1Binding

class MainFragment : Fragment() {
    private var binding: ActivitySook1Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySook1Binding.inflate(inflater, container, false)
        val view = binding!!.root

        // 예를 들어, 특정 버튼 클릭 시 페이지 전환
        binding!!.btn.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(1) // 두 번째 페이지로 이동
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
