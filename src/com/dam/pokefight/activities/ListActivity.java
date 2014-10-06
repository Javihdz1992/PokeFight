package com.dam.pokefight.activities;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.dam.pokefight.App;
import com.dam.pokefight.R;
import com.dam.pokefight.adapters.PokeListAdapter;
import com.dam.pokefight.dao.DBAdapter;
import com.dam.pokefight.dao.Pokemon;

public class ListActivity extends FragmentActivity implements
		OnItemClickListener {
	List<Pokemon> pokemones = new ArrayList<Pokemon>();
	private DBAdapter dbAdapter;
	public static final String TAG_USER = "USUARIO";
	public static final String TAG_OPPONENT = "OPONENTE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		dbAdapter = ((App) getApplicationContext()).getAdapter();
		pokemones = dbAdapter.getPokemones();
		Typeface miPropiaTypeFace = Typeface.createFromAsset(getAssets(),
				"fonts/pokemonsolid.ttf");
		PokeListAdapter adapter = new PokeListAdapter(getApplicationContext(),
				R.layout.pokemon_list, pokemones, miPropiaTypeFace);
		ListView listPok = (ListView) findViewById(R.id.listPok);
		listPok.setAdapter(adapter);
		listPok.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view,
			int position, long arg3) {
		Pokemon pokemonUsuario = (Pokemon) adapterView
				.getItemAtPosition(position);
		int indexRandom = (int) (Math.random() * 10);
		Pokemon pokemonOpponent = pokemones.get(indexRandom);
		Intent i = new Intent(getApplicationContext(), FightActivity.class);
		i.putExtra(TAG_USER, pokemonUsuario);
		i.putExtra(TAG_OPPONENT, pokemonOpponent);
		startActivity(i);
	}

}
