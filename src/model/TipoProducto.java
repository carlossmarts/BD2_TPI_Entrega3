package model;

public class TipoProducto {
	private String tipo;

	public TipoProducto(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "TipoProducto [tipo=" + tipo + "]";
	}

}
