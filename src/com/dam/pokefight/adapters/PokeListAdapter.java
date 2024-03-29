package com.dam.pokefight.adapters;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dam.pokefight.R;
import com.dam.pokefight.dao.Pokemon;

public class PokeListAdapter extends ArrayAdapter<Pokemon> {
	Typeface tf;

	public PokeListAdapter(Context context, int resource,
			List<Pokemon> pokemones, Typeface tf) {
		super(context, resource, pokemones);
		this.tf = tf;
	}

	public PokeListAdapter(Context context, int resource) {
		super(context, resource);
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (convertView == null) {
			LayoutInflater vi = LayoutInflater.from(getContext());
			v = vi.inflate(R.layout.pokemon_list, null);
		}
		Pokemon p = getItem(position);
		LinearLayout layoutHide = 
				(LinearLayout) v.findViewById(R.id.linearLayoutHide);
		if (p != null) {
			TextView text = (TextView) v.findViewById(R.id.txtListItem);
			TextView textAttack = (TextView) v
					.findViewById(R.id.txtListItemAttack);
			TextView textDefense = (TextView) v
					.findViewById(R.id.txtListItemDefense);
			ImageView image = (ImageView) v.findViewById(R.id.imageListItem);
			RatingBar attackRating = (RatingBar) v
					.findViewById(R.id.itemRatingAttack);
			RatingBar defenseRating = (RatingBar) v
					.findViewById(R.id.itemRatingDefense);
			LinearLayout linearLayoutHide = (LinearLayout)v.findViewById(R.id.linearLayoutHide);
			image.setImageResource(p.getImg());
			text.setText(p.getNombre());
			text.setTypeface(tf);
			attackRating.setRating((Float) (p.getAtaque() / 20F));
			defenseRating.setRating((Float) (p.getDefensa() / 20F));
			textAttack.setTypeface(tf);
			textDefense.setTypeface(tf);
			if(getContext()
					.getResources()
					.getConfiguration()
					.orientation==Configuration.ORIENTATION_LANDSCAPE){
				linearLayoutHide.setVisibility(View.GONE);
			}else{
				linearLayoutHide.setVisibility(View.VISIBLE);
			}

		}
		
		return v;
	}

}
