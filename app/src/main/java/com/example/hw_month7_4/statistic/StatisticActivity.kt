package com.example.hw_month7_4.statistic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.hw_7month_1.databinding.ActivityStatisticBinding
import com.example.hw_month7_4.App
import com.example.hw_month7_4.data.local.Statistic
import kotlinx.coroutines.launch

class StatisticActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStatisticBinding
    private val viewModel: StatisticViewModel by viewModels()
    private val adapter = StatisticsAdapter(this::onLongClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter

        viewModel.getStatistic().observe(this) { statistic ->
            adapter.addStatistics(statistic)
        }
    }

    private fun onLongClick(position: Statistic): Boolean {
        val alertDialogBuilder = AlertDialog.Builder(this)
            .setMessage("Вы хотите удалить статистику?")
            .setPositiveButton("Да") { _, _ ->
                lifecycleScope.launch {
                    App.db.getDao().delete(position)
                    adapter.notifyDataSetChanged()
                }
            }
            .setNegativeButton("Нет") { _, _ ->
                dismissKeyboardShortcutsHelper()
            }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
        return true
    }
}