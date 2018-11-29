package com.application.shohei.preventingshouldersurfingwithscreenmovement

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //EditTextでキーボード入力が出ないようにした
        val editText:EditText = findViewById(R.id.editText)
        editText.keyListener = null


    }
}
