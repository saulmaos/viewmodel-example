package com.recodigo.viewmodelexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by SAUL on 11/09/2020.
 */
class MainViewModel: ViewModel() {

    val luckyNumber: MutableLiveData<String> = MutableLiveData()

    fun onBtnRollPressed() {
        val randomNumber = Math.random()  // generates a random number between 0 and 1
        val randomNumberFrom0To100 = (randomNumber * 100).toInt()
        luckyNumber.value = randomNumberFrom0To100.toString()
    }

    // just put it to remind you that it exits
    override fun onCleared() {
        super.onCleared()
    }
}