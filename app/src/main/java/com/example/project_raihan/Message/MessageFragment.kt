package com.example.project_raihan.Message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.project_raihan.R
import com.example.project_raihan.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Tim Konservasi", "Penyu hijau baru saja dilepasliarkan ke laut.", "https://i.pravatar.cc/150?img=1"),
        MessageModel("Edukasi Laut", "Baca artikel terbaru tentang terumbu karang.", "https://i.pravatar.cc/150?img=2"),
        MessageModel("Admin OceanCare", "Jangan lupa ikuti kuis harian hari ini!", "https://i.pravatar.cc/150?img=3"),
        MessageModel("Sahabat Biota", "Paus biru terlihat di perairan sumatera.", "https://i.pravatar.cc/150?img=4")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Pesan & Notifikasi"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
