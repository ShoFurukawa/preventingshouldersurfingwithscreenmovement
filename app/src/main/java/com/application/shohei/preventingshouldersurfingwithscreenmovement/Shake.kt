package com.application.shohei.preventingshouldersurfingwithscreenmovement

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.Drawable
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add_pin.*

class Shake : AppCompatActivity(), SensorEventListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shake)
        val sTime = System.currentTimeMillis()
        //画面が回転しないようにする
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        title = ("認証")
        //intentに格納されたデータを取り出す(onCreateの中に書かないと機能しない)
        val password = intent.getStringExtra("password")
        val direction = intent.getStringExtra("direction")

        //EditTextでキーボード入力が出ないようにした
        editText.keyListener = null

        //editTextの幅を設定(pixel)
        editText.width = 200

        //addTextの非表示化
        addText.visibility = View.GONE


        //数字ごとの処理
        zero.setOnClickListener {
            addStr(inputNumberCalc(0, addNumber).toString())
            //imageData = randomImage()
            imageData = randomImage(0, direction)
        }
        one.setOnClickListener {
            addStr(inputNumberCalc(1, addNumber).toString())
            // addStr("1")
            // imageData = randomImage()
            imageData = randomImage(1, direction)
        }
        two.setOnClickListener {
            addStr(inputNumberCalc(2, addNumber).toString())
            //imageData = randomImage()
            imageData = randomImage(2, direction)
        }
        three.setOnClickListener {
            addStr(inputNumberCalc(3, addNumber).toString())
            //imageData = randomImage()
            imageData = randomImage(3, direction)
        }
        four.setOnClickListener {
            addStr(inputNumberCalc(4, addNumber).toString())
            //imageData = randomImage()
            imageData = randomImage(4, direction)
        }
        five.setOnClickListener {
            addStr(inputNumberCalc(5, addNumber).toString())
            //imageData = randomImage()
            imageData = randomImage(5, direction)
        }
        six.setOnClickListener {
            addStr(inputNumberCalc(6, addNumber).toString())
            //imageData = randomImage()
            imageData = randomImage(6, direction)
        }
        seven.setOnClickListener {
            addStr(inputNumberCalc(7, addNumber).toString())
            //imageData = randomImage()
            imageData = randomImage(7, direction)
        }
        eight.setOnClickListener {
            addStr(inputNumberCalc(8, addNumber).toString())
            //imageData = randomImage()
            imageData = randomImage(8, direction)
        }
        nine.setOnClickListener {
            addStr(inputNumberCalc(9, addNumber).toString())
            //imageData = randomImage()
            imageData = randomImage(9, direction)
        }
        //数字の削除処理
        backspace.setOnClickListener { deleteStr(direction) }
        ok.setOnClickListener { onOkButtonTapped(password, sTime) }
        //imageData = randomImage()
        imageData = randomImage(0, direction)
        randompath.setImageDrawable(imageData)
    }

    override fun onResume() {
        super.onResume()
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_FASTEST)

    }

    override fun onPause() {
        super.onPause()
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    private var imageData: Drawable? = null

    /*private var nBeforeTime: Long = 0L
    private var nBeforeX: Float = 0F
    private var nBeforeY: Float = 0F
    private var nBeforeZ: Float = 0F
private var n=0*/
    var maxX = 0F
    var maxY = 0F

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return

        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val direction = intent.getStringExtra("direction")

            when (direction) {
                "x" -> {
                    if ((20 < Math.abs(event.values[0]) && Math.abs(event.values[0]) < 50))
                    //if ((-50 < event.values[2] && event.values[2] < -25))
                        randompath.setImageDrawable(imageData)
                    else randompath.setImageDrawable(null)
                }
                "y" -> {
                    if ((20 < Math.abs(event.values[1]) && Math.abs(event.values[1]) < 50))
                    // if ((-50 < event.values[2] && event.values[2] < -30))
                        randompath.setImageDrawable(imageData)
                    else randompath.setImageDrawable(null)
                }
                "z" -> {
                    if ((-50 < event.values[2] && event.values[2] < -15))
                        randompath.setImageDrawable(imageData)
                    else randompath.setImageDrawable(null)
                }
            }

        }
    }

    //数字を押したときの処理
    private fun addStr(str: String) {
        // Editableインスタンス取得
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        val textLength = editable.length
        editable.insert(textLength, str)
        // TextViewにセットする
        editText.setText(editable, TextView.BufferType.EDITABLE)

        // Editableインスタンス取得
        val editableAdd = Editable.Factory.getInstance().newEditable(addText.text)
        val addTextLength = editableAdd.length
        editableAdd.insert(addTextLength, addNumber.toString())
        // TextViewにセットする
        addText.setText(editableAdd, TextView.BufferType.EDITABLE)
    }

    //EditTextの一番後ろの数字を削除
    private fun deleteStr(direction: String) {
        // Editableインスタンス取得
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        // ボタンを押すごとに先頭1文字を削除
        val textLength = editable.length
        if (textLength > 0) {
            editable.delete(textLength - 1, textLength)
        }
        // TextViewにセットする
        editText.setText(editable, TextView.BufferType.EDITABLE)

        // Editableインスタンス取得
        val editableAdd = Editable.Factory.getInstance().newEditable(addText.text)
        // ボタンを押すごとに先頭1文字を削除
        val addTextLength = editableAdd.length
        if (addTextLength > 0) {
            editableAdd.delete(addTextLength - 1, addTextLength)
        }
        // TextViewにセットする
        addText.setText(editableAdd, TextView.BufferType.EDITABLE)

        //imageData = randomImage()
        imageData = randomImage(0, direction)
    }

    //OKボタンがタップされた時の処理
    private fun onOkButtonTapped(password: String, sTime: Long) {
        val dTime = System.currentTimeMillis() - sTime
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        val textLength = editable.length
        if (textLength != 4) {
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

            intent.putExtra("dTime", dTime)
            intent.putExtra("addNum", addText.text.toString())
            startActivity(intent)
        }
    }

    private var addNumber: Int = 0
    //var drawable:drawable=
//ランダムな画像を表示させるための処理
    //private fun randomImage(): Drawable {
    private fun randomImage(int: Int, direction: String): Drawable {
        //val typedArray = resources.obtainTypedArray(R.array.randomnumber)
        //val typedArray = resources.obtainTypedArray(R.array.segmentnumber)
        //var typedArray = resources.obtainTypedArray(R.array.clearnumber_70)
        //var typedArray = resources.obtainTypedArray(R.array.clearnumber_80)
        //val typedArray = resources.obtainTypedArray(R.array.colornumber)
        //val typedArray = resources.obtainTypedArray(R.array.greenc3number)
        //val typedArray = resources.obtainTypedArray(R.array.greenyellownumber)
        var typedArray = resources.obtainTypedArray(R.array.randomnumber)
        when (direction) {
            "x" -> {
                typedArray = resources.obtainTypedArray(R.array.greenc3number)
                //typedArray = resources.obtainTypedArray(R.array.clearnumber_70)
            }
            "y" -> {
                //typedArray = resources.obtainTypedArray(R.array.greenyellownumber)
                typedArray = resources.obtainTypedArray(R.array.greenc3number)
            }
            "z" -> {
                typedArray = resources.obtainTypedArray(R.array.greenyellownumber)
            }
        }


        val rand = Math.floor(Math.random() * 10).toInt()
        addNumber = rand
        val drawable = typedArray.getDrawable(rand)
        return drawable
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
