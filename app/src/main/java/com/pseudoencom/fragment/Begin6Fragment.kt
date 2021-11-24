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

class Begin6Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_begin6, container, false)


        editText = view.findViewById(R.id.editTextBegin6)
        editText2 = view.findViewById(R.id.editTextBegin6_1)
        editText3 = view.findViewById(R.id.editTextBegin6_2)
        button = view.findViewById(R.id.buttonBegin6)
        view.findViewById<Button>(R.id.buttonBegin6).setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when {
            editText.text.isNotEmpty() && editText2.text.isNotEmpty() && editText3.text.isNotEmpty()-> {
                val a = editText.text.toString().toLong()
                val b = editText2.text.toString().toLong()
                val c = editText3.text.toString().toLong()
                if (a < 0 || a.toInt() == 0 && b < 0 || b.toInt() == 0 && c < 0 || c.toInt() == 0){
                    Toast.makeText(requireContext(), "Отрицательное или нулевое число недопустимо", Toast.LENGTH_LONG).show()
                }else if (a > 0 && b>0 && c>0) {
                    val vv=a*b*c
                    val s=2*(a*b+b*c+a*c)
                    Toast.makeText(requireContext(), "Его объем V=$vv и площадь поверхности S=$s", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_LONG).show()
                }
            }editText.text.isEmpty() && editText2.text.isEmpty() && editText3.text.isEmpty() -> {
            Toast.makeText(requireContext(), "Введите данные!", Toast.LENGTH_LONG).show()
            }
            editText.text.isEmpty() || editText2.text.isEmpty() || editText3.text.isEmpty() -> {
                Toast.makeText(requireContext(), "Введите данные полностью!", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(requireContext(), "Ошибка!", Toast.LENGTH_LONG).show()
            }
        }

    }
}

