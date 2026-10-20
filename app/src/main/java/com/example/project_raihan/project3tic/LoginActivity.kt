package com.example.project_raihan.project3tic

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_raihan.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize SharedPreferences for login session management
        sharedPreferences = getSharedPreferences("OceanCarePrefs", MODE_PRIVATE)

        binding.btnlogin.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            // Pengecekan Username/Email dan Password
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan Kata Sandi tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email == "admin@oceancare.com" && password == "123456" || (email.isNotEmpty() && password.length >= 6)) {
                // Autentikasi berhasil: Simpan status isLogin = true ke SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("userEmail", email)
                editor.apply()

                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()

                // Intent dari Halaman Login ke BaseActivity (Fragment Container)
                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email atau Kata Sandi salah! (Gunakan minimal 6 karakter)", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
