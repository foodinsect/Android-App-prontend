package com.example.sook

import android.content.Intent
import android.widget.Toast
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sook.databinding.ActivitySook12Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class sookActivity12 : AppCompatActivity() {
    private lateinit var binding: ActivitySook12Binding

    // Retrofit 서비스 인터페이스
    interface RecipeService {
        @POST("get_recipe")
        fun getRecipe(@Body requestData: RequestData): Call<ResponseData>
    }

    // 요청 및 응답 데이터 클래스
    data class RequestData(val age: String, val allergy: String, val ingredients: String, val notes: String)
    data class ResponseData(val recipe: String) // 응답 구조를 API의 실제 응답에 맞게 수정하세요.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySook12Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // OkHttpClient 인스턴스 생성 및 타임아웃 설정
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(40, TimeUnit.SECONDS)   // 읽기 타임아웃 설정
            .connectTimeout(40, TimeUnit.SECONDS) // 연결 타임아웃 설정
            .build()

        // Retrofit 인스턴스 생성
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000/") // API 주소로 변경해야 합니다.
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val service = retrofit.create(RecipeService::class.java)

        // 사용자 인터랙션을 처리하는 버튼 클릭 리스너
        binding.btn.setOnClickListener {
            val ageInput = binding.age.text.toString()
            val allergyInput = binding.allergy.text.toString()
            val ingredientsInput = binding.ingredients.text.toString()
            val notesInput = binding.notes.text.toString()

            // 입력 값을 검증하고, 요청 데이터 객체를 생성합니다.
            val requestData = RequestData(
                age = ageInput, // 문자열을 Int로 변환, 실패시 0을 기본값으로
                allergy = allergyInput,
                ingredients = ingredientsInput,
                notes = notesInput
            )

            // API 호출 및 응답 처리
            service.getRecipe(requestData).enqueue(object : Callback<ResponseData> {
                override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                    if (response.isSuccessful) {
                        // 성공적으로 응답을 받았을 때 UI 업데이트
                        val recipe = response.body()?.recipe ?: "No recipe found"
                        Log.d("RecipeResponse", "Recipe: $recipe") // LogCat에서 확인할 수 있습니다.
                        // TextView에 결과 표시
                        val intent = Intent(this@sookActivity12, sookActivity13::class.java)
                        // 필요한 경우, recipe 데이터를 Intent에 추가
                        intent.putExtra("recipe_key", recipe)

                        // sookActivity13 시작
                        startActivity(intent)

                        // 현재 액티비티 종료 (선택 사항)
                        finish()
                    } else {
                        // 오류 응답 처리
                        Toast.makeText(this@sookActivity12, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                    // 네트워크 요청 실패 처리
                    Toast.makeText(this@sookActivity12, "Failure: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })


        }
    }
}