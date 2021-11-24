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

class Begin5Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_begin5, container, false)


        editText = view.findViewById(R.id.editTextBegin5)
        button = view.findViewById(R.id.buttonBegin5)
        view.findViewById<Button>(R.id.buttonBegin5).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.isNotEmpty() -> {
                val a = editText.text.toString().toInt()
                if (a < 0 || a == 0){
                    Toast.makeText(requireContext(), "Отрицательное или нулевое число недопустимо!", Toast.LENGTH_LONG).show()
                }else if (a > 0) {
                    val vvv = a*a*a
                    val s=6*(a*a)
                    Toast.makeText(requireContext(), "Объем куба V=$vvv и площадь поверхности S=$s", Toast.LENGTH_LONG).show()
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

