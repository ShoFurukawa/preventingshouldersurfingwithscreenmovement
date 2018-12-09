package com.application.shohei.preventingshouldersurfingwithscreenmovement

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import android.text.Editable


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //SetPasswordActivityのeditTextの内容を受け取る
        val password = intent.getIntExtra("password", 0)

        //EditTextでキーボード入力が出ないようにした
        editText.keyListener = null

        //editTextの幅を設定(pixel)
        editText.width = 200


        //数字ごとの処理
        one.setOnClickListener {
            addStr(inputNumberCalc(1, addNumber).toString())
            randomImage()
        }
        two.setOnClickListener {
            addStr(inputNumberCalc(2, addNumber).toString())
            randomImage()
        }
        three.setOnClickListener {
            addStr(inputNumberCalc(3, addNumber).toString())
            randomImage()
        }
        four.setOnClickListener {
            addStr(inputNumberCalc(4, addNumber).toString())
            randomImage()
        }
        five.setOnClickListener {
            addStr(inputNumberCalc(5, addNumber).toString())
            randomImage()
        }
        six.setOnClickListener {
            addStr(inputNumberCalc(6, addNumber).toString())
            randomImage()
        }
        seven.setOnClickListener {
            addStr(inputNumberCalc(7, addNumber).toString())
            randomImage()
        }
        eight.setOnClickListener {
            addStr(inputNumberCalc(8, addNumber).toString())
            randomImage()
        }
        nine.setOnClickListener {
            addStr(inputNumberCalc(9, addNumber).toString())
            randomImage()
        }
        zero.setOnClickListener {
            addStr(inputNumberCalc(0, addNumber).toString())
            randomImage()
        }
        //数字の削除処理
        backspace.setOnClickListener { deleteStr() }
        randomImage()
    }

    //数字を押したときの処理
    private fun addStr(str: String) {
        // Editableインスタンス取得
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        val textlength = editable.length
        editable.insert(textlength, str)
        // TextViewにセットする
        editText.setText(editable, TextView.BufferType.EDITABLE)
    }

    //EditTextの一番後ろの数字を削除
    private fun deleteStr() {
        // Editableインスタンス取得
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        // ボタンを押すごとに先頭1文字を削除
        val textlength = editable.length
        if (textlength > 0) {
            editable.delete(textlength - 1, textlength)
        }
        // TextViewにセットする
        editText.setText(editable, TextView.BufferType.EDITABLE)
    }

    private var addNumber: Int = 0
    //ランダムな画像を表示させるための処理
    private fun randomImage() {
        val typedArray = resources.obtainTypedArray(R.array.randomnumber)
        val rand = Math.floor(Math.random() * 10).toInt()
        addNumber = rand
        val drawable = typedArray.getDrawable(rand)
        randompath.setImageDrawable(drawable)
    }

    //passwordの桁ごとの値を求める処理
    private fun inputNumberCalc(calcNum: Int, addNum: Int): Int {
        val x = calcNum - addNum
        return if (x >= 0)
            x
        else
            10 + x
    }
}
