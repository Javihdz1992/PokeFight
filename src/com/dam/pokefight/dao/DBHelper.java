package com.dam.pokefight.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	// TABLA
	public final static String POKEMON_TABLE = "pokemones";
	public final static String POKEMON_ID = "id";
	public final static String POKEMON_NOMBRE = "nombre";
	public final static String POKEMON_TIPO = "tipo";
	public final static String POKEMON_IMG = "img";
	public final static String POKEMON_VIDA = "vida";
	public final static String POKEMON_DEFENSA = "defensa";
	public final static String POKEMON_ATAQUE = "ataque";
	// INDICES
	public final static int P_ID = 0;
	public final static int P_NOMBRE = 1;
	public final static int P_TIPO = 2;
	public final static int P_IMG = 3;
	public final static int P_VIDA = 4;
	public final static int P_DEFENSA = 5;
	public final static int P_ATAQUE = 6;

	// SQL
		private final String DATABASE_CREATE = 
				"CREATE TABLE "+POKEMON_TABLE 
				+ "("+POKEMON_ID +" integer primary key autoincrement, "
				+ POKEMON_NOMBRE + " text,"
				+ POKEMON_TIPO + " text,"
				+ POKEMON_IMG + " integer,"
				+ POKEMON_VIDA + " integer,"
				+ POKEMON_DEFENSA + " integer,"
				+ POKEMON_ATAQUE + " integer)";

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS "+POKEMON_TABLE);
		onCreate(db);

	}


}
