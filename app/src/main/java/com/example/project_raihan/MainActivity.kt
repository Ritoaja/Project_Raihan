package com.example.project_raihan

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_raihan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("OceanCarePrefs", MODE_PRIVATE)

        // Setup Toolbar
        setSupportActionBar(binding.toolbarMain)
        supportActionBar?.title = "OceanCare - Beranda"

        // Intent dari Halaman MainActivity ke halaman Detail (DetailActivity)
        binding.btnDetail.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        // Terapkan AlertDialog pada halaman MainActivity dengan tombol LogOut
        binding.btnLogout.setOnClickListener {
            showLogoutConfirmationDialog()
        }
    }

    private fun showLogoutConfirmationDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Konfirmasi Logout")
        alertDialogBuilder.setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
        
        // Tombol Ya: Ubah status isLogin menjadi false, lalu pindah ke LoginActivity
        alertDialogBuilder.setPositiveButton("Ya") { dialog, _ ->
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogin", false)
            editor.apply()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            dialog.dismiss()
        }

        // Tombol Tidak: Tetap berada di halaman MainActivity
        alertDialogBuilder.setNegativeButton("Tidak") { dialog, _ ->
            dialog.dismiss()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
