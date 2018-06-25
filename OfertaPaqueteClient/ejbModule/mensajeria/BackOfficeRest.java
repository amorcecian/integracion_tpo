package mensajeria;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import dto.AgenciaDTO;
import dto.ServicioDTO;
import dto.TipoServicioDTO;
import entities.Agencia;
import entities.Servicio;
import entities.TipoServicio;
import json.AgenciaJson;
import json.LogJson;
import sessions.ControladorAgencia;
import test.Funciones;


/**
 * Session Bean implementation class AgenciaRest
 */
@Stateless
@LocalBean
public class BackOfficeRest implements BackOfficeRestRemote {
	
    
	@PersistenceContext(unitName="MyPU")
	   private EntityManager em;
	
    @EJB
    ControladorAgencia cAgencia;

    /**
     * Default constructor. 
     */
    public BackOfficeRest() {
        // TODO Auto-generated constructor stub
    }
    
    public void envioAgenciaBackoffice (AgenciaDTO adto) {
		
    	try {
        
	  	Agencia a = cAgencia.recuperarAgencia(adto.getId());
	  	
		AgenciaJson ajson = new AgenciaJson();
		ajson.setNombre(a.getNombre());
		ajson.setDireccion(a.getDireccion());
		ajson.setTipo(2);
	  	
	  	Gson gson = new Gson();		
		String sajson = gson.toJson(ajson);		
 		System.out.println("Imprimo el JSON de la Agencia: "+gson.toJson(sajson));

 		
 		/*
        //   INICIO PRODUCCION
		URL url = new URL("http://192.168.130.104:8080/IA_TPO_BO_G05_DWS/REST/solicitudes");
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("PUT");
	  	urlConnection.setRequestProperty("Content-Type","application/json");
 		
 		
	 	DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
	 	wr.writeBytes(sajson);
	 	wr.flush();
	 	wr.close();	

	 	int codResponse = urlConnection.getResponseCode();
	 	
	 	
	  	if(codResponse != 200) {
	  		throw new RuntimeException("Error de conexión: " + urlConnection.getResponseCode());
	  	}	  	

	 	
	 	BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	 	String inputLine;
	 	StringBuffer response = new StringBuffer();

	 	while((inputLine = br.readLine()) != null) {
	 		response.append(inputLine);
	 	}
		br.close();
		
		//print result
 		System.out.println(response.toString());
		
		
		
		String idBackoffice = gson.fromJson(response.toString(), String.class);
 		System.out.println("Id del backoffice: " + idBackoffice );
		 		
		a.setIdBackOffice(idBackoffice);
		
		cAgencia.actualizarAgencia(a);
		
		
		Loggear(7);
		//   FIN PRODUCCION
		*/
	  	
	  	
	  	//INICIO TEST
		  	String idBackoffice = gson.fromJson(Funciones.altaAgencia(sajson), String.class);
	 		System.out.println("Id del backoffice: " + idBackoffice );
			 		
			a.setIdBackOffice(idBackoffice);
			
			cAgencia.actualizarAgencia(a);
	  	
	  	
	  	//FIN TEST
		
	
	
		} catch (Exception e) {			
			e.printStackTrace();
		}

    	
    }
    
  	public void Loggear (int accion) {
  		
  		try {
 	    	

			URL url = new URL("http://192.168.130.104:8080/IA_TPO_BO_G05_DWS/REST/logs");
  			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
  			urlConnection.setDoOutput(true);
  			urlConnection.setRequestMethod("PUT");
  		  	urlConnection.setRequestProperty("Content-Type","application/json");
  		  	
  		  	/*
  		  	//Ejemplo datetime format
	  	 	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
  		  	 */

	  		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
  		  	Long fjson = date.getTime();
			int modulo = 2;
  		  	
  		  	
  		  	LogJson log = new LogJson();
  		  	log.setModulo(modulo);
  		  	log.setAccion(accion);
  		  	log.setFecha(fjson);
  		  	
  		  	
  			Gson gson = new Gson();
  			
  			String logJson = gson.toJson(log);
  			
  	 		System.out.println("Log al backoffice: "+gson.toJson(logJson));
  	 		
  	 		
  		 	DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
  		 	wr.writeBytes(logJson);
  		 	wr.flush();
  		 	wr.close();	

  		 	int codResponse = urlConnection.getResponseCode();
  		 	
  		 	
  		  	if(codResponse != 200) {
  		  		throw new RuntimeException("Error de conexión: " + urlConnection.getResponseCode());
  		  	}	
  			
  		}catch (Exception e) {
			e.printStackTrace();
		}
  		
  	}
  	
  	public List<TipoServicioDTO> obtenerServicios(){
  		List<TipoServicio> listServicios = null;
  		List<TipoServicioDTO> listtsdto = new ArrayList<TipoServicioDTO>();

  		try {	        
			
  			/*
  			//   INICIO PRODUCCION
  			URL url = new URL("http://192.168.130.104:8080/IA_TPO_BO_G05_DWS/REST/servicios");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("GET");
		  	urlConnection.setRequestProperty("Content-Type","application/json");
		  	
		 	int codResponse = urlConnection.getResponseCode();
		 	
		 	
		  	if(codResponse != 200) {
		  		throw new RuntimeException("Error de conexión: " + urlConnection.getResponseCode());
		  	}	  	

		 	
		 	BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		 	String inputLine;
		 	StringBuffer response = new StringBuffer();
		 	
		 	

		 	
		 	while((inputLine = br.readLine()) != null) {
		 		response.append(inputLine);
		 	}
			br.close();
			
			//print result 		
			System.out.println(response.toString());
  			Gson gson = new Gson();	
  			Type founderListType = new TypeToken<ArrayList<TipoServicio>>(){}.getType();
  			
  			listServicios = gson.fromJson(response.toString(), founderListType);
  		
  			//   FIN PRODUCCION
  			*/
  			
  			
  			//INICIO TEST
  			Gson gson = new Gson();	
  			Type founderListType = new TypeToken<ArrayList<TipoServicio>>(){}.getType();
  			//listServicios = gson.fromJson(Funciones.obtenerServicios(), founderListType);
  			listServicios = gson.fromJson(new FileReader("c:\\servicios.txt"), founderListType);
  			//FIN TEST
  			
	 		
	 		
	 		for(TipoServicio ts: listServicios) {
	 			TipoServicioDTO tsdto = ts.toDTO(ts);
	 	  		List<ServicioDTO> lsdto = new ArrayList<ServicioDTO>();
	 			for(Servicio s : ts.getServicios()) {
	 				ServicioDTO sdto = s.toDTO(s);
	 				lsdto.add(sdto);
	 			}
	 			System.out.println("Servicio: " + ts.toString());
	 			tsdto.setServicios(lsdto);
	 			listtsdto.add(tsdto);
	 			em.merge(ts);
	 			em.flush();
	 		}
	 		
  			
  		}catch (Exception e) {
			e.printStackTrace();
		}
  		
			return listtsdto;
  		
  	}

    
    
}
