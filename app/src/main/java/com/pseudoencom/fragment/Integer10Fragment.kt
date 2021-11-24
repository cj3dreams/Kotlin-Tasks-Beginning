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

class Integer10Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_integer10, container, false)


        editText = view.findViewById(R.id.editTextInteger10)
        button = view.findViewById(R.id.buttonInteger10)
        view.findViewById<Button>(R.id.buttonInteger10).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.isNotEmpty() -> {
                val a = editText.text.toString().toInt()
                if (a in 1..99 || a in 1000..999999999999999999){
                    Toast.makeText(requireContext(), "Введите трёхзначное число", Toast.LENGTH_LONG).show()
                }else if (a in 100..999) {
                    val l = a%10
                    val l2 = a%100/10
                    Toast.makeText(requireContext(), "Единицы: $l, десятки: $l2", Toast.LENGTH_LONG).show()
                }else if (a < 0){
                    Toast.makeText(requireContext(), "Введите положительное трёхзначное число", Toast.LENGTH_LONG).show()
                }else{
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

