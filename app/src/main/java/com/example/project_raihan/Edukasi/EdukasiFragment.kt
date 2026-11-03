package com.example.project_raihan.Edukasi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.project_raihan.DetailActivity
import com.example.project_raihan.databinding.FragmentEdukasiBinding

class EdukasiFragment : Fragment() {
    private var _binding: FragmentEdukasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEdukasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardPlastik.setOnClickListener {
            Toast.makeText(requireContext(), "Membaca materi: Plastik Kecil, Dampak Besar", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        binding.tvSemuaMateri.setOnClickListener {
            Toast.makeText(requireContext(), "Menampilkan daftar semua materi edukasi", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        binding.cardKuisEdukasi.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Kuis Penjaga Laut 🛡️")
                .setMessage("Mulai kuis interaktif 5 soal untuk mendapatkan +50 XP?")
                .setPositiveButton("Mulai") { _, _ ->
                    Toast.makeText(requireContext(), "Kuis dimulai!", Toast.LENGTH_SHORT).show()
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
