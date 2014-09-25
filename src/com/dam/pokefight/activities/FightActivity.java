package com.dam.pokefight.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.dam.pokefight.R;
import com.dam.pokefight.dao.Pokemon;
;
public class FightActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fight);
		Pokemon pokemonUsuario = (Pokemon) getIntent().getSerializableExtra(ListActivity.TAG_USER);
		Pokemon pokemonOponente = (Pokemon) getIntent().getSerializableExtra(ListActivity.TAG_OPPONENT);
		Toast.makeText(
				getApplicationContext(),
				pokemonUsuario.getNombre()+" VS "+pokemonOponente.getNombre(),
				Toast.LENGTH_LONG)
				.show();
	
	}

}
