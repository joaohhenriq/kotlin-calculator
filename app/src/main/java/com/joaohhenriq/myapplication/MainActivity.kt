package com.joaohhenriq.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var op: String = "+"
    var oldNumber: String = ""
    var isNewOp: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClickEvent(view : View) {

        if(isNewOp) {
            editShowNumber.setText("")
        }

        isNewOp = false

        val btnSelected = view as Button
        var number: String = editShowNumber.text.toString()

        when (btnSelected.id) {
            btn0.id -> {
                number += "0"
            }
            btn1.id -> {
                number += "1"
            }
            btn2.id -> {
                number += "2"
            }
            btn3.id -> {
                number += "3"
            }
            btn4.id -> {
                number += "4"
            }
            btn5.id -> {
                number += "5"
            }
            btn6.id -> {
                number += "6"
            }
            btn7.id -> {
                number += "7"
            }
            btn8.id -> {
                number += "8"
            }
            btn9.id -> {
                number += "9"
            }
            btnDot.id -> {
                number += "."
            }
            btnPlusMinus.id -> {
                number = "-$number"
            }
        }

        editShowNumber.setText(number)
    }

    fun btnClickOpEvent(view: View) {
        val btnSelected = view as Button

        when(btnSelected.id) {
            btnDiv.id -> {
                op = "/"
            }
            btnMult.id -> {
                op = "*"
            }
            btnMinus.id -> {
                op = "-"
            }
            btnPlus.id -> {
                op = "+"
            }
        }

        oldNumber = editShowNumber.text.toString()
        isNewOp = true
    }

    fun btnClickEqualEvent(view: View) {
        val newNumber: String = editShowNumber.text.toString()
        var finalNumber: Double = 0.0
        when(op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
        }

        editShowNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    fun btnClickPercentEvent(view: View) {
        val number: Double = editShowNumber.text.toString().toDouble() / 100
        editShowNumber.setText(number.toString())
    }

    fun btnClickClearEvent(view: View) {
        editShowNumber.setText("0")
        isNewOp = true
    }
}