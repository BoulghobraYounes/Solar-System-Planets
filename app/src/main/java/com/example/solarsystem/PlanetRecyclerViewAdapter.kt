package com.example.solarsystem

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanetRecyclerViewAdapter(
    private val data: ArrayList<PlanetModel>,
    private val recyclerViewInterface: RecyclerViewInterface
): RecyclerView.Adapter<PlanetRecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetRecyclerViewAdapter.MyViewHolder {
        return MyViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(data[position])
        holder.itemView.setOnClickListener {
            recyclerViewInterface.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
    ) {
        private val name: TextView = itemView.findViewById(R.id.textView)
        private val image: ImageView = itemView.findViewById(R.id.imageView)

        fun onBind(planetModel: PlanetModel) {
            name.text = planetModel.name
            image.setImageResource(planetModel.image)
        }
    }
}