package com.example.todos

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {

            override fun run() {

                    var intent= Intent(this@Splash_Screen,MainActivity::class.java)
                    startActivity(intent)
                    finish()
            }

        },1*500)


      //  spash()
    }

//    private fun spash() {
//
//            Thread.sleep(5000)
//            val i = Intent(this@Splash_Screen, MainActivity::class.java)
//            finish()
//            startActivity(i)
//        }

}