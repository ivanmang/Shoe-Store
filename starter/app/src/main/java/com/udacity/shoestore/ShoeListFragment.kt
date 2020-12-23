package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*
import kotlinx.android.synthetic.main.sample_shoe_view.view.*

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentShoeListBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list, container, false)
        //viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel

        viewModel.listOfShoe.observe(viewLifecycleOwner, Observer { newList ->
            newList.forEach { shoe ->
                val view: View = inflater.inflate(R.layout.sample_shoe_view, null, false)
                view.shoe_name.text = shoe.name
                view.shoe_company.text = shoe.company
                view.shoe_size.text = shoe.size.toString()
                view.description.text = shoe.description
                binding.shoeListLayout.addView(view)
            }

        })
        setHasOptionsMenu(true)
        binding.detailButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }



}