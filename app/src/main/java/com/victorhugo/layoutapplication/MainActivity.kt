package com.victorhugo.layoutapplication

import android.annotation.SuppressLint
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

    //valor total da conta
    //numero de pessoas
    //porcentagem de gorjeta
    //10% , 15% ou 20%
    //calcular
    //limpar
    //Recuperar as Views do layout
    //Find view by id
    //ViewBinding

    //Recuperar os radio buttons
    //calculo de tips
    //mostrar resultado

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0
        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                percentage = 10
            }
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                percentage = 15
            }
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                percentage = 20
            }
        }


        binding.btnDone.setOnClickListener {
            val totaltabletemp = binding.tieTotal.text

            if (totaltabletemp?.isEmpty() == true
                ) {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos",Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val totalTable: Float = binding.tieTotal.text.toString().toFloat()
                val nPeople: Int = binding.tieNumPeople.text.toString().toInt()

                val totaltemp = totalTable / nPeople
                val tips = totaltemp * percentage / 100
                val totalwithtips = totaltemp + tips
                binding.tvResult.text = "Total with tips: $totalwithtips"
            }

            binding.btnClean.setOnClickListener {
                binding.tvResult.text = ""
                binding.tieTotal.setText("")
                binding.tieNumPeople.setText("")
                binding.rbOptionOne.isChecked = false
                binding.rbOptionTwo.isChecked = false
                binding.rbOptionThree.isChecked = false

            }
        }
    }
}