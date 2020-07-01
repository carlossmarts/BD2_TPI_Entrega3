package model;

public class FormaPago {
	private String formaPago;

	public FormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String toString() {
		return "FormaPago [formaPago=" + formaPago + "]";
	}

}
