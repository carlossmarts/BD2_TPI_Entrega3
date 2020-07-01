package model;

public class ObraSocial {
	private String nombre;

	public ObraSocial(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "ObraSocial [nombre=" + nombre + "]";
	}

}
