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
	private Long fecha;
	

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
	public Long getFecha() {
		return fecha;
	}
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}



}
