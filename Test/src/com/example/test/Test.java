package com.example.test;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;

import controlador.ControladorFacadeRemote;
import dto.AgenciaDTO;
import sessions.ControladorAgenciaRemote;


public class Test {

	public static void main(String[] args) throws Exception {
		
		ControladorFacadeRemote cRemote;  
		
	    final Hashtable jndiProperties = new Hashtable();	
	    
	    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");	
	    
	    jndiProperties.put("jboss.naming.client.ejb.context", true);
	    
	    final Context context = new InitialContext(jndiProperties);
		
	    cRemote = (ControladorFacadeRemote) context	    		 
	            .lookup("ejb:OfertaPaqueteServicio/OfertaPaqueteClient//Controlador!controlador.ControladorRemote");     
	          
	    AgenciaDTO a = new AgenciaDTO();
	    a.setNombre("Pepe Travel");
	    a.setDireccion("Av. Libertador 948");
	    cRemote.altaAgencia(a);
	    
	    cRemote.altaAgencia(a);

	    
	    
	     
	}

}
