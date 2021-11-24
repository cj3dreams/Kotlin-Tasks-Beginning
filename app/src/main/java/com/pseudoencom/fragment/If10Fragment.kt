package com.pseudoencom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class If10Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_if10, container, false)


        editText = view.findViewById(R.id.editTextIf10)
        editText2 = view.findViewById(R.id.editTextIf10_1)
        button = view.findViewById(R.id.buttonIf10)
        view.findViewById<Button>(R.id.buttonIf10).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        if (editText.text.isNotEmpty() && editText2.text.isNotEmpty()) {
            var a = editText.text.toString().toLong()
            var b = editText2.text.toString().toLong()
            if (a!=b) {
                a = a + b
                b = a
                Toast.makeText(requireContext(), "Новые значения переменных A и B: A=$a B=$b", Toast.LENGTH_LONG).show()
            }else if (a==b){
                a=0; b=0;
                Toast.makeText(requireContext(), "Новые значения переменных A и B: A=$a B=$b", Toast.LENGTH_LONG).show()
            }
        } else if (editText.text.isEmpty() && editText2.text.isEmpty()) {
            Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_LONG).show()
        } else if (editText.text.isEmpty() || editText2.text.isEmpty()) {
            Toast.makeText(requireContext(), "Введите данные полностью", Toast.LENGTH_LONG).show()
        }
    }
}
