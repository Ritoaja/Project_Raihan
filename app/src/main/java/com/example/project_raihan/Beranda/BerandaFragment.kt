package com.example.project_raihan.Beranda

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.project_raihan.DetailActivity
import com.example.project_raihan.databinding.FragmentBerandaBinding

class BerandaFragment : Fragment() {
    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Search Action
        binding.edtSearchBeranda.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val query = binding.edtSearchBeranda.text.toString().trim()
                if (query.isNotEmpty()) {
                    Toast.makeText(requireContext(), "Mencari: '$query'", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(requireContext(), DetailActivity::class.java))
                } else {
                    Toast.makeText(requireContext(), "Masukkan kata kunci pencarian", Toast.LENGTH_SHORT).show()
                }
                true
            } else {
                false
            }
        }

        // Notification Click
        binding.ivNotification.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Notifikasi OceanCare")
                .setMessage("• Tantangan harian baru tersedia!\n• Lencana Penjelajah Laut Level 3 telah aktif.\n• Artikel baru: Menjaga Ekosistem Pesisir.")
                .setPositiveButton("Tutup") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        // Ensiklopedia Card Click
        binding.cardEnsiklopedia.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka Ensiklopedia Biota Laut", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        // Konservasi Card Click
        binding.cardKonservasi.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka Program Konservasi Laut", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        // Kuis Laut Card Click
        binding.cardKuis.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Kuis Interaktif Laut")
                .setMessage("Siap menguji pengetahuan tentang ekosistem perairan dan satwa laut?")
                .setPositiveButton("Mulai Kuis") { _, _ ->
                    Toast.makeText(requireContext(), "Kuis dimulai! (+50 XP)", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Nanti Saja") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        // Lihat Semua Click
        binding.tvLihatSemua.setOnClickListener {
            Toast.makeText(requireContext(), "Menampilkan semua sahabat laut", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        // Penyu Hijau Card Click
        binding.cardPenyu.setOnClickListener {
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        // Trivia Card Click
        binding.cardTrivia.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Tahukah Kamu? 💡")
                .setMessage("Padang lamun dan hutan mangrove adalah penyerap karbon alami yang sangat kuat untuk mencegah perubahan iklim.")
                .setPositiveButton("Menarik!") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        // Tantangan Hari Ini Click
        binding.cardTantangan.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Tantangan Harian ✨")
                .setMessage("Tantangan: 'Bawa tumbler, kurangi plastik sekali pakai' sedang aktif. Selesaikan untuk mendapat badge khusus!")
                .setPositiveButton("Selesai!") { _, _ ->
                    Toast.makeText(requireContext(), "Tantangan selesai! +20 XP", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Tutup") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
