package json;

import java.io.Serializable;
import java.util.List;

public class TipoServicioJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private List<ServicioJson> servicios;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<ServicioJson> getServicios() {
		return servicios;
	}
	public void setServicios(List<ServicioJson> servicios) {
		this.servicios = servicios;
	}
	
	
	
	
	

}
