package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding : FragmentWelcomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome, container, false)
        binding.instructionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_instructionFragment))
        return binding.root
    }


}