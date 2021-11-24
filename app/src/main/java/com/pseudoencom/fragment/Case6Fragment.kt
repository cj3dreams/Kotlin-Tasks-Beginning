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

class Case6Fragment : Fragment(), View.OnClickListener {
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
        val view: View = inflater.inflate(R.layout.fragment_case6, container, false)

        editText = view.findViewById(R.id.editTextCase6)
        numberPicker = view.findViewById(R.id.number_pickerCase6)
        textView = view.findViewById(R.id.textViewCase6)
        textView2 = view.findViewById(R.id.textViewCase6_2)
        gChecker = view.findViewById(R.id.textViewCase6_3)
        button = view.findViewById(R.id.buttonCase6)
        view.findViewById<Button>(R.id.buttonCase6).setOnClickListener(this)

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
                    text = "Дециметр"
                    textView2.text = "Ваш выбор: " + text
                }
                2 -> {
                    text = "Километр"
                    textView2.text = "Ваш выбор: " + text
                }
                3 -> {
                    text = "Метр"
                    textView2.text = "Ваш выбор: " + text
                }
                4 -> {
                    text = "Миллиметр"
                    textView2.text = "Ваш выбор: " + text
                }
                5 ->{
                    text = "Cантиметр"
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
            "Ваш выбор: Дециметр", "Ваш выбор: Километр", "Ваш выбор: Метр", "Ваш выбор: Миллиметр", "Ваш выбор: Cантиметр" -> textNewValL = textNewVal.toInt()
        }
        when (gChecker2) {
            "Ваш выбор: Дециметр", "Ваш выбор: Километр", "Ваш выбор: Метр", "Ваш выбор: Миллиметр", "Ваш выбор: Cантиметр" -> checker = 1
        }
        var calc: Long
        if (checker == 0){
            val snackBar = Snackbar.make(requireView(), "Выберите единицу длины", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }else if (editText.text.isEmpty()) {
            val error = "Введите число А"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }else if (checker == 1 && editText.text.isNotEmpty()) {
            val a = editText.text.toString().toLong()
            when (textNewValL) {
                1 -> {
                    var calc2 = a /10
                    textView.text = "Ответ: с дециметра в метры= $calc2"
                }
                2 -> {
                    calc = a *1000
                    textView.text = "Ответ: c километра в метры= $calc"
                }
                3 -> {
                    calc = a
                    textView.text = "Ответ: в метрах, как и есть= $calc"
                }
                4 -> {
                    var calc2:Double = a.toDouble() / 1000
                    textView.text = "Ответ: с миллиметра в метры= $calc2"
                }
                5 ->{
                    var calc2:Double = a.toDouble() /100
                    textView.text = "Ответ: с сантиметра в метры= $calc2"
                }
            }
        }else{
            val error = "Ошибка!!!"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }
}


