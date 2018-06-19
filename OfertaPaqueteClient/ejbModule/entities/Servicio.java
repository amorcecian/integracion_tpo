package entities;

import java.io.Serializable;

import javax.persistence.*;

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
	@ManyToOne
	private TipoServicio TipoServicio;
	
	
	public Servicio(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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


	public TipoServicio getTipoServicio() {
		return TipoServicio;
	}


	public void setTipoServicio(TipoServicio tipoServicio) {
		TipoServicio = tipoServicio;
	}
	
	
	

}
