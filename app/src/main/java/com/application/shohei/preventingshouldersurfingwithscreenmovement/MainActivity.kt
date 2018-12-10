package com.application.shohei.preventingshouldersurfingwithscreenmovement

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import android.text.Editable


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = ("認証")
        //intentに格納されたデータを取り出す(onCreateの中に書かないと機能しない)
        val password = intent.getStringExtra("password")

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
        ok.setOnClickListener { onOkButtonTapped(password) }
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

    //OKボタンがタップされた時の処理
    private fun onOkButtonTapped(password: String) {
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        val textlength = editable.length
        if (textlength != 4) {
            AlertDialog.Builder(this)
                    .setTitle("警告")
                    .setMessage("4桁のパスワードを入力してください")
                    .setPositiveButton("YES", null)
                    .show()
        } else {
            val intent = Intent(this, Result::class.java)
            //SetPasswordActivityのeditTextの内容を受け取る
            if (password == editText.text.toString()) {
                intent.putExtra("result", R.string.result_success)
            } else
                intent.putExtra("result", R.string.result_failed)
            startActivity(intent)
        }
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
