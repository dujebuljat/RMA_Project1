package org.unizd.rma.buljat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CharacterAdapter(private val context: Context, private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewCharacter: ImageView = itemView.findViewById(R.id.imageViewCharacter)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.textViewName.text = character.name
        //Picasso.get().load(character.image).into(holder.imageViewCharacter)
        Glide.with(context).load(character.image).into(holder.imageViewCharacter)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CharacterDetails::class.java)
            intent.putExtra("character", character)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}
