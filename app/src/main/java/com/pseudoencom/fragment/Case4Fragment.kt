package com.pseudoencom.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


class Case4Fragment : Fragment(), View.OnClickListener {
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
        val view: View = inflater.inflate(R.layout.fragment_case4, container, false)

        editText = view.findViewById(R.id.editTextCase4)
        numberPicker = view.findViewById(R.id.number_pickerCase4)
        textView = view.findViewById(R.id.textViewCase4)
        textView2 = view.findViewById(R.id.textViewCase4_2)
        button = view.findViewById(R.id.buttonCase4)
        view.findViewById<Button>(R.id.buttonCase4).setOnClickListener(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberPicker.minValue = 1
        numberPicker.maxValue = 12
        numberPicker.wrapSelectorWheel = true
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            var text = " "
            var text2 = " "
            when (newVal) {
                1,3,5,7,8,10,12 -> {
                    if (newVal == 1){
                        text2 = "январе"
                    }else if (newVal == 3){
                        text2 = "марте"
                    }else if (newVal == 5){
                        text2 = "мае"
                    }else if (newVal == 7){
                        text2 = "июле"
                    }else if (newVal == 8){
                        text2 = "августе"
                    }else if (newVal == 10){
                        text2 = "октябре"
                    }else if (newVal == 12){
                        text2 = "декабре"
                    }
                    text = "В $text2: 31 дней"
                    textView2.text = text
                }
                4,6,9,11 -> {
                    if (newVal == 4){
                        text2 = "апреле"
                    }else if (newVal == 6){
                        text2 = "июне"
                    }else if (newVal == 9) {
                        text2 = "сентябре"
                    }else if (newVal == 11) {
                        text2 = "ноябре"
                    }
                    text = "В $text2: 30 дней"
                    textView2.text = text
                }
                2 -> {
                    text = "В феврале: 28 дней"
                    textView2.text = "В феврале: 28 дней"
                }
            }
            val snackBar = Snackbar.make(requireView(), "$text", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }

    }

    override fun onClick(v: View?) {
        if (editText.text.isNotEmpty()) {
            when (editText.text.toString().toInt()) {
                1,3,5,7,8,10,12 -> {
                    textView.text = "В введенном месяце: 31 дней"
                }
                4,6,9,11 -> {
                    textView.text = "В введенном месяце: 30 дней"
                }
                2 -> {
                    textView.text = "В введенном месяце: 28 дней"
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


