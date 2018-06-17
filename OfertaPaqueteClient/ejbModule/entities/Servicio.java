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
	private String descripcion;
	@ManyToOne
	private TipoServicio TipoServicio;
	
	
	public Servicio(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public TipoServicio getTipoServicio() {
		return TipoServicio;
	}


	public void setTipoServicio(TipoServicio tipoServicio) {
		TipoServicio = tipoServicio;
	}
	
	
	

}
