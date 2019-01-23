package com.application.shohei.preventingshouldersurfingwithscreenmovement

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mode_select.*

class ModeSelect : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_select)
        //画面が回転しないようにする
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        title = ("モード選択")
        val password = intent.getStringExtra("password")
        //Toast.makeText(this,password , Toast.LENGTH_SHORT).show()

        pinbutton.setOnClickListener { onPinButtonTapped(password) }
        addpinbutton.setOnClickListener { onAddPinButtonTapped(password) }
        shakepinbutton.setOnClickListener { onShakePinButtonTapped(password) }

    }

    fun onPinButtonTapped(password: String) {
        val intent = Intent(this, Pin::class.java)
        intent.putExtra("password", password)
        startActivity(intent)
    }

    fun onAddPinButtonTapped(password: String) {
        val intent = Intent(this, AddPin::class.java)
        intent.putExtra("password", password)
        startActivity(intent)
    }

    fun onShakePinButtonTapped(password: String) {
        val intent = Intent(this, Direction::class.java)
        intent.putExtra("password", password)

        startActivity(intent)
    }
}
