package com.example.project_raihan.Home.pertemuan_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.project_raihan.databinding.FragmentSatuBinding
import com.google.android.material.snackbar.Snackbar

class SatuFragment : Fragment() {
    private var _binding: FragmentSatuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSatuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAction1.setOnClickListener {
            Toast.makeText(requireContext(), "Fragment 1: Terumbu karang melindungi pesisir dari erosi!", Toast.LENGTH_SHORT).show()
        }

        binding.btnSnackbar1.setOnClickListener {
            Snackbar.make(binding.root, "Fragment 1: Mari jaga terumbu karang laut kita!", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
