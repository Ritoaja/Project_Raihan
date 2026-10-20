package com.example.project_raihan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project_raihan.project3tic.BaseActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Redirect to BaseActivity hosting the Home, Message, and More fragments
        val intent = Intent(this, BaseActivity::class.java)
        startActivity(intent)
        finish()
    }
}
