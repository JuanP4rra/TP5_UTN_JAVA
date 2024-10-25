package TP5;

public class Genero {
	@Override
	public String toString() {
		return getNombre();
	}

	private String nombre;

	public Genero(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
