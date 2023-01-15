package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculator.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculator) {
            calculator()
        }
    }

    fun validator(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }   

    @SuppressLint("SetTextI18n")
    private fun calculator() {
        if (validator()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy

            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue).toString()}"

        } else {
            binding.textTotalValue.text = "R$ 0"
            Toast.makeText(this, R.string.fill_all_fieds, Toast.LENGTH_SHORT).show()
        }
    }
}