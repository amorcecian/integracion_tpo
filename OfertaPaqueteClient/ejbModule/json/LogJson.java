package json;

import java.io.Serializable;
import java.util.Date;


public class LogJson implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fecha;
	private String module;
	private String accion;
	
	
	
	public LogJson() {
		super();
	}


	public LogJson(Date fecha, String module, String accion) {
		super();
		this.fecha = fecha;
		this.module = module;
		this.accion = accion;
	}


	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	

}
