package com.pseudoencom.fragment

import android.icu.text.SymbolTable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Integer2Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_integer2, container, false)


        editText = view.findViewById(R.id.editTextInteger2)
        button = view.findViewById(R.id.buttonInteger2)
        view.findViewById<Button>(R.id.buttonInteger2).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.isNotEmpty() -> {
                val a = editText.text.toString().toInt()
                if (a < 0 || a == 0){
                    Toast.makeText(requireContext(), "Отрицательное или нулевое число недопустимо!", Toast.LENGTH_LONG).show()
                }else if (a > 0) {
                    val l = a.toDouble()/1000
                    Toast.makeText(requireContext(), "В тоннах: $l тонн", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(requireContext(), "Ошибка!!!", Toast.LENGTH_LONG).show()
                }
            }
            editText.text.isEmpty() -> {
                Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(requireContext(), "Ошибка!!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}

