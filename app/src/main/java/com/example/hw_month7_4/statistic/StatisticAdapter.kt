package com.example.hw_month7_4.statistic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_7month_1.R
import com.example.hw_7month_1.databinding.ItemStatisticsBinding
import com.example.hw_month7_4.data.local.Statistic

class StatisticsAdapter(private val onItemLongClick: (statistic: Statistic) -> Unit) :
    RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {

    private val list = mutableListOf<Statistic>()

    fun addStatistics(models: List<Statistic>) {
        list.clear()
        list.addAll(models)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        val binding =
            ItemStatisticsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatisticsViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) =
        holder.bind(list[position])

    inner class StatisticsViewHolder(private val binding: ItemStatisticsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnLongClickListener {
                onItemLongClick(list[adapterPosition])
                true
            }
        }

        fun bind(statistic: Statistic) = with(binding) {
            tvStatusDetail.text = statistic.status?.replace("Результат: ", "")
            tvDifficultyDetail.text = statistic.difficulty?.replace("Сложность: ", "")
            tvMistakesDetail.text = statistic.mistakes
            imgIcon.setImageResource(
                if (statistic.status.equals("Результат: Победа")) R.drawable.img_like
                else R.drawable.img_dislike
            )
        }
    }
}