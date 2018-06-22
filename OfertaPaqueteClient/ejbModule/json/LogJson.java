package json;

import java.io.Serializable;
import java.util.Date;


public class LogJson implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int modulo;
	private int accion;
	private String fecha;
	

	public int getModulo() {
		return modulo;
	}
	public void setModulo(int modulo) {
		this.modulo = modulo;
	}
	public int getAccion() {
		return accion;
	}
	public void setAccion(int accion) {
		this.accion = accion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


}
