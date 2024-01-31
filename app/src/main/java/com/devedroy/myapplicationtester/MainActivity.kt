package com.devedroy.myapplicationtester

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devedroy.myapplicationtester.databinding.ActivityMainBinding
import com.devedroy.qrbarcode.TriggerBarcodeActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()

    }

    private fun setData() {
        binding.btnScan.setOnClickListener {
            startActivity(Intent(this, TriggerBarcodeActivity::class.java))
        }
    }


}