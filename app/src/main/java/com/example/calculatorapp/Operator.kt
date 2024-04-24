package com.example.calculatorapp


import android.view.View
import android.widget.Button
import com.example.calculatorapp.databinding.ActivityMainBinding

class Operator(private val binding: ActivityMainBinding) : View.OnClickListener {
    private var number1: Double = 0.0
    private var number2: Double? = null
    private var result: Double = 0.0
    private var operator: String? = null
    private var useOperator: Boolean = false


    override fun onClick(v: View?) {
        when (v?.id) {
            binding.cBttn.id -> clear()
            binding.changeOperatorBttn.id -> binding.text2.text =
                (binding.text2.text.toString().toDouble() * -1).toString()

            binding.equalsBttn.id -> handelEqualsBttn()
            binding.PlusBttn.id, binding.minusBttn.id, binding.multiplyBttn.id,
            binding.divisionBttn.id, binding.modBttn.id -> handleArithmeticOperations((v as Button).text.toString())

            else -> addNumberToText((v as Button).text.toString())

        }
    }

    private fun addNumberToText(number: String) {
        binding.text2.text = binding.text2.text.let {
            if (it != "0" && !useOperator) "$it$number" else {
                useOperator = false
                number
            }
        }
    }

    private fun handleArithmeticOperations(operator: String) {
        var number = binding.text2.text.toString().toDouble()
        this.operator = operator
        if (binding.text1.text.toString() == "") number1 = number else number2 = number

        binding.text1.text = "$number1 $operator"
        if (!useOperator && number2 != null) {
            arithmeticOperations()
            binding.text1.text = "$result $operator"
            binding.text2.text = "${result.toString().replace(".0", "")}"
            number1 = result

        }
        useOperator = true

    }

    private fun handelEqualsBttn() {
        if (binding.text1.text == "" || binding.text1.text.endsWith('=')) {
            binding.text1.text = "${binding.text2.text} ="
        } else {
            number2 = binding.text2.text.toString().toDouble()
            arithmeticOperations()
            binding.text1.text = "$number1 $operator $number2"
            binding.text2.text = "${result.toString().replace(".0", "")}"
            number1 = result
        }
        useOperator = true
    }

    private fun arithmeticOperations() {

        result = when (operator) {
            "+" -> number1 + number2!!
            "-" -> number1 - number2!!
            "X" -> number1 * number2!!
            "/" -> number1 / number2!!
            "%" -> number1 % number2!!
            else -> result
        }
        result = String.format("%.2f", result).toDouble()
    }

    private fun clear() {
        result = 0.0;number1 = 0.0;number2 = null
        binding.text2.text = "0";binding.text1.text = ""
    }


}