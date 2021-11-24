package com.pseudoencom.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


class Case3Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var numberPicker: NumberPicker
    private lateinit var textView: TextView
    private lateinit var textView2: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_case3, container, false)


        editText = view.findViewById(R.id.editTextCase3)
        numberPicker = view.findViewById(R.id.number_pickerCase3)
        textView = view.findViewById(R.id.textViewCase3)

        textView2 = view.findViewById(R.id.textViewCase3_2)
        button = view.findViewById(R.id.buttonCase3)
        view.findViewById<Button>(R.id.buttonCase3).setOnClickListener(this)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberPicker.minValue = 1
        numberPicker.maxValue = 12
        numberPicker.wrapSelectorWheel = true
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            var text = " "
            when (newVal) {
                1 -> {
                    text = "Зима - Январь"
                    textView2.text = "Автоматический выбор: $text"
                }
                2 -> {
                    text = "Зима - Февраль"
                    textView2.text = "Автоматический выбор: $text"
                }
                3 -> {
                    text = "Весна - Март"
                    textView2.text = "Автоматический выбор: $text"
                }
                4 -> {
                    text = "Весна - Апрель"
                    textView2.text = "Автоматический выбор: $text"
                }
                5 -> {
                    text = "Весна - Май"
                    textView2.text = "Автоматический выбор: $text"
                }
                6 -> {
                    text = "Лето - Июнь"
                    textView2.text = "Автоматический выбор: $text"
                }
                7 -> {
                    text = "Лето - Июль"
                    textView2.text = "Автоматический выбор: $text"
                }
                8 -> {
                    text = "Лето - Август"
                    textView2.text = "Автоматический выбор: $text"
                }
                9 -> {
                    text = "Осень - Сентябрь"
                    textView2.text = "Автоматический выбор: $text"
                }
                10 -> {
                    text = "Осень - Октябрь"
                    textView2.text = "Автоматический выбор: $text"
                }
                11 -> {
                    text = "Осень - Ноябрь"
                    textView2.text = "Автоматический выбор: $text"
                }
                12 -> {
                    text = "Зима - Декабрь"
                    textView2.text = "Автоматический выбор: $text"
                }
            }
            val snackBar = Snackbar.make(requireView(), "$text", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }

    }

    override fun onClick(v: View?) {
        if (editText.text.isNotEmpty()) {
            when (editText.text.toString().toInt()) {
                12,1,2 -> {
                    textView.text = "Зима"
                }
                3,4,5 -> {
                    textView.text = "Весна"
                }
                6,7,8 -> {
                    textView.text = "Лето"
                }
                9,10,11 -> {
                    textView.text = "Осень"
                }
                else -> {
                    textView.text = "Такого месяца нет"
                }
            }
        } else if (editText.text.isEmpty()) {
            val error = "Введите число месяца"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }else {
            val error = "Ошибка!!!"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }
}


