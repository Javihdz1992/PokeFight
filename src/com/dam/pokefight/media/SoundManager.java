package com.dam.pokefight.media;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundManager {
	private Context pCOntext;
	private SoundPool sndPool;
	private float rate = 1.0f;
	private float leftVolume = 1.0f;
	private float rightVolume = 1.0f;

	public SoundManager(Context appContext) {
		sndPool = new SoundPool(16, AudioManager.STREAM_MUSIC, 100);
		pCOntext = appContext;
	}

	public int load(int idSonido) {
		return sndPool.load(pCOntext, idSonido, 1);
	}

	public void play(int idSonido) {
		sndPool.play(idSonido, leftVolume, rightVolume, 1, 0, rate);
	}

	public void unloadAll() {
		sndPool.release();
	}

}
