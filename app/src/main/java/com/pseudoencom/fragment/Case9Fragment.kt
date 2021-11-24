package com.pseudoencom.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class Case9Fragment : Fragment(), View.OnClickListener {
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
        val view: View = inflater.inflate(R.layout.fragment_case9, container, false)

        editText = view.findViewById(R.id.editTextCase9)
        numberPicker = view.findViewById(R.id.number_pickerCase9)
        textView = view.findViewById(R.id.textViewCase9)
        textView2 = view.findViewById(R.id.textViewCase9_2)
        gChecker = view.findViewById(R.id.textViewCase9_3)
        button = view.findViewById(R.id.buttonCase9)
        view.findViewById<Button>(R.id.buttonCase9).setOnClickListener(this)

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
                    text = "Январь"
                    textView2.text = "Ваш выбор: $text"
                }
                2 -> {
                    text = "Февраль"
                    textView2.text = "Ваш выбор: $text"
                }
                3 -> {
                    text = "Март"
                    textView2.text = "Ваш выбор: $text"
                }
                4 -> {
                    text = "Апрель"
                    textView2.text = "Ваш выбор: $text"
                }
                5 -> {
                    text = "Май"
                    textView2.text = "Ваш выбор: $text"
                }
                6 -> {
                    text = "Июнь"
                    textView2.text = "Ваш выбор: $text"
                }
                7 -> {
                    text = "Июль"
                    textView2.text = "Ваш выбор: $text"
                }
                8 -> {
                    text = "Август"
                    textView2.text = "Ваш выбор: $text"
                }
                9 -> {
                    text = "Сентябрь"
                    textView2.text = "Ваш выбор: $text"
                }
                10 -> {
                    text = "Октябрь"
                    textView2.text = "Ваш выбор: $text"
                }
                11 -> {
                    text = "Ноябрь"
                    textView2.text = "Ваш выбор: $text"
                }
                12 -> {
                    text = "Декабрь"
                    textView2.text = "Ваш выбор: $text"
                }
            }
            gChecker = textView2
            textNewVal = newVal.toString()

            val snackBar = Snackbar.make(requireView(), "Вы выбрали: $text", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }

    }

    override fun onClick(v: View?) {
        var gChecker2 = gChecker.text.toString()
        var checker = 0
         var textNewValL = 1
        when (gChecker2) {
            "Ваш выбор: Январь", "Ваш выбор: Февраль", "Ваш выбор: Март", "Ваш выбор: Апрель", "Ваш выбор: Май", "Ваш выбор: Июнь", "Ваш выбор: Июль", "Ваш выбор: Август", "Ваш выбор: Сентябрь", "Ваш выбор: Октябрь", "Ваш выбор: Ноябрь", "Ваш выбор: Декабрь" ->
                textNewValL = textNewVal.toInt()
        }
        when (gChecker2) {
            "Ваш выбор: Январь", "Ваш выбор: Февраль", "Ваш выбор: Март", "Ваш выбор: Апрель", "Ваш выбор: Май", "Ваш выбор: Июнь", "Ваш выбор: Июль", "Ваш выбор: Август", "Ваш выбор: Сентябрь", "Ваш выбор: Октябрь", "Ваш выбор: Ноябрь", "Ваш выбор: Декабрь" ->
                checker = 1
        }
        if (checker == 0) {
            val snackBar = Snackbar.make(requireView(), "Выберите месяц", Snackbar.LENGTH_SHORT)
            snackBar.show()
        } else if (editText.text.isEmpty()) {
            val error = "Введите какой-нибудь день"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }else if (editText.text.toString() == "-" ){
            Toast.makeText(requireContext(), "День не может быть просто символом \"-\" ", Toast.LENGTH_LONG).show()
        }else if (checker == 1 && editText.text.toString().toInt() in 1..31) {
            var d = editText.text.toString().toInt() + 1
            var m = textNewValL.toInt()
            var dN = d
            var mN = m
            when (m) {
                1, 3, 5, 7, 8, 10 -> {
                    when {
                        d > 31 -> {
                            dN = 1
                            mN = m + 1
                            textView.visibility = View.VISIBLE
                            textView.text = "След. дата после указаной: $dN день и $mN-й месяц."
                        }
                        else -> {
                            textView.visibility = View.VISIBLE
                            textView.text = "След. дата после указаной: $dN день и $mN-й месяц."
                        }
                    }
                }
                4, 6, 9, 11 -> {
                    when (d) {
                        31 -> {
                            dN = 1
                            mN = m + 1
                            textView.visibility = View.VISIBLE
                            textView.text = "След. дата после указаной: $dN день и $mN-й месяц."
                        }
                        32 -> {
                            textView.visibility = View.INVISIBLE
                            textView.text = "В данном месяце 30 дней!"
                            Toast.makeText(requireContext(), textView.text, Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            textView.visibility = View.VISIBLE
                            textView.text = "След. дата после указаной: $dN день и $mN-й месяц."
                        }
                    }
                }
                2 -> {
                    when {
                        d == 29 -> {
                            dN = 1
                            mN = m + 1
                            textView.visibility = View.VISIBLE
                            textView.text = "След. дата после указаной: $dN день и $mN-й месяц."
                        }
                        d > 29 -> {
                            textView.visibility = View.INVISIBLE
                            textView.text = "В месяце феврале 28 дней!"
                            Toast.makeText(requireContext(), textView.text, Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            textView.visibility = View.VISIBLE
                            textView.text = "След. дата после указаной: $dN день и $mN-й месяц."
                        }
                    }
                }
                12 -> {
                    when {
                        d > 31 -> {
                            dN = 1
                            mN = 1
                            textView.visibility = View.VISIBLE
                            textView.text = "След. дата после указаной: $dN день и $mN-й месяц."
                        }
                        else -> {
                            textView.visibility = View.VISIBLE
                            textView.text = "След. дата после указаной: $dN день и $mN-й месяц."
                        }
                    }
                }
            }
        } else {
            val error = "Введите правильно! Обычно в месяцах 31 день"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show() }
    }
}

