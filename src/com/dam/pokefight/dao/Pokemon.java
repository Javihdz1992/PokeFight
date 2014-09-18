package com.dam.pokefight.dao;

import java.io.Serializable;

public class Pokemon implements Serializable{
	private static final long serialVersionUID = -6601419686944680032L;
	private int id;
	private String nombre;
	private String tipo;
	private int img;
	private int vida;
	private int defensa;
	private int ataque;
	public Pokemon(int id, String nombre, String tipo, int img, int vida,
			int defensa, int ataque) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.img = img;
		this.vida = vida;
		this.defensa = defensa;
		this.ataque = ataque;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	@Override
	public String toString() {
		return nombre;
	}
 
}
