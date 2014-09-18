package com.dam.pokefight;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dam.pokefight.dao.Pokemon;

public class ListActivity extends Activity implements OnItemClickListener{
	List<Pokemon> pokemones;
	public static final String TAG_USER = "USUARIO";
	public static final String TAG_OPPONENT = "OPONENTE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		pokemones = new ArrayList<Pokemon>();
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
		ArrayAdapter<Pokemon> adapter = new ArrayAdapter<Pokemon>(getApplicationContext(),android.R.layout.simple_list_item_1,pokemones);
		ListView listPok = (ListView)findViewById(R.id.listPok);
		listPok.setAdapter(adapter);
		listPok.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		Pokemon pokemonUsuario = (Pokemon)adapterView.getItemAtPosition(position);
		int indexRandom = (int) (Math.random() * 10);
		Pokemon pokemonOpponent = pokemones.get(indexRandom);
		Intent i = new Intent(getApplicationContext(),FightActivity.class);
		i.putExtra(TAG_USER, pokemonUsuario);
		i.putExtra(TAG_OPPONENT, pokemonOpponent);
		startActivity(i);
	}

}
