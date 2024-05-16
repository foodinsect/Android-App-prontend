package com.example.sook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sook.PageChangeCallback
import com.example.sook.R
import com.example.sook.databinding.ActivitySook2Binding

class Sook2Fragment : Fragment() {
    private var binding: ActivitySook2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySook2Binding.inflate(inflater, container, false)
        val view = binding!!.root

        binding!!.btn1.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(2) // 세 번째 페이지로 이동
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
