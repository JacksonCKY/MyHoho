package com.example.myhoho

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //module-level variable
    private var like: Int = 0
    private var dislike: Int = 0

    //Declare an instance of the SharedPref
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialise the Shared Pref
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        imageViewLike.setOnClickListener {
            like++
            textViewLike.text = like.toString()
        }

        imageViewDislike.setOnClickListener{
            dislike++
            textViewDislike.text = dislike.toString()
        }

        Log.d("MainActivity", "OnCreate")
    }

    override fun onStart(){
        Log.d("MainActivity", "OnStart")
        super.onStart()
    }

    override fun onResume(){
        Log.d("MainActivity", "OnResume")
        //Retrieve the Shared Pref
        like = sharedPreferences.getInt(getString(R.string.like), 0)
        dislike = sharedPreferences.getInt(getString(R.string.dislike), 0)

        textViewLike.text = like.toString()
        textViewDislike.text = dislike.toString()
        super.onResume()
    }

    override fun onPause(){
        Log.d("MainActivity", "OnPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like), like)
            putInt(getString(R.string.dislike), dislike)
            apply() // or commit()
        }
        super.onPause()
    }

    override fun onStop(){
        Log.d("MainActivity", "OnStop")
        super.onStop()
    }

    override fun onDestroy(){
        Log.d("MainActivity", "OnDestroy")
        super.onDestroy()
    }
}
