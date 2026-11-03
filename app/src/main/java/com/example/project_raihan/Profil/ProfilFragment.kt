package com.example.project_raihan.Profil

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.project_raihan.DetailActivity
import com.example.project_raihan.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvEditProfil.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka pengaturan Edit Profil", Toast.LENGTH_SHORT).show()
        }

        binding.tvMateri.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka Materi Tersimpan", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        binding.tvPengantar.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Pengantar Belajar 🔔")
                .setMessage("Pengingat belajar harian diaktifkan pukul 19:00 WIB.")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        binding.tvTentang.setOnClickListener {
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
