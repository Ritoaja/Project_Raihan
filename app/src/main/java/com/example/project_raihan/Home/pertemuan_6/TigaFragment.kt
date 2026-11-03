package com.example.project_raihan.Home.pertemuan_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.project_raihan.databinding.FragmentTigaBinding
import com.google.android.material.snackbar.Snackbar

class TigaFragment : Fragment() {
    private var _binding: FragmentTigaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit3.setOnClickListener {
            val komitmen = binding.etKomitmen.text.toString().trim()
            if (komitmen.isNotEmpty()) {
                Snackbar.make(binding.root, "Fragment 3: Komitmen tersimpan: \"$komitmen\"", Snackbar.LENGTH_LONG).show()
                binding.etKomitmen.text?.clear()
            } else {
                Toast.makeText(requireContext(), "Fragment 3: Harap isi komitmen Anda terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
