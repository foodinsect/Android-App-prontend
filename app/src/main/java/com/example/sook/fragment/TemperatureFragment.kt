package com.example.sook.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sook.R

class TemperatureFragment : Fragment() {
    private lateinit var tvTemperature: TextView
    private lateinit var etTemperature: EditText
    private lateinit var etMedicineAmount: EditText
    private lateinit var seekBarAminopen: SeekBar
    private lateinit var seekBarEbupropen: SeekBar
    private lateinit var cbAminopen: CheckBox
    private lateinit var cbEbupropen: CheckBox
    private lateinit var cb3: CheckBox

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 프래그먼트의 레이아웃을 인플레이트합니다.
        val view = inflater.inflate(R.layout.activity_temperature, container, false)

        tvTemperature = view.findViewById(R.id.tvTemperature)
        etTemperature = view.findViewById(R.id.ingredients) // EditText의 ID를 확인해주세요.
        etMedicineAmount = view.findViewById(R.id.medicine) // EditText의 ID를 확인해주세요.
        seekBarAminopen = view.findViewById(R.id.aminopen)
        seekBarEbupropen = view.findViewById(R.id.ebupropen)

        // 체크박스를 뷰에서 찾아옵니다.
        cbAminopen = view.findViewById(R.id.cb1)
        cbEbupropen = view.findViewById(R.id.cb2)
        cb3 = view.findViewById(R.id.cb3)

        // 체크박스 리스너를 설정합니다.
        val checkListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) { checkedToast(buttonView as CheckBox) }
            else { unCheckedToast(buttonView as CheckBox) }
        }

        // 온도 EditText의 리스너 설정
        etTemperature.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.let {
                    if (it.matches(Regex("^\\d+(\\.\\d+)?\$"))) {
                        tvTemperature.text = "${it}°C"
                    }
                }
            }
            // 필요없는 메서드는 구현하지 않아도 됩니다.
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // 투여량 EditText의 리스너 설정
        etMedicineAmount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // 체크된 약 성분에 따라 슬라이드 바를 업데이트합니다.
                val amount = s.toString().toFloatOrNull() ?: 0f

                // 아세트아미노펜 체크박스가 선택되었다면, 관련된 SeekBar와 TextView를 업데이트합니다.
                if (cbAminopen.isChecked) {
                    val progress = calculateProgress(amount, seekBarAminopen.max)
                    seekBarAminopen.progress = progress
                    view.findViewById<TextView>(R.id.amiAmount).text = "$amount / 9.5 cc"
                }

                // 이부프로펜 체크박스가 선택되었다면, 관련된 SeekBar와 TextView를 업데이트합니다.
                if (cbEbupropen.isChecked) {
                    val progress = calculateProgress(amount, seekBarEbupropen.max)
                    seekBarEbupropen.progress = progress
                    view.findViewById<TextView>(R.id.ebuAmount).text = "$amount / 9.5 cc"
                }
                // 기타 약 성분에 대한 처리
            }
            // 필요없는 메서드는 구현하지 않아도 됩니다.
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        seekBarAminopen.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    val amount = progress.toFloat() / seekBar!!.max * 9.5f // 슬라이더의 비율에 따른 계산
                    etMedicineAmount.setText(amount.toString())
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // 필요한 경우 여기에 코드 추가
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // 필요한 경우 여기에 코드 추가
            }
        })


        cbAminopen.setOnCheckedChangeListener(checkListener)
        cbEbupropen.setOnCheckedChangeListener(checkListener)
        cb3.setOnCheckedChangeListener(checkListener)

        return view
    }

    private fun calculateProgress(amount: Float, max: Int): Int {
        // SeekBar의 최대값을 고려하여 progress를 계산합니다.
        // 여기서는 예시로 9.5cc가 최대값이라고 가정합니다.
        val maxAmount = 9.5f
        return if (amount > maxAmount) {
            max
        } else {
            (amount / maxAmount * max).toInt()
        }
    }
    private fun checkedToast(checkBox: CheckBox) {
        Toast.makeText(activity, "${checkBox.text} 선택됨", Toast.LENGTH_SHORT).show()
    }

    private fun unCheckedToast(checkBox: CheckBox) {
        Toast.makeText(activity, "${checkBox.text} 선택 해제됨", Toast.LENGTH_SHORT).show()
    }


}
