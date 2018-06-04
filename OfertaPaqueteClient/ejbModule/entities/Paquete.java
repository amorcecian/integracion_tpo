package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="paquetes")
public class Paquete implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nombre;
	@ManyToOne
	@JoinColumn(name="destino")
	private Destino destino;
	private Date fechaIngreso;
	private Date fechaSalida;
	private String estado;
	private int cupo;
	private float precioPersona;
	@ManyToMany(cascade={CascadeType.MERGE})
	@JoinTable(name="paquete_servicio",joinColumns=@JoinColumn(name="id_paquete"),
	inverseJoinColumns=@JoinColumn(name="id_servicio"))
	private List<Servicio> servicios;
	private String descripcion;
	private String foto;
	private int cantPersonas;
	private String politicasDeCancelacion;
	
	
	public Paquete(int id, String nombre, Destino destino, Date fechaIngreso, Date fechaSalida, String estado, int cupo,
			float precioPersona, List<Servicio> servicios, String descripcion, String foto, int cantPersonas,
			String politicasDeCancelacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.destino = destino;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.estado = estado;
		this.cupo = cupo;
		this.precioPersona = precioPersona;
		this.servicios = servicios;
		this.descripcion = descripcion;
		this.foto = foto;
		this.cantPersonas = cantPersonas;
		this.politicasDeCancelacion = politicasDeCancelacion;
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


	public Destino getDestino() {
		return destino;
	}


	public void setDestino(Destino destino) {
		this.destino = destino;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getCupo() {
		return cupo;
	}


	public void setCupo(int cupo) {
		this.cupo = cupo;
	}


	public float getPrecioPersona() {
		return precioPersona;
	}


	public void setPrecioPersona(float precioPersona) {
		this.precioPersona = precioPersona;
	}


	public List<Servicio> getServicios() {
		return servicios;
	}


	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public int getCantPersonas() {
		return cantPersonas;
	}


	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}


	public String getPoliticasDeCancelacion() {
		return politicasDeCancelacion;
	}


	public void setPoliticasDeCancelacion(String politicasDeCancelacion) {
		this.politicasDeCancelacion = politicasDeCancelacion;
	}
	
	

}
