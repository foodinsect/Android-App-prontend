package com.example.sook.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sook.R
import com.example.sook.datas.ItemBabyCam

class ItemBabyCamAdapter(private val itemList: List<ItemBabyCam>) :
    RecyclerView.Adapter<ItemBabyCamAdapter.ItemBabyCamViewHolder>() {

    class ItemBabyCamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberTextView: TextView = view.findViewById(R.id.number)
        val imageItemView: ImageView = view.findViewById(R.id.image_item)
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val priceTextView: TextView = view.findViewById(R.id.priceTxt)
        val commentTextView: TextView = view.findViewById(R.id.commentTxt)
        val reviewTextView: TextView = view.findViewById(R.id.my_reviewTxt)
        // 추가로 필요한 이미지 뷰나 기타 뷰는 여기에 선언
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBabyCamAdapter.ItemBabyCamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ItemBabyCamAdapter.ItemBabyCamViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemBabyCamAdapter.ItemBabyCamViewHolder, position: Int) {
        val item = itemList[position]
        holder.numberTextView.text = "0${(position + 1)}" // 항목 번호 설정
        holder.imageItemView.setImageResource(item.imageResId) // 이미지 설정
        holder.nameTextView.text = item.name
        holder.priceTextView.text = "${item.price}원" // price가 Int라서 문자열로 변환
        holder.commentTextView.text = item.comment
        holder.reviewTextView.text = "사용자 리뷰(${item.review})"
        // 이미지 뷰나 다른 뷰에 대한 설정이 필요하다면 여기서 추가
        holder.itemView.setOnClickListener {
            val url = item.url
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = itemList.size
}
