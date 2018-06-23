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
	private Float precioPersona;
	
	
	@ManyToMany(cascade={CascadeType.MERGE})
	@JoinTable(name="paquete_servicio",joinColumns=@JoinColumn(name="id_paquete"),
	inverseJoinColumns=@JoinColumn(name="id_servicio"))
	private List<Servicio> servicios;
	
	
	private String descripcion;
	
	@Lob
	@Column( length = 100000 )
	private String foto;
	
	private int cantPersonas;
	private String politicasDeCancelacion;
	

	@ManyToMany(cascade={CascadeType.MERGE})
	@JoinTable(name="paquete_formaPago",joinColumns=@JoinColumn(name="id_paquete"),
	inverseJoinColumns=@JoinColumn(name="id_formaPago"))
	private List<FormasDePago> mediosDePago;
	
	
	@ManyToOne
	@JoinColumn(name="agencia")
	private Agencia agencia;


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

	public Float getPrecioPersona() {
		return precioPersona;
	}


	public void setPrecioPersona(Float precioPersona) {
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


	public List<FormasDePago> getMediosDePago() {
		return mediosDePago;
	}


	public void setMediosDePago(List<FormasDePago> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}


	public Agencia getAgencia() {
		return agencia;
	}


	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	

}
