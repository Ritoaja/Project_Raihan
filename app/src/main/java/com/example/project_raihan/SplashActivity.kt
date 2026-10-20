package com.example.project_raihan

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_raihan.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("OceanCarePrefs", MODE_PRIVATE)

        // Delay for 2 seconds then check login status
        Handler(Looper.getMainLooper()).postDelayed({
            val isLogin = sharedPreferences.getBoolean("isLogin", false)
            if (isLogin) {
                // If already logged in, go to MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // If not logged in, go to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 2000)
    }
}
