package com.example.sook.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sook.PageChangeCallback
import com.example.sook.R
import com.example.sook.adapters.ItemBabyCamAdapter
import com.example.sook.databinding.ActivitySook6Binding
import com.example.sook.datas.ItemBabyCam

class Sook6Fragment : Fragment() {
    private var binding: ActivitySook6Binding? = null
    val mItemList = ArrayList<ItemBabyCam>()
    lateinit var mAdapter: ItemBabyCamAdapter
    lateinit var itemview: ListView // ListView를 위한 변수 선언

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySook6Binding.inflate(inflater, container, false)
        val view = binding!!.root


        mItemList.add(ItemBabyCam("샤오미 스마트 홈캠 3", "29,900", "13,539", "#대륙의 실수", R.drawable.cam1,"https://smartstore.naver.com/xj/products/3504999013?NaPm=ct%3Dlqrje18o%7Cci%3Dc36f92febaeb2292e328cef1e33918983871b12e%7Ctr%3Dslsl%7Csn%3D769009%7Chk%3D70e8d732b12e4831a79b8156c72480f29868ccf8"))
        mItemList.add(ItemBabyCam("헤이홈 PRO 홈카메라", "59,900", "11,915", "#선명한 화질", R.drawable.cam2,"https://smartstore.naver.com/smarthouseshop/products/4799243915?NaPm=ct%3Dlqrjg088%7Cci%3D1aa50c4fff100532e4416f029e310f87839264ef%7Ctr%3Dslsl%7Csn%3D1010426%7Chk%3Dae9d80b782c87312d287e2ab9021bdef34b27760"))
        mItemList.add(ItemBabyCam("이글루캠 S4+ 베이비캠", "89,800", "7,511", "#좋은 호환성", R.drawable.cam3,"https://smartstore.naver.com/egloosmart/products/5550180313?NaPm=ct%3Dlqrjgdcg%7Cci%3D101e8cd6254c52efb420b1cee7064d58045111c2%7Ctr%3Dslsl%7Csn%3D767264%7Chk%3D78960fc6d41bc8e7828a5c57130106fce57cc6e6"))
        mItemList.add(ItemBabyCam("파인뷰 k70 무선 홈 CCTV", "68,950", "711", "#QHD 고화질", R.drawable.cam4,"https://search.shopping.naver.com/catalog/43430004355?query=%ED%8C%8C%EC%9D%B8%EB%B7%B0%20%ED%99%88%EC%BA%A0&NaPm=ct%3Dlqrjhc2g%7Cci%3D69858a15588dc18974a5f8adfb9b6d53f3695881%7Ctr%3Dslsl%7Csn%3D95694%7Chk%3Df1efc222818220c945172e37bd0fc20044cf61dc"))
        mItemList.add(ItemBabyCam("텐플 스마트 홈카메라", "59,800", "841", "#300만 화소", R.drawable.cam5,"https://search.shopping.naver.com/catalog/43070894669?query=%ED%85%90%ED%94%8C%20%ED%99%88%EC%BA%A0&NaPm=ct%3Dlqrji2aw%7Cci%3D5334b4e86e508553e2fb837d7b7412c9d81d8429%7Ctr%3Dslsl%7Csn%3D95694%7Chk%3Df58b65610062512c683a8154a058db843fc302ab"))

        // Adapter 초기화 및 RecyclerView 설정
        mAdapter = ItemBabyCamAdapter(mItemList)
        binding?.itemview?.layoutManager = LinearLayoutManager(activity)
        binding?.itemview?.adapter = mAdapter


        // 홈 화면 전환 버튼
        binding!!.home.setOnClickListener {
            (activity as? PageChangeCallback)?.changePage(0) // sookActivity5로 이동
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
