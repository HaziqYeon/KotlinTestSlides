package com.example.chron.kotlintestslides

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        println("Intent Data : "+intent.data)
        if (intent.data!=null)
        {
            txtVwData1.setText(intent.dataString)
        }

        println("Intent Extra : "+intent.getStringExtra("title"))
        if (intent.extras!=null)
        {
            txtVwTitle.setText(intent.getStringExtra("title"))
            txtVwData1.setText(intent.getStringArrayExtra("stuff")[0])
            txtVwData2.setText(intent.getStringArrayExtra("stuff")[1])
            txtVwData3.setText(intent.getStringArrayExtra("stuff")[2])
        }


    }
}
