package com.pseudoencom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

open class Begin1Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_begin1, container, false)

        editText = view.findViewById(R.id.editTextBegin1)
        textView = view.findViewById(R.id.textViewBegin1)
        button = view.findViewById(R.id.buttonBegin1)
        view.findViewById<Button>(R.id.buttonBegin1).setOnClickListener(this)
        return view

    }

    override fun onClick(v: View?) {
        when {
            editText.text.toString() == "-" -> {
                Toast.makeText(requireContext(), "Периметр квадрата не может быть просто символом \" - \" ", Toast.LENGTH_LONG).show()
            }
            editText.text.isNotEmpty() -> {
                val a = editText.text.toString().toInt()
                if (a < 0 || a == 0) {
                    Toast.makeText(
                        requireContext(),
                        "Периметр квадрата не может быть отрицательным или нулевым",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (a > 0) {
                    val p = 4 * a
                    Toast.makeText(
                        requireContext(),
                        "Периметр квадрата равен: $p",
                        Toast.LENGTH_LONG
                    ).show()
                    textView.text = "Периметр квадрата равен: $p"

                } else {
                    Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_LONG).show()
                }
            }
            editText.text.isEmpty() -> {
                Toast.makeText(requireContext(), "Введите данные", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(requireContext(), "Ошибка!", Toast.LENGTH_LONG).show()
            }
        }
    }
}

