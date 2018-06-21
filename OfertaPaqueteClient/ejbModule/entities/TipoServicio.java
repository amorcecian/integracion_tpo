package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dto.ServicioDTO;
import dto.TipoServicioDTO;


@Entity
@Table(name="tipoServicios")
public class TipoServicio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String nombre;
	
	@OneToMany (cascade=CascadeType.ALL)	
	@JoinColumn(name="idTipoServicio")
	private List<Servicio> servicios;
	
	public TipoServicio(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.servicios = new ArrayList<Servicio>();
	}
	

	
	public TipoServicio() {
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

	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public TipoServicioDTO toDTO(TipoServicio ts) {
		TipoServicioDTO tsDTO = new TipoServicioDTO();
		tsDTO.setId(ts.getId());
		tsDTO.setNombre(ts.getNombre());
		
		List<ServicioDTO> lsdto = new ArrayList<ServicioDTO>();
		List<Servicio> ls = ts.getServicios();
		
		for(Servicio s : ls) {
			ServicioDTO sdto = new ServicioDTO();
			sdto.setId(s.getId());
			sdto.setNombre(s.getNombre());
			lsdto.add(sdto);
		}
		
		return tsDTO;
	}

	@Override
	public String toString() {
		return "TipoServicio [id=" + id + ", nombre=" + nombre + ", servicios=" + servicios + "]";
	}
	
	
}
