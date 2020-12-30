package com.example.android4a.presentation.main;
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView;
import com.example.android4a.R
import com.example.android4a.domain.entity.Monster
import kotlinx.android.synthetic.main.user_row.view.*

class MonsterAdapter(private val monsters: List<Monster>) : RecyclerView.Adapter<MonsterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = monsters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = monsters[position]
        d("daniel", "phone number ${user.rarity}")
        holder.firstName.text = user.name
        holder.lastName.text = user.rarity
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val firstName: TextView = itemView.firstName
        val lastName: TextView = itemView.lastName

    }
}
