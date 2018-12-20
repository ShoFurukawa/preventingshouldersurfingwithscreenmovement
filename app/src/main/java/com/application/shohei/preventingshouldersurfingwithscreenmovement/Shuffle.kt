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
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class Shuffle : AppCompatActivity(), SensorEventListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shuffle)
        //画面が回転しないようにする
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        title = ("認証")
        //intentに格納されたデータを取り出す(onCreateの中に書かないと機能しない)
        //val password = intent.getStringExtra("password")

        //EditTextでキーボード入力が出ないようにした
        editText.keyListener = null

        //editTextの幅を設定(pixel)
        editText.width = 200


        //数字ごとの処理
        one.setOnClickListener {
            addStr(inputNumberCalc(1, addNumber).toString())
            // addStr("1")
            imageData = randomImage()
        }
        two.setOnClickListener {
            addStr(inputNumberCalc(2, addNumber).toString())
            imageData = randomImage()
        }
        three.setOnClickListener {
            addStr(inputNumberCalc(3, addNumber).toString())
            imageData = randomImage()
        }
        four.setOnClickListener {
            addStr(inputNumberCalc(4, addNumber).toString())
            imageData = randomImage()
        }
        five.setOnClickListener {
            addStr(inputNumberCalc(5, addNumber).toString())
            imageData = randomImage()
        }
        six.setOnClickListener {
            addStr(inputNumberCalc(6, addNumber).toString())
            imageData = randomImage()
        }
        seven.setOnClickListener {
            addStr(inputNumberCalc(7, addNumber).toString())
            imageData = randomImage()
        }
        eight.setOnClickListener {
            addStr(inputNumberCalc(8, addNumber).toString())
            imageData = randomImage()
        }
        nine.setOnClickListener {
            addStr(inputNumberCalc(9, addNumber).toString())
            imageData = randomImage()
        }
        zero.setOnClickListener {
            addStr(inputNumberCalc(0, addNumber).toString())
            imageData = randomImage()
        }
        //数字の削除処理
        backspace.setOnClickListener { deleteStr() }
        //ok.setOnClickListener { onOkButtonTapped(password) }
        imageData = randomImage()
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

            /*val nNowTime = System.currentTimeMillis()
            val nDiffTime = nNowTime - nBeforeTime
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            if (nDiffTime > 10 && (nBeforeTime != 0L)) {
                /* var x = Math.abs(event.values[0])
             var y = Math.abs(event.values[1])
             var z = Math.abs(event.values[2])*/
                val speed = (Math.abs(x - nBeforeX) + Math.abs(y - nBeforeY) ) / nDiffTime * 1000
               Toast.makeText(this, x.toString(), Toast.LENGTH_SHORT).show()
                if (Math.abs(x) > 20) {
                    randompath.setImageDrawable(imageData)
                    n++
                    Toast.makeText(this, n.toString(), Toast.LENGTH_SHORT).show()
                }
                else
                    randompath.setImageDrawable(null)
            }
            nBeforeTime = nNowTime
            nBeforeX = x
            nBeforeY = y
            nBeforeZ = z*/

            //x方向10~50
            //if ((10 < Math.abs(event.values[0]) && Math.abs(event.values[0]) < 50)) {

                //x方向20~50
                //if ((20 < Math.abs(event.values[0]) && Math.abs(event.values[0]) < 50)) {

                //x方向30~50
                //if ((30 < Math.abs(event.values[0]) && Math.abs(event.values[0]) < 50)) {

                //x方向40~50
                //if ((40 < Math.abs(event.values[0]) && Math.abs(event.values[0]) < 50)) {


                //y方向10~50
                //if ((10 < Math.abs(event.values[1]) && Math.abs(event.values[1]) < 50)) {

                //y方向20~50
                if ((20 < Math.abs(event.values[1]) && Math.abs(event.values[1]) < 50)) {

                //y方向30~50
                //if ((30 < Math.abs(event.values[1]) && Math.abs(event.values[1]) < 50)) {

                // y方向40~50
                //if ((40 < Math.abs(event.values[1]) && Math.abs(event.values[1]) < 50)) {


                //z方向10~50
                //if ((10 < Math.abs(event.values[2]) && Math.abs(event.values[2]) < 50)) {

                //z方向20~50
                   // if ((20 < Math.abs(event.values[2]) && Math.abs(event.values[2]) < 50)) {

                //z方向30~50
                //if ((30 < Math.abs(event.values[2]) && Math.abs(event.values[2]) < 50)) {

                //z方向40~50
                //if ((40 < Math.abs(event.values[2]) && Math.abs(event.values[2]) < 50)) {


                //x方向20~30,y方向30~40
                //if (event.values[2] < -100 || (20 < event.values[0] && event.values[0] < 30) || (-30 < event.values[0] && event.values[0] < -20) || (-40 < event.values[1]&& event.values[1]<-30)||(30 < event.values[1]&& event.values[1]<40)) {
                //    if ((20 < Math.abs(event.values[0]) && Math.abs(event.values[0]) < 30) || (30 < Math.abs(event.values[1]) && Math.abs(event.values[1]) < 40)) {

                //if(true){

                /* Log.d("Shuffle",
                         "x=${event.values[0].toString()}" +
                                 "y=${event.values[1].toString()}" +
                                 "z=${event.values[2].toString()}")*/
                if (event.values[0] > maxX)
                    maxX = event.values[0]
                if (event.values[1] > maxY)
                    maxY = event.values[1]
                Log.d("max", "x=${maxX}" + "y=${maxY}")
                randompath.setImageDrawable(imageData)
            } else {
                //resources(getResources)はリーソースを取り扱うクラス
                //getDrawableで指定した画像のDrawableインスタンスを取得
                //val drawable = ResourcesCompat.getDrawable(resources,R.drawable.ok,null)
                randompath.setImageDrawable(null)
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

    //OKボタンがタップされた時の処理
    private fun onOkButtonTapped(password: String) {
        val editable = Editable.Factory.getInstance().newEditable(editText.text)
        val textLength = editable.length
        if (textLength != 4) {
            AlertDialog.Builder(this)
                    .setTitle("警告")
                    .setMessage("4桁のパスワードを入力してください")
                    .setPositiveButton("YES", null)
                    .show()
        } else {
            /*   val intent = Intent(this, Result::class.java)
               //SetPasswordActivityのeditTextの内容を受け取る
               if (password == editText.text.toString()) {
                   intent.putExtra("result", R.string.result_success)
               } else
                   intent.putExtra("result", R.string.result_failed)
               startActivity(intent)*/
        }
    }

    private var addNumber: Int = 0
    //var drawable:drawable=
//ランダムな画像を表示させるための処理
    private fun randomImage(): Drawable {
        val typedArray = resources.obtainTypedArray(R.array.randomnumber)
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