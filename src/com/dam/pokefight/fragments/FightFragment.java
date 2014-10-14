package com.dam.pokefight.fragments;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.pokefight.R;
import com.dam.pokefight.activities.FightActivity;
import com.dam.pokefight.dao.Pokemon;

public class FightFragment extends Fragment implements OnClickListener {
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
	TextView txtVersus;
	ImageView imgPokemonUser;
	ImageView imgPokemonOponent;
	Button fightButton;
	Handler handler = new Handler();
	Pokemon u;
	Pokemon o;

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getActivity() instanceof FightActivity) {
			generaVista(((FightActivity) getActivity()).getPokemonUsuario(),
					((FightActivity) getActivity()).getPokemonOponente());
		}
	}

	public void generaVista(Pokemon u, Pokemon o) {
		this.o = o;
		this.u = u;
		txtNombreUsuario.setText(u.getNombre());
		txtNombreOponente.setText(o.getNombre());
		imgPokemonUser.setImageResource(u.getImg());
		imgPokemonOponent.setImageResource(o.getImg());
		txtAttackUser.setText(u.getAtaque() + "");
		txtDefenseUser.setText(u.getDefensa() + "");
		txtAttackOponent.setText(o.getAtaque() + "");
		txtDefenseOponent.setText(o.getDefensa() + "");
		userProgress.setProgress(u.getVida());
		oponentProgress.setProgress(u.getVida());
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
		txtVersus = (TextView) v.findViewById(R.id.txtVersus);
		imgPokemonUser = (ImageView) v.findViewById(R.id.imgPokemonUser);
		imgPokemonOponent = (ImageView) v.findViewById(R.id.imgPokemonOponent);
		fightButton = (Button) v.findViewById(R.id.fightButton);
		userProgress.getProgressDrawable().setColorFilter(Color.GREEN,
				Mode.SRC_IN);
		oponentProgress.getProgressDrawable().setColorFilter(Color.GREEN,
				Mode.SRC_IN);
		Typeface pokemonFont = Typeface.createFromAsset(getActivity()
				.getAssets(), "fonts/pokemonsolid.ttf");
		fightButton.setTypeface(pokemonFont);
		fightButton.setOnClickListener(this);
		txtAttackLblUser.setTypeface(pokemonFont);
		txtDefenseLblUser.setTypeface(pokemonFont);
		txtAttackLblOponent.setTypeface(pokemonFont);
		txtDefenseLblOponent.setTypeface(pokemonFont);
		txtNombreUsuario.setTypeface(pokemonFont);
		txtNombreOponente.setTypeface(pokemonFont);
		txtAttackUser.setTypeface(pokemonFont);
		txtDefenseUser.setTypeface(pokemonFont);
		txtAttackOponent.setTypeface(pokemonFont);
		txtDefenseOponent.setTypeface(pokemonFont);
		txtVersus.setTypeface(pokemonFont);

		return v;
	}

	@Override
	public void onClick(View v) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				//fightButton.setVisibility(View.GONE);
				int turno = 0;
				// Turno 0 = Pokemon Usuario
				// Turno 1 = Pokemon Oponente
				while (o.getVida() > 0 || u.getVida() > 0) {
					switch (turno) {
					case 0:
						handler.post(new Runnable() {
							public void run() {
								o.setVida(o.getVida()
										- (u.getAtaque() - o.getDefensa()));
								oponentProgress.setProgress(o.getVida());
								if (o.getVida() < 75 && o.getVida() >= 50) {
									o.setDefensa(o.getDefensa() - 5);
									txtDefenseOponent.setText(o.getDefensa()
											+ "");
								}
								if (o.getVida() < 50 && o.getVida() >= 25) {
									o.setDefensa(o.getDefensa() - 10);
									txtDefenseOponent.setText(o.getDefensa()
											+ "");
								}
								if (o.getVida() < 25 && o.getVida() > 0) {
									o.setDefensa(0);
									txtDefenseOponent.setText(o.getDefensa()
											+ "");
								}
							}
						});
						turno = 1;
						break;
					case 1:
						handler.post(new Runnable() {
							public void run() {
								u.setVida(u.getVida()
										- (o.getAtaque() - u.getDefensa()));
								userProgress.setProgress(u.getVida());
								if (u.getVida() < 75 && u.getVida() >= 50) {
									u.setDefensa(u.getDefensa() - 5);
									txtDefenseUser.setText(u.getDefensa() + "");
								}
								if (u.getVida() < 50 && u.getVida() >= 25) {
									u.setDefensa(u.getDefensa() - 10);
									txtDefenseUser.setText(u.getDefensa() + "");
								}
								if (u.getVida() < 25 && u.getVida() > 0) {
									u.setDefensa(0);
									txtDefenseUser.setText(u.getDefensa() + "");
								}
							}
						});
						turno = 0;
						break;
					}

				}
				/*fightButton.setVisibility(View.VISIBLE);
				if (u.getVida() > 0) {
					Toast.makeText(getActivity().getApplicationContext(),
							"El ganador es " + u.getNombre(), Toast.LENGTH_LONG)
							.show();
				} else {
					Toast.makeText(getActivity().getApplicationContext(),
							"El ganador es " + o.getNombre(), Toast.LENGTH_LONG)
							.show();
				}*/

			}
		}).start();
	}

}
