package com.pseudoencom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class If3Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_if3, container, false)


        editText = view.findViewById(R.id.editTextIf3)
        button = view.findViewById(R.id.buttonIf3)
        view.findViewById<Button>(R.id.buttonIf3).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.isNotEmpty() -> {
                val a = editText.text.toString().toLong()
                val resultofif: String = if (a > 0) {
                    val calc = a + 1
                    "Положительное число обнаружено= $a, а ответ $calc"
                } else if (a < 0) {
                    val calc = a - 2
                    "Отрицательное число обнаружено $a, а ответ $calc"
                }else if (a.toInt()==0) {
                    val calc = a + 10
                    "Ноль обнаружен $a, а ответ $calc"
                }else{
                    "Ошибка!"
                }
                Toast.makeText(requireContext(), resultofif, Toast.LENGTH_LONG).show()
            }
            editText.text.isEmpty() -> {
                Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(requireContext(), "Ошибка!", Toast.LENGTH_LONG).show()
            }
        }
    }
}

