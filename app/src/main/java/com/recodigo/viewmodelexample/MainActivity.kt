package com.recodigo.viewmodelexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = application.getSharedPreferences("preferences", Context.MODE_PRIVATE)

        val mainViewModelFactory = MainViewModelFactory(sharedPreferences)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        btnRoll.setOnClickListener { mainViewModel.onBtnRollPressed() }

        mainViewModel.luckyNumber.observe(this, Observer {
            tvLuckyNumber.text = it
        })
    }

}