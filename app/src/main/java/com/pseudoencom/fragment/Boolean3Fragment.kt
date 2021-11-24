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

class Boolean3Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_boolean3, container, false)


        editText = view.findViewById(R.id.editTextBoolean3)
        button = view.findViewById(R.id.buttonBoolean3)
        view.findViewById<Button>(R.id.buttonBoolean3).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.isNotEmpty() -> {
                val a = editText.text.toString().toLong()
                if (a == 0.toLong()){
                    Toast.makeText(requireContext(), "Введите ненулевое число", Toast.LENGTH_LONG).show()
                }else if (a%2==0.toLong()){
                    Toast.makeText(requireContext(), "Четное число обнаружено: истина(true)", Toast.LENGTH_LONG).show()
                }else if (a%2==1.toLong()) {
                    Toast.makeText(requireContext(), "Нечетное число обнаружено: ложь (false)", Toast.LENGTH_LONG).show()
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

