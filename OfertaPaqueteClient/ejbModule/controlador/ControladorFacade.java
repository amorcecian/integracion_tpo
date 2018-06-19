package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.AgenciaDTO;
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
		a.setId(conAgencias.altaAgencia(a));
		//sendToBackOfficeSolicitud(nAgencia);
	}
	
	public List<AgenciaDTO> recuperarAgencias() {		
		return conAgencias.recuperarAgencias();		
	}
	
	
	public List<PaqueteDTO> recuperarPaquetes() {		
		return conPaquetes.recuperarPaquetes();
	}
	
	public List<TipoServicioDTO> recuperarServicios(){
		return conBackOffice.obtenerServicios();
	}



}
