package com.example.sook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sook.databinding.ActivitySook13Binding

class sookActivity13 : AppCompatActivity() {
    private lateinit var binding: ActivitySook13Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySook13Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent에서 recipe 데이터 받기
        val recipe = intent.getStringExtra("recipe_key")

        // 필요한 로직에 따라 recipe 데이터를 사용
        binding.outputTxt.text = recipe


    }
}
