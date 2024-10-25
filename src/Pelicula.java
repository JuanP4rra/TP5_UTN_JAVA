package TP5;

public class Pelicula {
	@Override
	public String toString() {
		return getID() + " - " + getNombre() + " - " + getGenero().getNombre();
	}

	// atributos
	private int ID;
	private String nombre;
	private Genero genero;
	private static int contadorID = 0; // Variable estática para contar el ID de las películas

	// constructor
	Pelicula() {
		this.ID = contadorID + 1; // Asigna el valor actual de contadorID como el ID de la pelicula
		contadorID++; // Incrementa el contador para la proxima pelicula
	}

	// constructor con parametros
	Pelicula(String nom, Genero gen) {
		this.ID = contadorID + 1; // Asigna el valor actual de contadorID como el ID de la pelicula
		contadorID++; // Incrementa el contador para la proxima pelicula
		setNombre(nom);
		setGenero(gen);
	}

	public static int getProximoIdEntero() {
		return contadorID + 1;
	}

	public static String getProximoIdString() {
		return Integer.toString(getProximoIdEntero());
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
