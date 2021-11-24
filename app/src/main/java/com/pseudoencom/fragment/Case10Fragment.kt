package com.pseudoencom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class Case10Fragment : Fragment(), View.OnClickListener {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var numberPicker: NumberPicker
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var textNewVal: String
    private lateinit var gChecker: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_case10, container, false)

        editText = view.findViewById(R.id.editTextCase10)
        numberPicker = view.findViewById(R.id.number_pickerCase10)
        textView = view.findViewById(R.id.textViewCase10)
        textView2 = view.findViewById(R.id.textViewCase10_2)
        gChecker = view.findViewById(R.id.textViewCase10_3)
        button = view.findViewById(R.id.buttonCase10)
        view.findViewById<Button>(R.id.buttonCase10).setOnClickListener(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var nums = arrayOf("-1", "0", "1")
        numberPicker.minValue = 1
        numberPicker.maxValue = 3
        numberPicker.wrapSelectorWheel = true
        numberPicker.displayedValues = nums
        numberPicker.setOnValueChangedListener { _, _, newVal ->
            var text = " "
            when (newVal) {
                1 -> {
                    text = "Поворот налево"
                    textView2.text = "Ваш выбор: " + text
                }
                2 -> {
                    text = "Продолжать движение"
                    textView2.text = "Ваш выбор: " + text
                }
                3 -> {
                    text = "Поворот направо"
                    textView2.text = "Ваш выбор: " + text
                }else -> {
                    text = "Empty"
                    textView2.text = "Empty"
                }
            }
            gChecker = textView2
            textNewVal = newVal.toString()

            val snackBar = Snackbar.make(requireView(), "Вы выбрали: $text", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }

    }

    override fun onClick(v: View?) {
        var gChecker2:String? = gChecker.text.toString()
        var checker :Int? = 0
        var textNewValL: Int? = 1
        when (gChecker2){
            "Ваш выбор: Поворот налево", "Ваш выбор: Продолжать движение", "Ваш выбор: Поворот направо" -> textNewValL = textNewVal.toInt()
        }
        when (gChecker2) {
            "Ваш выбор: Поворот налево", "Ваш выбор: Продолжать движение", "Ваш выбор: Поворот направо" -> checker = 1
        }
        var calc: Long
        if (checker == 0){
            val snackBar = Snackbar.make(requireView(), "Выберите цифровую команду", Snackbar.LENGTH_SHORT)
            snackBar.show()
        }else if (editText.text.isEmpty()) {
            val error = "Введите направление"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }else if (checker == 1 && editText.text.isNotEmpty()){
            val a = editText.text.toString()
            var res = " "
            when (a){
                "С","с","Север","север" ->{
                    when (textNewValL){
                        3 ->{
                            res = "Запад"
                        }
                        2 ->{
                            res = "Север"
                        }
                        1 ->{
                            res = "Восток"
                        }
                    }
                }
                "В","в","Восток","восток" -> {
                    when (textNewValL){
                    3->{
                        res = "Север"
                    }
                    2 ->{
                        res = "Восток"
                    }
                    1 ->{
                        res= "Юг"
                        }
                    }
                }
                "Ю","ю","Юг","юг" ->{
                    when (textNewValL) {
                        3 -> {
                            res = "Восток"
                        }
                        2 -> {
                            res = "Юг"
                        }
                        1 -> {
                            res = "Запад"
                        }
                    }
                }
                "З","з","Запад","запад" ->{
                    when (textNewValL) {
                        3 -> {
                            res = "Юг"
                        }
                        2 -> {
                            res = "Запад"
                        }
                        1 -> {
                            res = "Север"
                        }
                    }
                }
                else ->{
                    val error = "Введите Ю - Юг, З - Запад, В - Восток, С - Север"
                    Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
                    textView.text = error
                }
            }

            textView.text = res

        }else{
            val error = "Ошибка!"
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }
}


