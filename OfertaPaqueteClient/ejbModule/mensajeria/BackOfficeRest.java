package mensajeria;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import dto.AgenciaDTO;
import dto.ServicioDTO;
import dto.TipoServicioDTO;
import entities.Agencia;
import entities.Servicio;
import entities.TipoServicio;
import json.LogJson;
import sessions.ControladorAgencia;
import test.Funciones;


/**
 * Session Bean implementation class AgenciaRest
 */
@Stateless
@LocalBean
public class BackOfficeRest implements BackOfficeRestRemote {
	
    Properties prop = new Properties();
    InputStream input = null;
    
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
			
        input = new FileInputStream("config.properties");
        prop.load(input);
        String urlBackOffice = prop.getProperty("BackOfficeURLAltaAgencia"); 
        
        System.out.println(urlBackOffice); 
        
	  	Agencia a = cAgencia.recuperarAgencia(adto.getId());

    	
        /*
		URL url = new URL(urlBackOffice);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
	  	urlConnection.setRequestProperty("Content-Type","application/json");
	  
	  	
	  	Agencia a = cAgencia.recuperarAgencia(adto.getId());
	  	
		Gson gson = new Gson();
		
		String aJson = gson.toJson(a);
		
 		System.out.println("Imprimo el JSON de la Agencia: "+gson.toJson(a));
 		
 		
	 	DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
	 	wr.writeBytes(aJson);
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
		
		
		
		int idBackoffice = gson.fromJson(response.toString(), Integer.class);
 		System.out.println("Id del backoffice: " + idBackoffice );
		 		
		a.setIdBackOffice(idBackoffice);
		
		cAgencia.actualizarAgencia(a);
		*/
		Loggear("Alta de la agencia: " + a.getNombre() + "con dirección: " + a.getDireccion() + ", IdBackOffice: " + a.getIdBackOffice());
	
	
		} catch (Exception e) {			
			e.printStackTrace();
		}

    	
    }
    
  	public void Loggear (String accion) {
  		
  		try {
  	        input = new FileInputStream("config.properties");
  	        prop.load(input);
  	        String urlBackOffice = prop.getProperty("BackOfficeURLLog"); 
  	        
  	        System.out.println(urlBackOffice); 
  	    	
  	        /*
  			URL url = new URL(urlBackOffice);
  			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
  			urlConnection.setDoOutput(true);
  			urlConnection.setRequestMethod("POST");
  		  	urlConnection.setRequestProperty("Content-Type","application/json");
  		  	
  		  	/*
	  	 	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
  		  	 */

	  		Date fecha = new Date();
  		  	String module = "OP";
  		  	
  		  	
  		  	LogJson log = new LogJson(fecha,module,accion);
  		  	
  			Gson gson = new Gson();
  			
  			String logJson = gson.toJson(log);
  			
  	 		System.out.println("Log al backoffice: "+gson.toJson(logJson));
  	 		
  	 		/*
  		 	DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
  		 	wr.writeBytes(logJson);
  		 	wr.flush();
  		 	wr.close();	

  		 	int codResponse = urlConnection.getResponseCode();
  		 	
  		 	
  		  	if(codResponse != 200) {
  		  		throw new RuntimeException("Error de conexión: " + urlConnection.getResponseCode());
  		  	}	
  		  	*/
  		  	

  	 		
  			
  		}catch (Exception e) {
			e.printStackTrace();
		}
  		
  	}
  	
  	public List<TipoServicioDTO> obtenerServicios(){
  		List<TipoServicio> listServicios = null;
  		List<TipoServicioDTO> listtsdto = new ArrayList<TipoServicioDTO>();

  		try {
  			/*
	        input = new FileInputStream("config.properties");
	        prop.load(input);
	        String urlBackOffice = prop.getProperty("BackOfficeURLServicios"); 
	    	
	        
			URL url = new URL(urlBackOffice);
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
	 		ServicioJson sj = gson.fromJson(response.toString(), ServicioJson.class);
	 		
	 		*/
	 		
  			
  			Gson gson = new Gson();			
	 		

  			Type founderListType = new TypeToken<ArrayList<TipoServicio>>(){}.getType();

  			listServicios = gson.fromJson(Funciones.obtenerServicios(), founderListType);
  			
  			/*
  			for(TipoServicio ts:listServicios){
  				System.out.println("Tipo Servicio: " + ts.getNombre());
  				for(Servicio s : ts.getServicios()) {
  					System.out.println("Servicio: " + s.getNombre());
  				}
  			}
  			*/
	 		
	 		
	 		for(TipoServicio ts: listServicios) {
	 			TipoServicioDTO tsdto = ts.toDTO(ts);
	 	  		List<ServicioDTO> lsdto = new ArrayList<ServicioDTO>();
	 			for(Servicio s : ts.getServicios()) {
	 				ServicioDTO sdto = s.toDTO(s);
	 				lsdto.add(sdto);
	 			}
	 			tsdto.setServicios(lsdto);
	 			listtsdto.add(tsdto);
	 		}
	 		
  			
  		}catch (Exception e) {
			e.printStackTrace();
		}
  		
			return listtsdto;
  		
  	}

    
    
}
