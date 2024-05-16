package com.example.sook.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sook.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 레이아웃 인플레이트
        val view = inflater.inflate(R.layout.activity_calendar, container, false)

        val calendarView: CalendarView = view.findViewById(R.id.calendarView)

        // 날짜 형태
        val dateFormat: DateFormat = SimpleDateFormat("yyyy년MM월dd일", Locale.KOREA)

        // date 타입
        val date: Date = Date(calendarView.date)

        // CalendarView 날짜 변환 이벤트
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // 날짜 변수에 담기
            val day = "${year}년 ${month + 1}월 ${dayOfMonth}일" // month는 0부터 시작하므로 +1

        }

        return view
    }
}
