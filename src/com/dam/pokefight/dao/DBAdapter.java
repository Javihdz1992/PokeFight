package com.dam.pokefight.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
	private DBHelper dbHelper;
	private static final String DATABASE_NAME = "pokefight.db";
	private static final int DATABASE_VERSION = 1;

	public DBAdapter(Context context) {
		dbHelper = new DBHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void insertPokemon(Pokemon p) {
		ContentValues values = buildFromPokemon(p);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		try {
			db.insertWithOnConflict(DBHelper.POKEMON_TABLE, null, values,
					SQLiteDatabase.CONFLICT_IGNORE);
		} finally {
			db.close();
		}
	}
	public List<Pokemon> getPokemones(){
		List<Pokemon> pokemones = new ArrayList<Pokemon>();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		try{
		Cursor cursor = db.query(DBHelper.POKEMON_TABLE, null, null, null, null, null, null);
			while(cursor.moveToNext()){
				pokemones.add(new Pokemon(
						cursor.getInt(DBHelper.P_ID),
						cursor.getString(DBHelper.P_NOMBRE),
						cursor.getString(DBHelper.P_TIPO),
						cursor.getInt(DBHelper.P_IMG),
						cursor.getInt(DBHelper.P_VIDA),
						cursor.getInt(DBHelper.P_DEFENSA),
						cursor.getInt(DBHelper.P_ATAQUE)));
			}
		}finally{
			db.close();
		}
		return pokemones;
	}
	public int getCountPokemones(){
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		int count =0;
		try{
		Cursor cursor = db.query(DBHelper.POKEMON_TABLE, null, null, null, null, null, null);
		count = cursor.getCount();
		}finally{
			db.close();
		}
		return count;
	}
	public ContentValues buildFromPokemon(Pokemon p) {
		ContentValues values = new ContentValues();
		values.put(DBHelper.POKEMON_ID, p.getId());
		values.put(DBHelper.POKEMON_NOMBRE, p.getNombre());
		values.put(DBHelper.POKEMON_TIPO, p.getTipo());
		values.put(DBHelper.POKEMON_IMG, p.getImg());
		values.put(DBHelper.POKEMON_VIDA, p.getVida());
		values.put(DBHelper.POKEMON_DEFENSA, p.getDefensa());
		values.put(DBHelper.POKEMON_ATAQUE, p.getAtaque());
		return values;
	}
}
