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

class Boolean9Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_boolean9, container, false)


        editText = view.findViewById(R.id.editTextBoolean9)
        editText2 = view.findViewById(R.id.editTextBoolean9_1)
        button = view.findViewById(R.id.buttonBoolean9)
        view.findViewById<Button>(R.id.buttonBoolean9).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.isNotEmpty() && editText2.text.isNotEmpty()  -> {
                val a = editText.text.toString().toLong()
                val b = editText2.text.toString().toLong()
                if (a%2!=0.toLong() || b%2!=0.toLong()){
                    Toast.makeText(requireContext(), "Хотя бы одно из чисел A и B нечетное: истина(true)", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(requireContext(), "Нечетные числа не обнаружены т.е. ложь(false)", Toast.LENGTH_LONG).show()
                }
            }
            editText.text.isEmpty() && editText2.text.isEmpty() -> {
                Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_LONG).show()
            }
            editText.text.isEmpty() || editText2.text.isEmpty() -> {
                Toast.makeText(requireContext(), "Введите данные полностью", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(requireContext(), "Ошибка!!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}

