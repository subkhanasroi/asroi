package com.asroisubkhan.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLenght: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLenght = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener ( this  )
    }
    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate) {
            val inputLength = edtLenght.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyFields = false
            var isInvalidDouble = false

            if (inputLength.isEmpty()) {
                isEmptyFields = true
                edtLenght.error = "Field Ini Tidak Boleh Kosong"
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                edtWidth.error = "Field Ini Tidak Boleh Kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                edtHeight.error = "Field Ini Tidak Boleh Kosong"
            }

            val length = toDouble(inputLength)
            val width = toDouble(inputWidth)
            val height = toDouble(inputHeight)

            if (length == null) {
                isInvalidDouble = true
                edtLenght.error = "Field Ini Harus Berupa Nomer yang Valid"
            }
            if (width == null) {
                isInvalidDouble = true
                edtWidth.error = "Field Ini Harus Berupa Nomer yang Valid"
            }
            if (height == null) {
                isInvalidDouble = true
                edtHeight.error = "Field Ini Harus Berupa Nomer yang Valid"
            }
            if (!isEmptyFields && !isInvalidDouble) {
                val volume = length as Double * width as Double * height as Double
                tvResult.text = volume.toString()
            }
        }
    }
        private fun toDouble(str:String): Double?{
            return try {
                str.toDouble()
            } catch (e: NumberFormatException) {
                null
            }
        }
    }
