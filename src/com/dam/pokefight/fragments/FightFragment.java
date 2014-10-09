package com.dam.pokefight.fragments;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dam.pokefight.R;
import com.dam.pokefight.activities.FightActivity;
import com.dam.pokefight.dao.Pokemon;

public class FightFragment extends Fragment {
	ProgressBar userProgress;
	ProgressBar oponentProgress;
	TextView txtNombreUsuario;
	TextView txtNombreOponente;
	TextView txtAttackLblUser;
	TextView txtDefenseLblUser;
	TextView txtAttackLblOponent;
	TextView txtDefenseLblOponent;
	TextView txtAttackUser;
	TextView txtDefenseUser;
	TextView txtAttackOponent;
	TextView txtDefenseOponent;
	ImageView imgPokemonUser;
	ImageView imgPokemonOponent;
	Button fightButton;

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getActivity() instanceof FightActivity) {
			/*
			 * FightActivity fight = (FightActivity)getActivity(); Pokemon
			 * pokemonUsuario = fight.getPokemonUsuario(); Pokemon
			 * pokemonOponente = fight.getPokemonOponente();
			 * generaVista(pokemonUsuario, pokemonOponente);
			 */
			generaVista(((FightActivity) getActivity()).getPokemonUsuario(),
					((FightActivity) getActivity()).getPokemonOponente());
		}
	}

	public void generaVista(Pokemon u, Pokemon o) {

		userProgress.getProgressDrawable().setColorFilter(Color.GREEN,
				Mode.SRC_IN);
		oponentProgress.getProgressDrawable().setColorFilter(Color.GREEN,
				Mode.SRC_IN);
		Typeface pokemonFont = Typeface.createFromAsset(getActivity()
				.getAssets(), "fonts/pokemonsolid.ttf");

		fightButton.setTypeface(pokemonFont);
		imgPokemonUser.setImageResource(u.getImg());
		imgPokemonOponent.setImageResource(o.getImg());
		txtAttackLblUser.setTypeface(pokemonFont);
		txtDefenseLblUser.setTypeface(pokemonFont);
		txtAttackLblOponent.setTypeface(pokemonFont);
		txtDefenseLblOponent.setTypeface(pokemonFont);
		txtNombreUsuario.setTypeface(pokemonFont);
		txtNombreOponente.setTypeface(pokemonFont);
		txtNombreUsuario.setText(u.getNombre());
		txtNombreOponente.setText(o.getNombre());
		txtAttackUser.setTypeface(pokemonFont);
		txtDefenseUser.setTypeface(pokemonFont);
		txtAttackOponent.setTypeface(pokemonFont);
		txtDefenseOponent.setTypeface(pokemonFont);
		txtAttackUser.setText(u.getAtaque() + "");
		txtDefenseUser.setText(u.getDefensa() + "");
		txtAttackOponent.setText(o.getAtaque() + "");
		txtDefenseOponent.setText(o.getDefensa() + "");
		/* BOrrar */
		userProgress.setProgress(100);
		oponentProgress.setProgress(50);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_fight, container, false);
		userProgress = (ProgressBar) v.findViewById(R.id.progressBarUser);
		oponentProgress = (ProgressBar) v.findViewById(R.id.progressBarOponent);
		txtNombreUsuario = (TextView) v.findViewById(R.id.txtNombreUsuario);
		txtNombreOponente = (TextView) v.findViewById(R.id.txtNombreOponente);
		txtAttackLblUser = (TextView) v.findViewById(R.id.txtAttackLblUser);
		txtDefenseLblUser = (TextView) v.findViewById(R.id.txtDefenseLblUser);
		txtAttackLblOponent = (TextView) v
				.findViewById(R.id.txtAttackLblOponent);
		txtDefenseLblOponent = (TextView) v
				.findViewById(R.id.txtDefenseLblOponent);
		txtAttackUser = (TextView) v.findViewById(R.id.txtAttackUser);
		txtDefenseUser = (TextView) v.findViewById(R.id.txtDefenseUser);
		txtAttackOponent = (TextView) v.findViewById(R.id.txtAttackOponent);
		txtDefenseOponent = (TextView) v.findViewById(R.id.txtDefenseOponent);
		imgPokemonUser = (ImageView) v.findViewById(R.id.imgPokemonUser);
		imgPokemonOponent = (ImageView) v.findViewById(R.id.imgPokemonOponent);
		fightButton = (Button) v.findViewById(R.id.fightButton);
		return v;
	}

}
