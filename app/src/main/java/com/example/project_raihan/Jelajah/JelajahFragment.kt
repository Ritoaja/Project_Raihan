package com.example.project_raihan.Jelajah

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.example.project_raihan.DetailActivity
import com.example.project_raihan.databinding.FragmentJelajahBinding

class JelajahFragment : Fragment() {
    private var _binding: FragmentJelajahBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJelajahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.edtSearchJelajah.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val query = binding.edtSearchJelajah.text.toString().trim()
                if (query.isNotEmpty()) {
                    Toast.makeText(requireContext(), "Menjelajah hasil untuk: '$query'", Toast.LENGTH_SHORT).show()
                    val intent =Intent(requireContext(), DetailActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "Masukkan kata kunci ekosistem atau satwa", Toast.LENGTH_SHORT).show()
                }
                true
            } else {
                false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
