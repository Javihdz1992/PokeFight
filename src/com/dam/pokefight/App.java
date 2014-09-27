package com.dam.pokefight;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.util.Log;

import com.dam.pokefight.dao.DBAdapter;
import com.dam.pokefight.dao.Pokemon;

public class App extends Application {
	private DBAdapter dbAdapter;
	private List<Pokemon> pokemones = new ArrayList<Pokemon>();

	@Override
	public void onCreate() {
		super.onCreate();
		pokemones.add(new Pokemon(1, "Bulbasaur", "Planta",
				R.drawable.bulbasaur, 100, 49, 49));
		pokemones.add(new Pokemon(2, "Charmander", "Fuego",
				R.drawable.charmander, 100, 62, 63));
		pokemones.add(new Pokemon(3, "Squirtle", "Agua", R.drawable.squirtle,
				100, 65, 48));
		pokemones.add(new Pokemon(4, "Caterpie", "Bicho", R.drawable.caterpie,
				100, 35, 30));
		pokemones.add(new Pokemon(5, "Pidgey", "Normal", R.drawable.pidgey,
				100, 40, 45));
		pokemones.add(new Pokemon(6, "Ekans", "Veneno", R.drawable.ekans, 100,
				44, 60));
		pokemones.add(new Pokemon(7, "Pikachu", "Eléctrico",
				R.drawable.pikachu, 100, 40, 55));
		pokemones.add(new Pokemon(8, "Nidoran", "Veneno", R.drawable.nidoran,
				100, 40, 57));
		pokemones.add(new Pokemon(9, "Clefairy", "Hada", R.drawable.clefairy,
				100, 48, 45));
		pokemones.add(new Pokemon(10, "Sandshrew", "Tierra",
				R.drawable.sandshrew, 100, 85, 75));
		dbAdapter = new DBAdapter(this);
		for (Pokemon p : pokemones) {
			dbAdapter.insertPokemon(p);
		}
		Log.e("COUNT","TOTAL ="+dbAdapter.getCountPokemones());
	}

	public DBAdapter getAdapter() {
		return dbAdapter;
	}
}
