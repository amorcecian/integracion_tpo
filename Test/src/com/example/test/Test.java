package com.example.test;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import sessions.ControladorAgenciaRemote;


public class Test {

	public static void main(String[] args) throws Exception {
		
		ControladorRemote cRemote;  
		
	    final Hashtable jndiProperties = new Hashtable();	
	    
	    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");	
	    
	    jndiProperties.put("jboss.naming.client.ejb.context", true);
	    
	    final Context context = new InitialContext(jndiProperties);
		
	    cRemote = (ControladorRemote) context	    		 
	            .lookup("ejb:OfertaPaqueteServicio/OfertaPaqueteClient//Controlador!controlador.ControladorRemote");     
	          
	    cRemote.altaAgencia("Pepe Travel","Av. Libertador 948");
	    
	    cRemote.altaAgencia("Pepe Travel","Av. Libertador 948");
	    
	     
	}

}
