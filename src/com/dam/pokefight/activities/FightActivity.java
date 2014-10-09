package com.dam.pokefight.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.dam.pokefight.R;
import com.dam.pokefight.dao.Pokemon;

;
public class FightActivity extends FragmentActivity {
	private Pokemon pokemonUsuario,pokemonOponente;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fight);
		pokemonUsuario = (Pokemon) getIntent().getSerializableExtra(
				ListActivity.TAG_USER);
		pokemonOponente = (Pokemon) getIntent().getSerializableExtra(
				ListActivity.TAG_OPPONENT);
	}
	public Pokemon getPokemonUsuario() {
		return pokemonUsuario;
	}
	public Pokemon getPokemonOponente() {
		return pokemonOponente;
	}
	
}
