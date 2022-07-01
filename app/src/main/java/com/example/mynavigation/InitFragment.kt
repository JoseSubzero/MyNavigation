package com.example.mynavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.mynavigation.databinding.FragmentInitBinding


class InitFragment : Fragment() {
    private var cont = 0
    private var _binding: FragmentInitBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInitBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvContadorFragInit.setOnClickListener {
            cont++
            binding.tvContadorFragInit.text = cont.toString()

        }

        binding.btnInitFrag1.setOnClickListener {
            val bundle = bundleOf("Contador" to cont.toString())
            view.findNavController().navigate(R.id.action_initFragment_to_firstFragment, bundle)
        }
        binding.btnInitFrag2.setOnClickListener {
            //Paso de argumentos CON safe args
            val cont = 32
            val action = InitFragmentDirections.actionInitFragmentToSecondFragment(cont)
            view.findNavController().navigate(action)
//            view.findNavController().navigate(R.id.action_initFragment_to_secondFragment, null)
        }

    }
}