package com.example.project_raihan.Home.pertemuan_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.project_raihan.databinding.FragmentDuaBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DuaFragment : Fragment() {
    private var _binding: FragmentDuaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDuaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAction2.setOnClickListener {
            Toast.makeText(requireContext(), "Fragment 2: Penyu Hijau berstatus Terancam Punah (Endangered)", Toast.LENGTH_SHORT).show()
        }

        binding.btnDialog2.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Edukasi Fragment 2")
                .setMessage("Penyu sering mengira kantong plastik sebagai ubur-ubur. Kurangi penggunaan plastik sekali pakai!")
                .setPositiveButton("Paham") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
