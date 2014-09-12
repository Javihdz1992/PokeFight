package com.dam.pokefight;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	ImageView logo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Typeface miPropiaTypeFace = Typeface.createFromAsset(getAssets(),
				"fonts/pokemonsolid.ttf");
		TextView msg1 = (TextView) findViewById(R.id.msg1);
		msg1.setTypeface(miPropiaTypeFace);
		logo = (ImageView)findViewById(R.id.logo);
		logo.setOnClickListener(this);
		startAnimation();
	}

	private void startAnimation() {
		Animation animacionLogo = AnimationUtils.loadAnimation(this,
				R.anim.animacion_logo);
		animacionLogo.reset();
		logo.clearAnimation();
		logo.startAnimation(animacionLogo);
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(getApplicationContext(),ListActivity.class);
		startActivity(i);
		finish();
	}

}
