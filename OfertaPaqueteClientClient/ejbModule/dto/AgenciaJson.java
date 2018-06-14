package dto;

import java.io.Serializable;

public class AgenciaJson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String detalle;
	private int id;
	
	
	public AgenciaJson(String tipo, String detalle,int id) {
		super();
		this.tipo = tipo;
		this.detalle = detalle;
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
