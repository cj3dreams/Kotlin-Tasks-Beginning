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

class Case7Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
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
        val view: View = inflater.inflate(R.layout.fragment_case7, container, false)

        editText = view.findViewById(R.id.editTextCase7)
        numberPicker = view.findViewById(R.id.number_pickerCase7)
        textView = view.findViewById(R.id.textViewCase7)
        textView2 = view.findViewById(R.id.textViewCase7_2)
        gChecker = view.findViewById(R.id.textViewCase7_3)
        button = view.findViewById(R.id.buttonCase7)
        view.findViewById<Button>(R.id.buttonCase7).setOnClickListener(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberPicker.minValue = 1
        numberPicker.maxValue = 5
        numberPicker.wrapSelectorWheel = true
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            var text = " "
            when (newVal) {
                1 -> {
                    text = "Килограмм"
                    textView2.text = "Ваш выбор: " + text
                }
                2 -> {
                    text = "Миллиграмм"
                    textView2.text = "Ваш выбор: " + text
                }
                3 -> {
                    text = "Грамм"
                    textView2.text = "Ваш выбор: " + text
                }
                4 -> {
                    text = "Тонна"
                    textView2.text = "Ваш выбор: " + text
                }
                5 ->{
                    text = "Центнер"
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
            "Ваш выбор: Килограмм", "Ваш выбор: Миллиграмм", "Ваш выбор: Грамм", "Ваш выбор: Тонна", "Ваш выбор: Центнер" -> textNewValL = textNewVal.toInt()
        }
        when (gChecker2) {
            "Ваш выбор: Килограмм", "Ваш выбор: Миллиграмм", "Ваш выбор: Грамм", "Ваш выбор: Тонна", "Ваш выбор: Центнер" -> checker = 1
        }
        var calc: Long
        if (checker == 0){
            val snackBar = Snackbar.make(requireView(), "Выберите единицу измерения массы", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }else if (editText.text.isEmpty()) {
            val error = "Введите число А"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }else if (checker == 1 && editText.text.isNotEmpty()) {
            val a = editText.text.toString().toLong()
            when (textNewValL) {
                1 -> {
                    calc = a
                    textView.text = "Ответ: в килограммах, как и есть= $calc"
                }
                2 -> {
                    var calc2:Double = a.toDouble() / 1000000
                    textView.text = "Ответ: из миллиграмма в килограммы= $calc2"
                }
                3 -> {
                    var calc2:Double = a.toDouble() / 1000
                    textView.text = "Ответ: из грамма в килограммы= $calc2"
                }
                4 -> {
                    calc = a * 1000
                    textView.text = "Ответ: из миллиметра в килограммы= $calc"
                }
                5 ->{
                    calc = a * 100
                    textView.text = "Ответ: из тонн в килограммы= $calc"
                }
            }
        }else{
            val error = "Ошибка!!!"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }
}


