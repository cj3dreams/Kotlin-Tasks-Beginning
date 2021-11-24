package com.pseudoencom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.*
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Case1Fragment : Fragment(), View.OnClickListener {
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
        val view: View = inflater.inflate(R.layout.fragment_case1, container, false)


        editText = view.findViewById(R.id.editTextCase1)
        numberPicker = view.findViewById(R.id.number_pickerCase1)
        textView = view.findViewById(R.id.textViewCase1)
        textView2 = view.findViewById(R.id.textViewCase1_2)
        button = view.findViewById(R.id.buttonCase1)
        view.findViewById<Button>(R.id.buttonCase1).setOnClickListener(this)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberPicker.minValue = 1
        numberPicker.maxValue = 7
        numberPicker.wrapSelectorWheel = true
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            var text = " "
            when (newVal) {
                1 -> {
                    text = "Понедельник"
                    textView2.text = "Автоматический выбор: " + text
                }
                2 -> {
                    text = "Вторник"
                    textView2.text = "Автоматический выбор: " + text
                }
                3 -> {
                    text = "Среда"
                    textView2.text = "Автоматический выбор: " + text
                }
                4 -> {
                    text = "Четверг"
                    textView2.text = "Автоматический выбор: " + text
                }
                5 -> {
                    text = "Пятница"
                    textView2.text = "Автоматический выбор: " + text
                }
                6 -> {
                    text = "Суббота"
                    textView2.text = "Автоматический выбор: " + text
                }
                7 -> {
                    text = "Воскресенье"
                    textView2.text = "Автоматический выбор: " + text
                }
            }
            val snackBar = Snackbar.make(requireView(), "$text", Snackbar.LENGTH_SHORT)
            snackBar.show()

        }

    }

    override fun onClick(v: View?) {
        if (editText.text.isNotEmpty()) {
            when (editText.text.toString().toInt()) {
                1 -> {
                    textView.text = "Ваш ручной выбор: Понедельник"
                }
                2 -> {
                    textView.text = "Ваш ручной выбор: Вторник"
                }
                3 -> {
                    textView.text = "Ваш ручной выбор: Среда"
                }
                4 -> {
                    textView.text = "Ваш ручной выбор: Четверг"
                }
                5 -> {
                    textView.text = "Ваш ручной выбор: Пятница"
                }
                6 -> {
                    textView.text = "Ваш ручной выбор: Суббота"
                }
                7 -> {
                    textView.text = "Ваш ручной выбор: Воскресенье"
                }
                else -> {
                    textView.text = "Такой день недели нет"
                }
            }
        } else if (editText.text.isEmpty()) {
            val error = "Введите число день недели!"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }else {
            val error = "Ошибка!!!"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }
}


