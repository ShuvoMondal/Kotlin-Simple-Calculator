package com.shuvomondal.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var add: Button
    private lateinit var sub: Button
    private lateinit var multi: Button
    private lateinit var div: Button
    private lateinit var ans: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        multi = findViewById(R.id.mult)
        div = findViewById(R.id.div)
        ans = findViewById(R.id.ans)

        add.setOnClickListener {
            if(inputIsNotEmpty()){
                val number1 = num1.text.toString().trim().toBigDecimal()
                val number2 = num2.text.toString().trim().toBigDecimal()
                ans.text = number1.add(number2).toString()
            }
        }

        sub.setOnClickListener {
            if(inputIsNotEmpty()){
                val number1 = num1.text.toString().trim().toBigDecimal()
                val number2 = num2.text.toString().trim().toBigDecimal()
                ans.text = number1.subtract(number2).toString()
            }
        }

        multi.setOnClickListener {
            if(inputIsNotEmpty()){
                val number1 = num1.text.toString().trim().toBigDecimal()
                val number2 = num2.text.toString().trim().toBigDecimal()
                ans.text = number1.multiply(number2).toString()
            }
        }

        div.setOnClickListener {
            if(inputIsNotEmpty()){
                val number1 = num1.text.toString().trim().toBigDecimal()
                val number2 = num2.text.toString().trim().toBigDecimal()

                if(number2.compareTo(BigDecimal.ZERO)  == 0){
                    num2.error = "Invalid Input"
                }
                else{
                    ans.text = number1.divide(number2,4,RoundingMode.HALF_UP).toString()
                }
            }
        }

    }

    fun inputIsNotEmpty():Boolean{
        var check = true
        if(num1.text.toString().trim().isEmpty()){
            num1.error = "Required"
            check = false
        }
        if(num2.text.toString().trim().isEmpty()){
            num2.error = "Required"
            check = false
        }
        return check
    }
}
