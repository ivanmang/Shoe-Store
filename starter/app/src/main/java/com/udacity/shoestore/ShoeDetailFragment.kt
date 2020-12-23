package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail, container, false)


        binding.saveButton.setOnClickListener{ view ->
            val name = binding.editTextShoeName.text.toString()
            val company = binding.editTextTextCompanyName.text.toString()
            val size = binding.editTextShoeSize.text.toString().toDouble()
            val description = binding.editTextDescibe.text.toString()
            viewModel.addShoe(name, size, company, description)
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        binding.cancelButton.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return binding.root
    }


}