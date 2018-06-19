package dto;

import java.io.Serializable;
import java.util.List;

public class TipoServicioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private List<ServicioDTO> servicios;
	
	
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
	public List<ServicioDTO> getServicios() {
		return servicios;
	}
	public void setServicios(List<ServicioDTO> servicios) {
		this.servicios = servicios;
	}
	
	
}
