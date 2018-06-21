package entities;

import java.io.Serializable;

import javax.persistence.*;

import dto.ServicioDTO;

@Entity
@Table(name="servicios")
public class Servicio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nombre;

	
	
	public Servicio(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	public Servicio() {
		super();
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

	
	public ServicioDTO toDTO (Servicio s) {
		ServicioDTO sdto = new ServicioDTO();
		
		sdto.setId(s.getId());
		sdto.setNombre(s.getNombre());
		
		return sdto;
	}


	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + "]";
	}

	

}
