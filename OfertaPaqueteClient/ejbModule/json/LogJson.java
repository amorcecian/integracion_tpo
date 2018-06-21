package json;

import java.io.Serializable;
import java.util.Date;


public class LogJson implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fecha;
	private int modulo;
	private int accion;
	
	
	
	public LogJson() {
		super();
	}



	public LogJson(Date fecha, int modulo, int accion) {
		super();
		this.fecha = fecha;
		this.modulo = modulo;
		this.accion = accion;
	}


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

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	

}
