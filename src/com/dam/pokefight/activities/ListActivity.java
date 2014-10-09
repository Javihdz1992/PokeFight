package com.dam.pokefight.activities;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.dam.pokefight.App;
import com.dam.pokefight.R;
import com.dam.pokefight.adapters.PokeListAdapter;
import com.dam.pokefight.dao.DBAdapter;
import com.dam.pokefight.dao.Pokemon;
import com.dam.pokefight.fragments.FightFragment;

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
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			Intent i = new Intent(getApplicationContext(), FightActivity.class);
			i.putExtra(TAG_USER, pokemonUsuario);
			i.putExtra(TAG_OPPONENT, pokemonOpponent);
			startActivity(i);
		} else {
			FragmentManager manager = getSupportFragmentManager();
			FightFragment fragment = (FightFragment) manager
					.findFragmentById(R.id.fragmentFight);
			fragment.generaVista(pokemonUsuario,pokemonOpponent);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if (item.getItemId() == R.id.action_share) {
			String msg = "Estoy jugando pokefight, te invito a descargarlo de Google Play!!!";
			String titulo = "Compartir Pokefight";
			Intent i = new Intent();
			i.setAction(Intent.ACTION_SEND);
			i.putExtra(Intent.EXTRA_TEXT, msg);
			i.setType("text/plain");
			startActivity(Intent.createChooser(i, titulo));
		}
		return true;
	}

}
