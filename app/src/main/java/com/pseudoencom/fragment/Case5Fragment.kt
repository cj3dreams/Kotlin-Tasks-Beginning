package com.pseudoencom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class Case5Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var numberPicker: NumberPicker
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var textNewVal: String
    private lateinit var gChecker: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_case5, container, false)

        editText = view.findViewById(R.id.editTextCase5)
        editText2 = view.findViewById(R.id.editTextCase5_1)
        numberPicker = view.findViewById(R.id.number_pickerCase5)
        textView = view.findViewById(R.id.textViewCase5)
        textView2 = view.findViewById(R.id.textViewCase5_2)
        gChecker = view.findViewById(R.id.textViewCase5_3)
        button = view.findViewById(R.id.buttonCase5)
        view.findViewById<Button>(R.id.buttonCase5).setOnClickListener(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberPicker.minValue = 1
        numberPicker.maxValue = 4
        numberPicker.wrapSelectorWheel = true
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            var text = " "
            when (newVal) {
                1 -> {
                    text = "Сложение (+)"
                    textView2.text = "Ваш выбор: " + text
                }
                2 -> {
                    text = "Вычитание (-)"
                    textView2.text = "Ваш выбор: " + text
                }
                3 -> {
                    text = "Умножение (*)"
                    textView2.text = "Ваш выбор: " + text
                }
                4 -> {
                    text = "Деление (/)"
                    textView2.text = "Ваш выбор: " + text
                }
                else -> {
                    text = "Empty"
                    textView2.text = "Empty"
                }
            }
            gChecker = textView2
            textNewVal = newVal.toString()

            val snackBar = Snackbar.make(requireView(), "Вы выбрали: $text", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }

    }

    override fun onClick(v: View?) {
        var gChecker2:String? = gChecker.text.toString()
        var checker :Int? = 0
        var textNewValL: Int? = 1
        when (gChecker2){
            "Ваш выбор: Сложение (+)", "Ваш выбор: Вычитание (-)", "Ваш выбор: Умножение (*)", "Ваш выбор: Деление (/)" -> textNewValL = textNewVal.toInt()
        }
        when (gChecker2) {
            "Ваш выбор: Сложение (+)", "Ваш выбор: Вычитание (-)", "Ваш выбор: Умножение (*)", "Ваш выбор: Деление (/)" -> checker = 1
        }
        var calc: Long
        if (checker == 0){
            val snackBar = Snackbar.make(requireView(), "Выберите арифметические действие", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }else if (editText.text.isEmpty() && editText2.text.isEmpty()) {
            val error = "Введите числа A и B"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }else if (editText.text.isEmpty() || editText2.text.isEmpty()) {
            val error = "Заполните оба поля А и B"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }else if (editText.text.isNotEmpty() && editText2.text.toString().toInt() == 0) {
            val error = "Число B не может быть 0"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        } else if (checker == 1 && editText.text.isNotEmpty() && editText2.text.isNotEmpty()) {
            val a = editText.text.toString().toLong()
            val b = editText2.text.toString().toLong()
            when (textNewValL) {
                1 -> {
                    calc = a + b
                    textView.text = "Ответ $a + $b = $calc "
                }
                2 -> {
                    calc = a - b
                    textView.text = "Ответ $a - $b = $calc "
                }
                3 -> {
                    calc = a * b
                    textView.text = "Ответ $a * $b = $calc "
                }
                4 -> {
                    var calc2:Double = a.toDouble() / b.toDouble()
                    textView.text = "Ответ $a / $b = $calc2"
                }
            }
        }else{
            val error = "Ошибка!!!"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }
}


