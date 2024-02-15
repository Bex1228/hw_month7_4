package com.example.hw_month7_4.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.hw_7month_1.databinding.ActivityMainBinding
import com.example.hw_month7_4.data.local.Statistic
import com.example.hw_month7_4.statistic.StatisticActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        binding.btnAdd.setOnClickListener {
            val data = Statistic(
                status = binding.spinner.selectedItem.toString(),
                difficulty = binding.difficultySpinner.selectedItem.toString(),
                mistakes = binding.etMistakes.text.toString(),
            )
            if (binding.etMistakes.text!!.isEmpty() && binding.etPoint.text!!.isEmpty()) {
                showToast("Ввeдите значения в поля")
            } else {
                viewModel.addStatistic(data).observe(this@MainActivity) {
                    if (it != -1L) {
                        showToast("Данные успешно добавились")
                    } else {
                        showToast("Данные не были добавлены")
                    }
                }
            }
        }

        binding.btnStatistics.setOnClickListener {
            val intent = Intent(this, StatisticActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}