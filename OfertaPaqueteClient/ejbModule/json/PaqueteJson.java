package json;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PaqueteJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private CiudadJson ciudadDestino;
	private int cupo;
	private int cantPersonas;
	private AgenciaJson agencia;
	private String foto;
	private Date fechaDesde;
	private Date fechaHasta;
	private String estado;
	private float precio;
	private String descripcion;
	private String politicas;
	private List<String> servicios;
	private List<String> mediosDePago;
	
	
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
	public CiudadJson getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(CiudadJson ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public int getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
	public AgenciaJson getAgencia() {
		return agencia;
	}
	public void setAgencia(AgenciaJson agencia) {
		this.agencia = agencia;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPoliticas() {
		return politicas;
	}
	public void setPoliticas(String politicas) {
		this.politicas = politicas;
	}
	public List<String> getServicios() {
		return servicios;
	}
	public void setServicios(List<String> servicios) {
		this.servicios = servicios;
	}
	public List<String> getMediosDePago() {
		return mediosDePago;
	}
	public void setMediosDePago(List<String> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

	
	

}
