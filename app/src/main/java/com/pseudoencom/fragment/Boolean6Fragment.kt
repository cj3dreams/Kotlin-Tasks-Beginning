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

class Boolean6Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_boolean6, container, false)


        editText = view.findViewById(R.id.editTextBoolean6)
        editText2 = view.findViewById(R.id.editTextBoolean6_1)
        editText3 = view.findViewById(R.id.editTextBoolean6_2)
        button = view.findViewById(R.id.buttonBoolean6)
        view.findViewById<Button>(R.id.buttonBoolean6).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        if (editText.text.isNotEmpty() && editText2.text.isNotEmpty() && editText3.text.isNotEmpty()) {
                val a = editText.text.toString().toLong()
                val b = editText2.text.toString().toLong()
                val c = editText3.text.toString().toLong()
                if (a < b && b < c) {
                    Toast.makeText(requireContext(), "Двойное неравенство справедливо: истина(true)", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(requireContext(), "Двойное неравенство несправедливо: ложь(false)", Toast.LENGTH_LONG).show()
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

