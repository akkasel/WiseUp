package com.akka.wiseup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIMEOUT: Long = 500 // Duration in milliseconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Delay the navigation to the next activity
        Handler().postDelayed({
            // Start the main activity or any desired activity
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Close the splash screen activity
        }, SPLASH_TIMEOUT)
    }
}