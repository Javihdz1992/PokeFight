package com.its.pokeapp.adapters;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.its.pokeapp.R;
import com.its.pokeapp.dao.Pokemon;

public class PokeListAdapter extends ArrayAdapter<Pokemon> {
	Typeface tf;
	public PokeListAdapter(Context context, int textViewResourceId) {
	    super(context, textViewResourceId);
	}

	public PokeListAdapter(Context context, int resource, List<Pokemon> items,Typeface tf) {
	    super(context, resource, items);
	    this.tf=tf;
	}
	
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

	    View v = convertView;

	    if (v == null) {

	        LayoutInflater vi;
	        vi = LayoutInflater.from(getContext());
	        v = vi.inflate(R.layout.pokemon_list,null);

	    }

	    Pokemon p = getItem(position);

	    if (p != null) {

	        TextView text = (TextView) v.findViewById(R.id.txtListItem);
	        ImageView image = (ImageView) v.findViewById(R.id.imageListItem);
	        text.setText(p.getNombre());
	        text.setTypeface(tf);
	        image.setImageResource(p.getImg());
	    }

	    return v;

	}
}
