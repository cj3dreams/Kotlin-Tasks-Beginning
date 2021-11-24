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

class Begin2Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_begin2, container, false)


        editText = view.findViewById(R.id.editTextBegin2)
        button = view.findViewById(R.id.buttonBegin2)
        view.findViewById<Button>(R.id.buttonBegin2).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.toString() == "-" -> {
                Toast.makeText(requireContext(), "Площадь квадрата не может быть просто символом \" - \" ", Toast.LENGTH_LONG).show()
            }
            editText.text.isNotEmpty() -> {
                val a = editText.text.toString().toInt()
                if (a < 0 || a == 0){
                    Toast.makeText(requireContext(), "Площадь квадрата не может быть отрицательным или нулевым", Toast.LENGTH_LONG).show()
                }else if (a > 0) {
                    val s = a * a
                    Toast.makeText(requireContext(), "Площадь квадрата равен: $s", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_LONG).show()
                }
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

