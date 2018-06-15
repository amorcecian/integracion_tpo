package controlador;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.AgenciaDTO;
import dto.PaqueteDTO;
import entities.Agencia;
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
	
	public ArrayList<AgenciaDTO> recuperarAgencias() {		
		return conAgencias.recuperarAgencias();		
	}
	
	
	public ArrayList<PaqueteDTO> recuperarPaquetes() {		
		return conPaquetes.recuperarPaquetes();
	}



}
