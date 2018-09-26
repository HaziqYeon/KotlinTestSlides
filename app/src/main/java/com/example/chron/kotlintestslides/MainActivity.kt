package com.example.chron.kotlintestslides

import android.app.Activity
import android.app.AlertDialog
import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val GET_TEXT_ID = 10
const val ACTIVITY_REQUEST_CREATE_FILE = 12

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        btnIntentNormal.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }

        btnIntentUri.setOnClickListener{
            val goUrl = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=GGBm9gTY2NU"))
            startActivity(goUrl)
        }

        btnIntentCall.setOnClickListener{
            val callNumber = Intent(Intent.ACTION_DIAL,Uri.parse("tel:0123456789"))
            startActivity(callNumber)
        }

        btnIntentSendData.setOnClickListener{
            val data = Intent(this,SecondActivity::class.java)
            data.setData(Uri.parse("https://www.youtube.com/watch?v=2W41M9fWf6I"))
            startActivity(data)
        }

        btnIntentSendExtra.setOnClickListener{
            val arr = arrayOf("Chicken","Fish","Beef")
            val  extra = Intent(this,SecondActivity::class.java)
            extra.putExtra("title","This is from sent Extra");
            extra.putExtra("stuff",arr)
            startActivity(extra)
        }

        btnIntentActResult.setOnClickListener{
            val itRes = Intent(this,ThirdActivity::class.java)
            startActivityForResult(itRes, GET_TEXT_ID)
        }

//        btnImplicitIntent.setOnClickListener{
//            val int = Intent(Intent.ACTION_CALL_BUTTON)
//            if(intent.resolveActivity(getPackageManager()) != null)
//            {
//                startActivity(intent)
//            }
//        }
//
//        btnImplicitCall.setOnClickListener{
//            val itCall = Intent(Intent.ACTION_CALL_BUTTON)
//            itCall.setData(Uri.parse("tel:0123456789"))
//            if (itCall.resolveActivity(getPackageManager()) != null)
//            {
//                startActivity(itCall)
//            }
//        }

        btnImplicitSearch.setOnClickListener{
            val itSearch = Intent(Intent.ACTION_WEB_SEARCH)
            val qry = edTxtSearch.text.trim().toString()
            itSearch.putExtra(SearchManager.QUERY,qry)
            if (itSearch.resolveActivity(getPackageManager()) != null)
            {
                startActivity(itSearch)
            }
        }

        btnImpIntTypeCat.setOnClickListener{
            val itType = Intent(Intent.ACTION_CREATE_DOCUMENT)
            itType.setType("application/pdf")
            itType.addCategory(Intent.CATEGORY_OPENABLE)
            if (itType.resolveActivity(getPackageManager()) != null)
            {
                startActivityForResult(itType,ACTIVITY_REQUEST_CREATE_FILE)
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( requestCode == GET_TEXT_ID )
        {
            if(resultCode == 10)
            {
                println("Data : "+ data?.getStringExtra("text"))
                val str = data?.getStringExtra("text")
//            txtVwFromActivity.setText(str)
                txtVwFromActivity.text = str
            }
            else
            {
                println("Data Didnt Get : "+data)
            }

        }
        else if( requestCode == ACTIVITY_REQUEST_CREATE_FILE )
        {
            println("Data : "+ data?.getStringExtra("text"))
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Data got from TYPE button")
            builder.setMessage(data?.dataString)
            builder.setPositiveButton("Yeet",{ dialogInterface: DialogInterface, i: Int ->
                println("Pressed Yeet in Alert Dialog")
            })
            builder.show()
        }
    }
}
