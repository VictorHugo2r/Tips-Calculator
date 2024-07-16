package com.victorhugo.layoutapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victorhugo.layoutapplication.databinding.ActivitySammuryBinding

class SammuryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySammuryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySammuryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val numPeople = intent.getIntExtra("numPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalAmount = intent.getFloatExtra("totalAmount", 0.0f)

        binding.tvPercentage.text = percentage.toString() + "%"
        binding.tvTotalAmount.text = totalAmount.toString()
        binding.tvTotalTable.text = totalTable.toString()
        binding.tvNumPeopleTable.text = numPeople.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
        }

    }
}