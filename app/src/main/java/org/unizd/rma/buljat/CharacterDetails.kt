package org.unizd.rma.buljat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.bumptech.glide.Glide
import org.unizd.rma.buljat.databinding.ActivityCharacterDetailsBinding

class CharacterDetails : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val character = intent.getSerializableExtra("character") as Character
        displayCharacterDetails(character)




    }

    private fun displayCharacterDetails(character: org.unizd.rma.buljat.Character) {

        //  nameTextView.text = Html.fromHtml("<b>Name:</b> ${drinkX.strDrink}")
        Glide.with(this).load(character.image).into(binding.imageViewCharacter)
        binding.name.text = Html.fromHtml("<b>Name:</b> ${character.name}")
        binding.status.text = Html.fromHtml("<b>Status:</b> ${character.status}")
        binding.species.text = Html.fromHtml("<b>Species:</b> ${character.species}")
        binding.gender.text = Html.fromHtml("<b>Gender:</b> ${character.gender}")
        binding.created.text = Html.fromHtml("<b>Created:</b> ${character.created}")



    }
}