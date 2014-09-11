package com.its.pokeapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.its.pokeapp.adapters.PokeListAdapter;
import com.its.pokeapp.dao.Pokemon;

public class List_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		List<Pokemon> pokemones = new ArrayList<Pokemon>();
		pokemones.add(new Pokemon(1, "Bulbasaur", "Planta", R.drawable.bulbasaur, 100, 49, 49));
		pokemones.add(new Pokemon(2, "Charmander", "Fuego", R.drawable.charmander, 100, 62, 63));
		pokemones.add(new Pokemon(3, "Squirtle", "Agua", R.drawable.squirtle, 100, 65, 48));
		pokemones.add(new Pokemon(4, "Caterpie", "Bicho", R.drawable.caterpie, 100, 35, 30));
		pokemones.add(new Pokemon(5, "Pidgey", "Normal", R.drawable.pidgey, 100, 40, 45));
		pokemones.add(new Pokemon(6, "Ekans", "Veneno", R.drawable.ekans, 100, 44, 60));
		pokemones.add(new Pokemon(7, "Pikachu", "Eléctrico", R.drawable.pikachu, 100, 40, 55));
		pokemones.add(new Pokemon(8, "Nidoran", "Veneno", R.drawable.nidoran, 100, 40, 57));
		pokemones.add(new Pokemon(9, "Clefairy", "Hada", R.drawable.clefairy, 100, 48, 45));
		pokemones.add(new Pokemon(10, "Sandshrew", "Tierra", R.drawable.sandshrew, 100, 85, 75));
        ListView list = (ListView)findViewById(R.id.listPok);
		Typeface miPropiaTypeFace = Typeface.createFromAsset(getAssets(), "fonts/pokemonsolid.ttf");
		TextView txt_list = (TextView)findViewById(R.id.txt_list);
		txt_list.setTypeface(miPropiaTypeFace);
		PokeListAdapter adapter = new PokeListAdapter(this, R.layout.pokemon_list,pokemones,miPropiaTypeFace);
        list.setAdapter(adapter);
	}
}
