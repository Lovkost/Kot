package com.example.kot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val names: List<PokemonResponse>):RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val pokemonNameTV = itemView.findViewById<TextView>(R.id.pokemonName)
        val pokemonImageView = itemView.findViewById<ImageView>(R.id.pokemonImageView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.pokemonNameTV.text = firstUpperCase(names[position].name)
        /*Picasso.get()
            .load()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(holder.pokemonImageView)*/
    }


    override fun getItemCount(): Int = names.size
    fun firstUpperCase(word: String?): String {
        return if (word == null || word.isEmpty()) "" else word.substring(0, 1)
            .uppercase() + word.substring(1) //или return word;
    }
}