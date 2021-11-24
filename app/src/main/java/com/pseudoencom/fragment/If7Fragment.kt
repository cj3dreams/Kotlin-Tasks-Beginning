package com.pseudoencom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class If7Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_if7, container, false)


        editText = view.findViewById(R.id.editTextIf7)
        editText2 = view.findViewById(R.id.editTextIf7_1)
        button = view.findViewById(R.id.buttonIf7)
        view.findViewById<Button>(R.id.buttonIf7).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        if (editText.text.isNotEmpty() && editText2.text.isNotEmpty()) {
            val a1 = editText.text.toString().toLong()
            val a2 = editText2.text.toString().toLong()
            if (a1<a2) {
                Toast.makeText(requireContext(), "Первое число меньше, порядковый номер: 1", Toast.LENGTH_LONG).show()
            }else if (a1>a2) {
                Toast.makeText(requireContext(), "Второе число меньше, порядковый номер: 2", Toast.LENGTH_LONG).show()
            }else if (a1==a2){
                Toast.makeText(requireContext(), "Оба числа равны", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_LONG).show()
            }
        } else if (editText.text.isEmpty() && editText2.text.isEmpty()) {
            Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_LONG).show()
        } else if (editText.text.isEmpty() || editText2.text.isEmpty()) {
            Toast.makeText(requireContext(), "Введите данные полностью", Toast.LENGTH_LONG).show()
        }
    }
}
