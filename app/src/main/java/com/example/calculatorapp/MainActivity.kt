package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addSetOnClickListenerToBttn()

    }


    private fun addSetOnClickListenerToBttn() {
        var operator = Operator(binding)
        binding.oneBttn.setOnClickListener(operator)
        binding.zeroBttn.setOnClickListener(operator)
        binding.twoBttn.setOnClickListener(operator)
        binding.threeBttn.setOnClickListener(operator)
        binding.fourBttn.setOnClickListener(operator)
        binding.fiveBttn.setOnClickListener(operator)
        binding.sixBttn.setOnClickListener(operator)
        binding.evenBttn.setOnClickListener(operator)
        binding.eightBttn.setOnClickListener(operator)
        binding.nineBttn.setOnClickListener(operator)
        binding.cBttn.setOnClickListener(operator)
        binding.modBttn.setOnClickListener(operator)
        binding.minusBttn.setOnClickListener(operator)
        binding.PlusBttn.setOnClickListener(operator)
        binding.multiplyBttn.setOnClickListener(operator)
        binding.divisionBttn.setOnClickListener(operator)
        binding.changeOperatorBttn.setOnClickListener(operator)
        binding.equalsBttn.setOnClickListener(operator)
        binding.dotBttn.setOnClickListener(operator)
    }


}