package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.AgenciaDTO;
import dto.DestinoDTO;
import dto.FormasDePagoDTO;
import dto.PaqueteDTO;
import dto.TipoServicioDTO;
import entities.Agencia;
import mensajeria.BackOfficeRestRemote;
import sessions.ControladorAgencia;
import sessions.ControladorPaquete;

/**
 * Session Bean implementation class Controlador
 */
@Stateless
public class ControladorFacade implements ControladorFacadeRemote {
	
	@EJB
	ControladorAgencia conAgencias;
	
	@EJB
	ControladorPaquete conPaquetes;
	
	@EJB
	BackOfficeRestRemote conBackOffice;
	
	private static ControladorFacade instancia;
	
	
	public static ControladorFacade getInstancia(){
		if (instancia == null) {
			instancia = new ControladorFacade();
		}
		return instancia;
	}
	
	
	public void altaAgencia(AgenciaDTO a) {
		conAgencias.altaAgencia(a);
	}
	
	public List<AgenciaDTO> recuperarAgencias() {		
		return conAgencias.recuperarAgencias();		
	}
	
	public AgenciaDTO recuperarAgenciaDTO(int id) {		
		return conAgencias.recuperarAgenciaDTO(id);		
	}
	
	
	public List<PaqueteDTO> recuperarPaquetes() {		
		return conPaquetes.recuperarPaquetes();
	}
	
	public List<TipoServicioDTO> recuperarServicios(){
		return conBackOffice.obtenerServicios();
	}
	
	public List<DestinoDTO> recuperarDestinos(){
		return conPaquetes.obtenerDestinos();
	}
	
	public void altaPaquete(PaqueteDTO p) {
		conPaquetes.altaPaquete(p);
	}
	
	public DestinoDTO recuperarDestino(int id) {
		return conPaquetes.recuperarDestino(id);
	}


	@Override
	public List<FormasDePagoDTO> recuperarFormasdePago() {
		return conPaquetes.recuperarFormasdePago();
	}



}
