package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    private var shoe: Shoe = Shoe("", 0.0, "", "")


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_shoe_detail, container, false)
        binding.shoe = shoe



        binding.saveButton.setOnClickListener { view ->
            viewModel.addShoe(shoe)
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return binding.root
    }


}