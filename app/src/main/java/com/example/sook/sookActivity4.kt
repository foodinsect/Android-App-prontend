package com.example.sook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sook.databinding.ActivitySook4Binding
import com.example.sook.fragment.Sook5Fragment

class sookActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivitySook4Binding  // binding 변수 선언
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySook4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {

            // 아이디 입력 값, 비번 입력값을 각각의 변수에 저장
            val inputId = binding.idEdt.text.toString()
            val inputPw = binding.passwordEdt.text.toString()

            // 두개의 변수에 들어있는 값 검사. (맞는 아이디/비번)
            // 맞을 때 => 틀릴 때 분기 처리. (if 활용)
            if (inputId == "admin@test.com" && inputPw == "qwer"){
                //둘 다 맞다면 => 장민진 관리자 입니다. 토스트
                val name = "장민진"
                Toast.makeText(this, "${name} 관리자입니다.", Toast.LENGTH_SHORT).show()
                // MainActivity2로 이동
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            else{
                //아이디, 비번 둘 중 하나라도 틀리면 로그인 실패 토스트
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }

        }

    }
}