package com.victorhugo.layoutapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.core.text.set
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.victorhugo.layoutapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnDone.setOnClickListener {
            val totaltabletemp = binding.tieTotal.text
            val numPeopleTemp = binding.tieNumPeople.text
            val percentageTemp = binding.tiePercentage.text

            if (totaltabletemp?.isEmpty() == true ||
                numPeopleTemp?.isEmpty() == true ||
                percentageTemp?. isEmpty() == true
            ) {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val totalTable: Float = binding.tieTotal.text.toString().toFloat()
                val nPeople: Int = numPeopleTemp.toString().toInt()
                val percentage: Int = percentageTemp.toString().toInt()

                val totaltemp = totalTable / nPeople
                val tips = totaltemp * percentage / 100
                val totalwithtips = totaltemp + tips

                val intent = Intent(this, SammuryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("numPeople", nPeople)
                    putExtra("percentage", percentage)
                    putExtra("totalAmount", totalwithtips)
                }
                clean()
                startActivity(intent)
            }
        }

        binding.btnClean.setOnClickListener {
            clean()
        }
    }

    private fun clean() {
        binding.tieTotal.setText("")
        binding.tiePercentage.setText("")
        binding.tieNumPeople.setText("")

    }
}
