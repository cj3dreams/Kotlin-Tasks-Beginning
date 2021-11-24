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

class Boolean7Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_boolean7, container, false)


        editText = view.findViewById(R.id.editTextBoolean7)
        editText2 = view.findViewById(R.id.editTextBoolean7_1)
        editText3 = view.findViewById(R.id.editTextBoolean7_2)
        button = view.findViewById(R.id.buttonBoolean7)
        view.findViewById<Button>(R.id.buttonBoolean7).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        if (editText.text.isNotEmpty() && editText2.text.isNotEmpty() && editText3.text.isNotEmpty()) {
            val a = editText.text.toString().toLong()
            val b = editText2.text.toString().toLong()
            val c = editText3.text.toString().toLong()
            if (b > a && b < c || b < a && b > c) {
                Toast.makeText(requireContext(), "Число B находится между числами A и C: истина(true)", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(requireContext(), "Число B не находится между числами A и C: ложь(false)", Toast.LENGTH_LONG).show()
            }
        } else if (editText.text.isEmpty() && editText2.text.isEmpty() && editText3.text.isEmpty()) {
            Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_LONG).show()
        } else if (editText.text.isEmpty() || editText2.text.isEmpty() || editText3.text.isEmpty()) {
            Toast.makeText(requireContext(), "Введите данные полностью", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Ошибка!!!", Toast.LENGTH_LONG).show()
        }
    }

}

