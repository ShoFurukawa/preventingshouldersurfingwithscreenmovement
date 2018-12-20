package com.application.shohei.preventingshouldersurfingwithscreenmovement

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        //画面が回転しないようにする
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        title = "結果"

        //string.xmlの中のリソースは数字として扱われる
        val result = intent.getIntExtra("result", 0)
        //Toast.makeText(this, result, Toast.LENGTH_LONG).show()
        when (result) {
            R.string.result_success -> {
                resultLabel.setText(R.string.result_success)
            }
            R.string.result_failed -> {
                resultLabel.setText(R.string.result_failed)
            }
        }
    }
}
