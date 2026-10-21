package com.example.project_raihan.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.project_raihan.DetailActivity
import com.example.project_raihan.project3tic.LoginActivity
import com.example.project_raihan.R
import com.example.project_raihan.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireContext().getSharedPreferences("OceanCarePrefs", MODE_PRIVATE)
        val nama = sharedPref.getString("userEmail", "Pengguna OceanCare") ?: "Pengguna OceanCare"

        binding.timpanama.text = nama

        binding.btndetail.setOnClickListener {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)
        }

        binding.btnToLima.setOnClickListener {
            Toast.makeText(requireContext(), "Fitur Edukasi & Konservasi Laut OceanCare", Toast.LENGTH_SHORT).show()
        }

        binding.btnEnam.setOnClickListener {
            Toast.makeText(requireContext(), "Fitur Ensiklopedia Biota Laut", Toast.LENGTH_SHORT).show()
        }

        binding.btnsnack.setOnClickListener {
            Snackbar.make(binding.root, "Selamat datang di OceanCare - Jaga Laut, Jaga Masa Depan", Snackbar.LENGTH_SHORT)
                .setAction("Detail") {
                    startActivity(Intent(requireContext(), DetailActivity::class.java))
                }
                .show()
        }

        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Tentang OceanCare")
                .setMessage("Aplikasi mobile berbasis edukasi dan konservasi laut untuk menumbuhkan kepedulian terhadap ekosistem perairan.")
                .setPositiveButton("Tutup") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.btnLogOut.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar dari akun?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", false)
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
