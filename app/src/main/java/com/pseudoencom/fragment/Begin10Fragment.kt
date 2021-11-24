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
import kotlin.math.sqrt

class Begin10Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_begin10, container, false)


        editText = view.findViewById(R.id.editTextBegin10)
        editText2 = view.findViewById(R.id.editTextBegin10_1)
        button = view.findViewById(R.id.buttonBegin10)
        view.findViewById<Button>(R.id.buttonBegin10).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.isNotEmpty() && editText2.text.isNotEmpty() -> {
                val a = editText.text.toString().toInt()
                val b = editText2.text.toString().toInt()
                if (a < 0 || a == 0 && b < 0 || b == 0){
                    Toast.makeText(requireContext(), "Отрицательное или нулевое число недопустимо", Toast.LENGTH_LONG).show()
                }else if (a > 0 && b>0) {
                    val sum  = a*a+b*b
                    val diff = a*a-b*b
                    val pro = (a*a)*(b*b)
                    val quo = (a*a).toDouble()/(b*b).toDouble()
                    Toast.makeText(requireContext(), "Сумма: $sum, разность: $diff, произведение: $pro и частное: $quo", Toast.LENGTH_LONG).show()
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

