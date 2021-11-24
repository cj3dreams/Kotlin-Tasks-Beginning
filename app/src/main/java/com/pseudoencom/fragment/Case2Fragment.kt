package com.pseudoencom.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


class Case2Fragment : Fragment(), View.OnClickListener {
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
        val view: View = inflater.inflate(R.layout.fragment_case2, container, false)


        editText = view.findViewById(R.id.editTextCase2)
        numberPicker = view.findViewById(R.id.number_pickerCase2)
        textView = view.findViewById(R.id.textViewCase2)

        textView2 = view.findViewById(R.id.textViewCase2_2)
        button = view.findViewById(R.id.buttonCase2)
        view.findViewById<Button>(R.id.buttonCase2).setOnClickListener(this)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberPicker.minValue = 0
        numberPicker.maxValue = 5
        numberPicker.wrapSelectorWheel = true
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            var text = " "
            when (newVal) {
                0 -> {
                    text = "Ошибка, пустой выбор"
                    textView2.text = "Ошибка, пустой выбор"
                }
                1 -> {
                    text = "Плохо"
                    textView2.text = "Автоматический выбор: " + text
                }
                2 -> {
                    text = "Неудовлетворительно"
                    textView2.text = "Автоматический выбор: " + text
                }
                3 -> {
                    text = "Удовлетворительно"
                    textView2.text = "Автоматический выбор: " + text
                }
                4 -> {
                    text = "Хорошо"
                    textView2.text = "Автоматический выбор: " + text
                }
                5 -> {
                    text = "Отлично"
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
                    textView.text = "Плохо"
                }
                2 -> {
                    textView.text = "Неудовлетворительно"
                }
                3 -> {
                    textView.text = "Удовлетворительно"
                }
                4 -> {
                    textView.text = "Хорошо"
                }
                5 -> {
                    textView.text = "Отлично"
                }
                else -> {
                    textView.text = "Ошибка"
                }
            }
        } else if (editText.text.isEmpty()) {
            val error = "Введите число К"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }else {
            val error = "Ошибка!!!"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }
}


