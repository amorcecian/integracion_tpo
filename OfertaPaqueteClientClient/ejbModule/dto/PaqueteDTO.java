package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class PaqueteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private DestinoDTO destino;
	private Date fechaIngreso;
	private Date fechaSalida;
	private String estado;
	private int cupo;
	private float precioPersona;
	private List<ServicioDTO> servicios;
	private String descripcion;
	private String foto;
	private int cantPersonas;
	private String politicasDeCancelacion;
	private AgenciaDTO agencia;
	

	private List<FormasDePagoDTO> formPagos;
	
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
	public DestinoDTO getDestino() {
		return destino;
	}
	public void setDestino(DestinoDTO destino) {
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
	public List<ServicioDTO> getServicios() {
		return servicios;
	}
	public void setServicios(List<ServicioDTO> servicios) {
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
	
	public AgenciaDTO getAgencia() {
		return agencia;
	}
	public void setAgencia(AgenciaDTO agencia) {
		this.agencia = agencia;
	}
	public List<FormasDePagoDTO> getFormPagos() {
		return formPagos;
	}
	public void setFormPagos(List<FormasDePagoDTO> formPagos) {
		this.formPagos = formPagos;
	}
	@Override
	public String toString() {
		return "PaqueteDTO [nombre=" + nombre + ", destino=" + destino + ", fechaIngreso=" + fechaIngreso
				+ ", fechaSalida=" + fechaSalida + ", estado=" + estado + ", cupo=" + cupo + ", precioPersona="
				+ precioPersona + ", servicios=" + servicios + ", descripcion=" + descripcion + ", foto=" + foto
				+ ", cantPersonas=" + cantPersonas + ", politicasDeCancelacion=" + politicasDeCancelacion + ", agencia="
				+ agencia + "]";
	}
	

}
