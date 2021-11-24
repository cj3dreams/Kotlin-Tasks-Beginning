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

class Begin3Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_begin3, container, false)


        editText = view.findViewById(R.id.editTextBegin3)
        editText2 = view.findViewById(R.id.editTextBegin3_1)
        button = view.findViewById(R.id.buttonBegin3)
        view.findViewById<Button>(R.id.buttonBegin3).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.toString() == "-" || editText2.text.toString() == "-" -> {
                Toast.makeText(requireContext(), "Стороны не могут быть просто символом \" - \" ", Toast.LENGTH_LONG).show()
            }
            editText.text.isNotEmpty() && editText2.text.isNotEmpty() -> {
                val a = editText.text.toString().toInt()
                val b = editText2.text.toString().toInt()
                if (a < 0 || a == 0 && b < 0 || b == 0){
                    Toast.makeText(requireContext(), "Отрицательное или нулевое число недопустимо", Toast.LENGTH_LONG).show()
                }else if (a > 0 && b>0) {
                    val s = a*b
                    val p=2*(a+b)
                    Toast.makeText(requireContext(), "Площадь прямоугольника S=$s и его периметр P=$p", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_LONG).show()
                }
            }editText.text.isEmpty() && editText2.text.isEmpty() -> {
            Toast.makeText(requireContext(), "Введите данные!", Toast.LENGTH_LONG).show()
            }
            editText.text.isEmpty() || editText2.text.isEmpty() -> {
                Toast.makeText(requireContext(), "Введите данные полностью!", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(requireContext(), "Ошибка!", Toast.LENGTH_LONG).show()
            }
        }
    }
}

