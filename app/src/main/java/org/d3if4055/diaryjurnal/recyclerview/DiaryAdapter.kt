package org.d3if4055.diaryjurnal.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import org.d3if4055.diaryjurnal.R
import org.d3if4055.diaryjurnal.database.Diary
import org.d3if4055.diaryjurnal.databinding.RecyclerviewDiaryBinding
import org.d3if4055.diaryjurnal.utils.convertLongToDateString

class DiaryAdapter(private val diary: List<Diary>) : RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>() {
    var listener: RecyclerViewClickListener? = null

    inner class DiaryViewHolder(
        val recyclerviewDiaryBinding: RecyclerviewDiaryBinding
    ) : RecyclerView.ViewHolder(recyclerviewDiaryBinding.root)

    override fun getItemCount() = diary.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DiaryViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recyclerview_diary, parent, false)
    )

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        holder.recyclerviewDiaryBinding.tvDate.text = convertLongToDateString(diary[position].tanggal)
        holder.recyclerviewDiaryBinding.tvMessage.text = diary[position].message
        // set onclick untuk tiap listnya
        holder.recyclerviewDiaryBinding.listDiary.setOnClickListener {
            // panggil turunan method dari interface RecyclerViewClickListener
            listener?.onRecyclerViewItemClicked(it, diary[position])
        }
    }
}