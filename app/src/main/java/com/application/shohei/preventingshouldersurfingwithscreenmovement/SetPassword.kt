package com.application.shohei.preventingshouldersurfingwithscreenmovement

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class SetPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_password)
        //画面が回転しないようにする
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        title = ("パスワード設定")

        //EditTextでキーボード入力が出ないようにした
        editText.keyListener = null

        //editTextの幅を設定(pixel)
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
        //数字の削除処理
        backspace.setOnClickListener { deleteStr() }
        ok.setOnClickListener { onOkButtonTapped() }
    }

    //数字を押したときの処理
    private fun addStr(str: String) {
        // Editableインスタンス取得
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        val textLength = editable.length
        editable.insert(textLength, str)
        // TextViewにセットする
        editText.setText(editable, TextView.BufferType.EDITABLE)
    }

    //EditTextの一番後ろの数字を削除
    private fun deleteStr() {
        // Editableインスタンス取得
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        // ボタンを押すごとに先頭1文字を削除
        val textLength = editable.length
        if (textLength > 0) {
            editable.delete(textLength - 1, textLength)
        }
        // TextViewにセットする
        editText.setText(editable, TextView.BufferType.EDITABLE)
    }

    private fun onOkButtonTapped() {
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        val textLength = editable.length
        if (textLength != 4) {
            AlertDialog.Builder(this)
                    .setTitle("警告")
                    .setMessage("4桁のパスワードを入力してください")
                    .setPositiveButton("YES", null)
                    .show()
        } else {
            val intent = Intent(this, MainActivity::class.java)
            //editTextの内容をMainActivityに送る
            intent.putExtra("password", editText.text.toString())
            startActivity(intent)
        }
    }
}
