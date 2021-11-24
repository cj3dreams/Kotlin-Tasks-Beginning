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

class Integer6Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_integer6, container, false)


        editText = view.findViewById(R.id.editTextInteger6)
        button = view.findViewById(R.id.buttonInteger6)
        view.findViewById<Button>(R.id.buttonInteger6).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.isNotEmpty() -> {
                val a = editText.text.toString().toInt()
                if (a in 1..9 || a in 100..999999999999999999){
                    Toast.makeText(requireContext(), "Введите двузначное число", Toast.LENGTH_LONG).show()
                }else if (a in 10..99) {
                    val l = a/10
                    val l2 = a%10
                    Toast.makeText(requireContext(), "Его левая цифра (единицы): $l, правая цифра (десятки): $l2", Toast.LENGTH_LONG).show()
                }else if (a < 0){
                    Toast.makeText(requireContext(), "Введите положительное двузначное число", Toast.LENGTH_LONG).show()
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

