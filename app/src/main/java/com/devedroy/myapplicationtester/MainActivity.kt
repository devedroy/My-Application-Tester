package com.devedroy.myapplicationtester

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.devedroy.myapplicationtester.databinding.ActivityMainBinding
import com.devedroy.qrbarcode.BarCodeScannerActivity
import com.devedroy.qrbarcode.BarcodeConstants
import com.devedroy.qrbarcode.BarcodeView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = result.data
                    val receivedData = data?.getStringExtra(BarcodeConstants.RECEIVE_DATA)
                    binding.tvLabel.text = receivedData.toString()
                }
            }
        setData()
    }

    private fun setData() {
        binding.btnScan.setOnClickListener {
            val data =
                BarcodeView.Builder().setTitle("Mera Title").setDescription("Mera Description")
                    .setBackgroundColor(
                        Color.parseColor("#FFC0CB")
                    ).build()

            val intent = Intent(this, BarCodeScannerActivity::class.java)
            intent.putExtra(BarcodeConstants.SEND_DATA, data)
            activityResultLauncher.launch(intent)
        }
    }
}