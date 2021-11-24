package com.pseudoencom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class If4Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_if4, container, false)


        editText = view.findViewById(R.id.editTextIf4)
        editText2 = view.findViewById(R.id.editTextIf4_1)
        editText3 = view.findViewById(R.id.editTextIf4_2)
        button = view.findViewById(R.id.buttonIf4)
        view.findViewById<Button>(R.id.buttonIf4).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        if (editText.text.isNotEmpty() && editText2.text.isNotEmpty() && editText3.text.isNotEmpty()) {
            var a1 = editText.text.toString().toLong()
            var a2 = editText2.text.toString().toLong()
            var a3 = editText3.text.toString().toLong()
            a1 = if (a1 > 0) {
                1
            } else {
                0
            }
            a2 = if (a2 > 0) {
                1
            } else {
                0
            }
            a3 = if (a3 > 0) {
                1
            } else {
                0
            }
            val res = (a1+a2+a3)
            Toast.makeText(requireContext(), "Количество положительных чисел: $res ", Toast.LENGTH_LONG).show()
        }else if (editText.text.isEmpty() && editText2.text.isEmpty() && editText3.text.isEmpty()) {

            Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_LONG).show()
        }else if (editText.text.isEmpty() || editText2.text.isEmpty() || editText3.text.isEmpty()) {

            Toast.makeText(requireContext(), "Введите данные полностью", Toast.LENGTH_LONG).show()
        }
    }
}

