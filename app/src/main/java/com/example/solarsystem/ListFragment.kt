package com.example.solarsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment(R.layout.fragment_list), RecyclerViewInterface {

    private lateinit var planetModels: ArrayList<PlanetModel>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.mRecyclerView)
        setUpPlanetModels()

        val adapter = PlanetRecyclerViewAdapter(planetModels, this)
        recyclerView.adapter = adapter

    }

    private fun setUpPlanetModels() {
        planetModels = ArrayList()
        planetModels.add(PlanetModel("Sun", R.drawable.sun,"Our Sun is a 4.5 billion-year-old yellow dwarf star – a hot glowing ball of hydrogen and helium – at the center of our solar system. It's about 150 million kilometers (93 million miles) from Earth and it's our solar system's only star."))
        planetModels.add(PlanetModel("Mercury", R.drawable.mercury, "Mercury is the second densest planet, after Earth. It has a large metallic core with a radius of about 2,074 kilometers (1,289 miles), about 85% of the planet's radius. There is evidence that it is partly molten or liquid."))
        planetModels.add(PlanetModel("Venus", R.drawable.venus, "Venus is a bit smaller than Earth. It's 12,104 kilometers (7,521 miles) across, and Earth is 12,756 kilometers (7,926 miles). On Venus, the Sun would rise in the west and set in the east, because Venus spins backward compared to Earth. Except for Earth, Venus has by far the fewest impact craters of any rocky planet."))
        planetModels.add(PlanetModel("Earth", R.drawable.earth, "Our home planet Earth is a rocky, terrestrial planet. It has a solid and active surface with mountains, valleys, canyons, plains and so much more. Earth is special because it is an ocean planet. Water covers 70% of Earth's surface."))
        planetModels.add(PlanetModel("Moon", R.drawable.moon, "The Moon has a solid, rocky surface cratered and pitted from impacts by asteroids, meteorites, and comets. The Moon has a very thin and tenuous atmosphere called an exosphere. It is not breathable. The Moon has no moons."))
        planetModels.add(PlanetModel("Mars", R.drawable.mars, "It's dry, rocky, and bitter cold. The fourth planet from the Sun, Mars is one of Earth's two closest planetary neighbors (Venus is the other). Mars is one of the easiest planets to spot in the night sky – it looks like a bright red point of light."))
        planetModels.add(PlanetModel("Jupiter", R.drawable.jupiter, "Jupiter is the fifth planet from our Sun and is, by far, the largest planet in the solar system – more than twice as massive as all the other planets combined. Jupiter's stripes and swirls are actually cold, windy clouds of ammonia and water, floating in an atmosphere of hydrogen and helium."))
        planetModels.add(PlanetModel("Saturn", R.drawable.saturn, "Like fellow gas giant Jupiter, Saturn is a massive ball made mostly of hydrogen and helium. Saturn is not the only planet to have rings, but none are as spectacular or as complex as Saturn's. Saturn also has dozens of moons."))
        planetModels.add(PlanetModel("Uranus", R.drawable.uranus, "Uranus is one of two ice giants in the outer solar system (the other is Neptune). Most (80% or more) of the planet's mass is made up of a hot dense fluid of \"icy\" materials – water, methane, and ammonia – above a small rocky core. Near the core, it heats up to 4,982 degrees Celsius (9,000 degrees Fahrenheit)."))
        planetModels.add(PlanetModel("Neptune", R.drawable.neptune, "Neptune is one of two ice giants in the outer solar system (the other is Uranus). Most (80% or more) of the planet's mass is made up of a hot dense fluid of \"icy\" materials – water, methane, and ammonia – above a small, rocky core."))
        planetModels.add(PlanetModel("Pluto", R.drawable.pluto, "Pluto is a dwarf planet located in a distant region of our solar system beyond Neptune known as the Kuiper Belt. Pluto was long considered our ninth planet, but the International Astronomical Union reclassified Pluto as a dwarf planet in 2006."))
    }

    override fun onItemClicked(position: Int) {
        val action = ListFragmentDirections.actionListFragmentToDetailsFragment(planetModels[position])
        view?.let { Navigation.findNavController(it).navigate(action) }
    }

}