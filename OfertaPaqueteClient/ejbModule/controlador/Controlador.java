package controlador;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.AgenciaDTO;
import entities.Agencia;
import sessions.ControladorAgencia;

/**
 * Session Bean implementation class Controlador
 */
@Stateless
public class Controlador implements ControladorRemote {
	
	@EJB
	ControladorAgencia conAgencias;
	
	public void altaAgencia(String nombre, String direccion) {
		
		if(conAgencias.altaAgencia(nombre, direccion)!=0) {
			System.out.println("Agencia insertada correctamente");
		}
		
	
		
	}



}
