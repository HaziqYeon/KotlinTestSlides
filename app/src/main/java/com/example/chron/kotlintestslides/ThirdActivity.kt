package com.example.chron.kotlintestslides

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        btnSendTxt.setOnClickListener{
            if (!editText3.text.trim().isEmpty())
            {
                val txt = editText3.text.trim()
                val replyIntent = Intent()
                replyIntent.putExtra("text",txt.toString())
                setResult(10,replyIntent)
                finish()
            }
            else
            {
                val replyIntent = Intent()
                replyIntent.putExtra("text","Text Is Empty")
                setResult(10,replyIntent)
                finish()
            }

        }
    }


}
