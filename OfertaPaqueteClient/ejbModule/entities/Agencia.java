package entities;

import java.util.List;

public class Agencia {

	private int id;
	private String nombre;
	private String direccion;
	private String estado;
	private List<Paquete> paquetes;
	
	public Agencia(int id, String nombre, String direccion, String estado, List<Paquete> paquetes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.estado = estado;
		this.paquetes = paquetes;
	}

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}
	
	
}
