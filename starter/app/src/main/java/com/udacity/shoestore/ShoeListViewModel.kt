package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _listOfShoe = MutableLiveData<MutableList<Shoe>>()
    val listOfShoe : LiveData<MutableList<Shoe>>
        get() = _listOfShoe

    init {
        buildList()
        _listOfShoe.value = shoeList
        Log.i("ShoeListViewModel", "ShoeListViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeListViewModel", "ShoeListViewModel destroyed")
    }

    lateinit var shoeList : MutableList<Shoe>
    private fun buildList() {
        shoeList = mutableListOf(
            Shoe("Air Force 1", 34.0, "Nike", "Best shoe", mutableListOf("www.image.com")),
            Shoe("Air Force 2", 34.0, "Nike", "Best shoe", mutableListOf("www.image.com")),
            Shoe("Air Force 3", 34.0, "Nike", "Best shoe", mutableListOf("www.image.com")),
            Shoe("Air Force 4", 34.0, "Nike", "Best shoe", mutableListOf("www.image.com")),
            Shoe("Air Force 5", 34.0, "Nike", "Best shoe", mutableListOf("www.image.com"))
        )

    }



}