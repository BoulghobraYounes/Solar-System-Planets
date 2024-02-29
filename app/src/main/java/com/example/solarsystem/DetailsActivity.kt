package com.example.solarsystem

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val planetModel: PlanetModel? = intent.getParcelableExtra("planetModel")

        val image: ImageView = findViewById(R.id.ivPlanet)
        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvDescription: TextView = findViewById(R.id.tvDescription)

        tvTitle.text = planetModel?.name
        tvDescription.text = planetModel?.description
        image.setImageResource(planetModel!!.image)
    }

}