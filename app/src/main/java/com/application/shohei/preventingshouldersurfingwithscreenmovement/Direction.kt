package com.application.shohei.preventingshouldersurfingwithscreenmovement

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_direction.*


class Direction : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_direction)
        //画面が回転しないようにする
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        title = ("認証")
        //intentに格納されたデータを取り出す(onCreateの中に書かないと機能しない)
        val password = intent.getStringExtra("password")
        xbutton.setOnClickListener { onXButtonTapped(password) }
        ybutton.setOnClickListener { onYButtonTapped(password) }
        zbutton.setOnClickListener { onZButtonTapped(password) }
    }
    var direction =""
    fun onXButtonTapped(password: String) {
        val intent = Intent(this, Shake::class.java)
        intent.putExtra("password", password)
        direction="x"
        intent.putExtra("direction",direction)
        startActivity(intent)
    }

    fun onYButtonTapped(password: String) {
        val intent = Intent(this, Shake::class.java)
        intent.putExtra("password", password)
        direction="y"
        intent.putExtra("direction",direction)
        startActivity(intent)
    }

    fun onZButtonTapped(password: String) {
        val intent = Intent(this, Shake::class.java)
        intent.putExtra("password", password)
        direction="z"
        intent.putExtra("direction",direction)
        startActivity(intent)
    }
}
