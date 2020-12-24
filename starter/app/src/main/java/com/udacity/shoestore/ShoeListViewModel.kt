package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _listOfShoe = MutableLiveData<MutableList<Shoe>>()
    val listOfShoe : LiveData<MutableList<Shoe>>
        get() = _listOfShoe

    init {
        initList()
        _listOfShoe.value = shoeList
    }


    lateinit var shoeList: MutableList<Shoe>
    private fun initList() {
        shoeList = mutableListOf()

    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
    }


}