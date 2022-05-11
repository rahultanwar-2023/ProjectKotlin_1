package com.example.projectroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectroom.R
import com.example.projectroom.model.MyInfo

class MyInfoAdapter(
    var list: List<MyInfo>,
    val myInfoClickInterface: MyInfoClickInterface
) : RecyclerView.Adapter<MyInfoAdapter.MyInfoViewHolder>() {

    inner class MyInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.idName)
        val mother = itemView.findViewById<TextView>(R.id.idMotherName)
        val age = itemView.findViewById<TextView>(R.id.idAge)
        val delete = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    interface MyInfoClickInterface {
        fun onItemClick(myInfo: MyInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent, false)
        return MyInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyInfoViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.mother.text = list[position].mother
        holder.age.text = list[position].age.toString()
        holder.delete.setOnClickListener {
            myInfoClickInterface.onItemClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}