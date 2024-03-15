package com.example.demo1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo1.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.calculate.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val amount = binding.costOfService.text.toString()
        val cost = amount.toDouble()

        val tipPersentage = when(binding.radioGroup.checkedRadioButtonId) {
            R.id.amazing -> 0.21
            R.id.good -> 0.16
            else -> 0.1
        }

        var tip = cost * tipPersentage
        tip = round(tip)

        binding.tipAmount.text = tip.toString()
    }
}