package test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import entities.Agencia;
import entities.Servicio;
import entities.TipoServicio;

public abstract class Funciones {
	
	public static String obtenerServicios(){
		
		List<TipoServicio> lts = new ArrayList<TipoServicio>();
		
		Servicio s1 = new Servicio(11, "Bar");
		Servicio s2 = new Servicio(12, "Desayuno");
		Servicio s3 = new Servicio(21, "Casino");
		Servicio s4 = new Servicio(22, "Diarios y revistas");
		Servicio s5 = new Servicio(31, "Aire acondicionado");
		Servicio s6 = new Servicio(32, "Caja fuerte");
		
		TipoServicio ts1 = new 	TipoServicio(1,"Comida y bebida");
		ts1.getServicios().add(s1);
		ts1.getServicios().add(s2);
		
		TipoServicio ts2 = new 	TipoServicio(2,"Entretenimiento");
		ts2.getServicios().add(s3);
		ts2.getServicios().add(s4);
		
		TipoServicio ts3 = new 	TipoServicio(3,"General");
		ts3.getServicios().add(s5);
		ts3.getServicios().add(s6);
		
		lts.add(ts1);
		lts.add(ts2);
		lts.add(ts3);
		
		System.out.println("Llego hasta aca");
		Gson gson = new Gson();
		
		return gson.toJson(lts);
		
	}
	
	public static String altaAgencia(String ajson) {
		
		Gson json = new Gson();
		
		Agencia a = json.fromJson(ajson, Agencia.class);
		
		System.out.println("Nombre de la agencia: " + a.getNombre());
		
		int idBackoffice = 3;
		
		return json.toJson(idBackoffice);		
		
	}
	


	
	

}
