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
        //EditTextでキーボード入力が出ないようにした
        //val editText: EditText = findViewById(R.id.editText)
        editText.keyListener = null
        editText.width = 200

        //数字ごとの処理
        one.setOnClickListener { addStr("1") }
        two.setOnClickListener { addStr("2") }
        three.setOnClickListener { addStr("3") }
        four.setOnClickListener { addStr("4") }
        five.setOnClickListener { addStr("5") }
        six.setOnClickListener { addStr("6") }
        seven.setOnClickListener { addStr("7") }
        eight.setOnClickListener { addStr("8") }
        nine.setOnClickListener { addStr("9") }
        zero.setOnClickListener { addStr("0") }

    }

    //数字を押したときの処理
    private fun addStr(str: String) {
        // TextViewを取得
        //val textView = findViewById<View>(R.id.text) as TextView
        // Editableインスタンス取得
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        val textlength = editable.length
        editable.insert(textlength, str)
        // TextViewにセットする
        editText.setText(editable, TextView.BufferType.EDITABLE)
    }

}
