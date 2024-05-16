package com.example.sook.fragment
import com.example.sook.sookActivity4
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sook.databinding.ActivitySook3Binding

class Sook3Fragment : Fragment() {
    private var binding: ActivitySook3Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySook3Binding.inflate(inflater, container, false)
        val view = binding!!.root

        // 예를 들어, 특정 버튼 클릭 시 페이지 전환
        binding!!.btn2.setOnClickListener {
            startActivity(Intent(activity, sookActivity4::class.java))
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
