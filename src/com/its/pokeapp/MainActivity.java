package com.its.pokeapp;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Typeface miPropiaTypeFace = Typeface.createFromAsset(getAssets(), "fonts/pokemonsolid.ttf");
		TextView msg1 = (TextView)findViewById(R.id.msg1);
		msg1.setTypeface(miPropiaTypeFace);
		startAnimation();
	}

	private void startAnimation() {
		Animation animacionLogo = AnimationUtils.loadAnimation(this,
				R.anim.animacion_splash);
		animacionLogo.reset();
		ImageView logo = (ImageView) findViewById(R.id.logo);
		logo.clearAnimation();
		logo.startAnimation(animacionLogo);
		logo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, List_Activity.class);
		startActivity(intent);
		finish();
	}
}
