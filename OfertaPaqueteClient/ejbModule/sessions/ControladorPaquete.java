package sessions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;

import dto.AgenciaDTO;
import dto.DestinoDTO;
import dto.FormasDePagoDTO;
import dto.PaqueteDTO;
import dto.ServicioDTO;
import entities.Agencia;
import entities.Destino;
import entities.FormasDePago;
import entities.Paquete;
import entities.Servicio;
import json.PaqueteJson;
import mensajeria.BackOfficeRest;
import mensajeria.PortalWebQueue;

/**
 * Session Bean implementation class ControladorPaquete
 */
@Stateless
@LocalBean
public class ControladorPaquete implements ControladorPaqueteRemote {
	
	@PersistenceContext(unitName="MyPU")
	   private EntityManager em;
	
	@EJB
	ControladorAgencia conAgencias;
	
	@EJB
	PortalWebQueue queuePortal;
	
	@EJB
	BackOfficeRest backOffice;

    /**
     * Default constructor. 
     */
    public ControladorPaquete() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaPaquete(PaqueteDTO pdto)  {
    	Paquete p = new Paquete();
		PaqueteJson pjson = new PaqueteJson();
		
    	System.out.println("ID Agencia: " + pdto.getAgencia().getId());
    	Agencia a = conAgencias.recuperarAgencia(pdto.getAgencia().getId());
    	p.setAgencia(a);
    	
    	p.setNombre(pdto.getNombre());
    	
    	Destino d = new Destino();
    	d.setId(pdto.getDestino().getId());
    	d.setNombre(pdto.getDestino().getNombre());
    	p.setDestino(d);
    	
    	p.setFechaIngreso(pdto.getFechaIngreso());
    	p.setFechaSalida(pdto.getFechaSalida());
    	
    	p.setEstado(pdto.getEstado());
    	p.setCupo(pdto.getCupo());
    	p.setPrecioPersona(pdto.getPrecioPersona());
    	
    	
		List<String> lstsjson = new ArrayList<String>();
		List<Servicio> ltss = new ArrayList<Servicio>();
		for(ServicioDTO sdto: pdto.getServicios()){
			System.out.println("Id del servicio: " + sdto.getId());
			String ss = this.recuperarServicio(sdto.getId()).getNombre();
			Servicio s = this.recuperarServicio(sdto.getId());
			lstsjson.add(ss);
			ltss.add(s);
		}
		pjson.setServicios(lstsjson);
		p.setServicios(ltss);

    	
    	p.setDescripcion(pdto.getDescripcion());
    	p.setFoto(pdto.getFoto());
    	p.setCantPersonas(pdto.getCantPersonas());
    	p.setPoliticasDeCancelacion(pdto.getPoliticasDeCancelacion());
    	
		List<String> medioPago = new ArrayList<String>();
		List<FormasDePago> lstfp = new ArrayList<FormasDePago>();
		for(FormasDePagoDTO fpdto: pdto.getFormPagos()){
			String mp = this.recuperarFormadePago(fpdto.getId()).getDescripcion();
			FormasDePago fp = this.recuperarFormadePago(fpdto.getId());
			lstfp.add(fp);
			medioPago.add(mp);
		}
		pjson.setMediosDePago(medioPago);
		p.setMediosDePago(lstfp);
    	
    	em.persist(p);
		em.flush();
		
		Integer id = p.getId();
		p.setId(id);
		
		pdto.setId(id);
		

		System.out.println("ID PAQUETE INGRESADO: "+id);   	
		

		
		pjson.setId(p.getId());
		pjson.setNombre(p.getNombre());
		
		pjson.setCupo(p.getCupo());
		pjson.setCantPersonas(p.getCantPersonas());
		
		pjson.setFechaDesde(p.getFechaIngreso());
		pjson.setFechaHasta(p.getFechaSalida());
		
		pjson.setDescripcion(p.getDescripcion());		
		pjson.setPoliticas(p.getPoliticasDeCancelacion());
		
		pjson.setPrecio(p.getPrecioPersona());
		
 		Gson gson = new Gson();
 		
		String json = gson.toJson(pjson);
 		
 		System.out.println("Paquete a encolar: " + json);
		
		
  		//queuePortal.encolar(gson.toJson(pjson));
  		
  		//backOffice.Loggear(4);

    }
    
    public Paquete recuperarPaquete(int id) {
    	return em.find(Paquete.class, id);    	
    }
    

    
    
    public void actualizarPaquete(Paquete p) {
    	em.merge(p);
    }
    
    @SuppressWarnings("unchecked")
	public List<DestinoDTO> obtenerDestinos(){
    	List<DestinoDTO> lddto = new ArrayList<DestinoDTO>();
    	List<Destino> ld;
    	
		Query q = em.createQuery("SELECT d FROM Destino d ORDER BY d.nombre");
		ld = (List<Destino>) q.getResultList();
		for(Destino d : ld) {
			DestinoDTO ddto = new DestinoDTO();
			ddto.setId(d.getId());
			ddto.setLatitud("-38.0172131");
			ddto.setLongitud("-57.7406177");
			ddto.setNombre(d.getNombre());
			lddto.add(ddto);			
		}
    	
    	return lddto;
    }
    
	@SuppressWarnings("unchecked")
	public List<PaqueteDTO> recuperarPaquetes() {
		List<PaqueteDTO> lstPDTO = new ArrayList<PaqueteDTO>();
		List<Paquete> lstP;
		Query q = em.createQuery("SELECT p FROM Paquete p ");
		lstP = (List<Paquete>) q.getResultList();
		for(Paquete p: lstP) {
			PaqueteDTO pdto = new PaqueteDTO();
			
			pdto.setId(p.getId());
			pdto.setNombre(p.getNombre());
			DestinoDTO ddto = new DestinoDTO();
			ddto.setId(p.getDestino().getId());
			ddto.setNombre(p.getDestino().getNombre());
			//Faltaria mapear Latitud y Longitud, no se si los demas modulos contemplaron estas variables
						
			pdto.setDestino(ddto);
			
			pdto.setFechaIngreso(p.getFechaIngreso());
			pdto.setFechaSalida(p.getFechaSalida());
			pdto.setEstado(p.getEstado());
			
			pdto.setCupo(p.getCupo());
			pdto.setPrecioPersona(p.getPrecioPersona());
			
			List <ServicioDTO> lstSDTO = new ArrayList<ServicioDTO>();
			List <Servicio> lstS = p.getServicios();
			
			for(Servicio s : lstS) {
				ServicioDTO sdto = new ServicioDTO();
				sdto.setId(s.getId());
				sdto.setNombre(s.getNombre());
				lstSDTO.add(sdto);
			}
			
			pdto.setServicios(lstSDTO);
			
			pdto.setDescripcion(p.getDescripcion());
			pdto.setFoto(p.getFoto());
			pdto.setCantPersonas(p.getCantPersonas());
			pdto.setPoliticasDeCancelacion(p.getPoliticasDeCancelacion());
			
			lstPDTO.add(pdto);			
			
		
		}
		return lstPDTO;
	}
	
	public DestinoDTO recuperarDestino (int id) {
		Destino d = em.find(Destino.class, id);
		DestinoDTO ddto = new DestinoDTO();
		
		ddto.setId(d.getId());
		ddto.setNombre(d.getNombre());
		ddto.setLatitud("-38.0172131");
		ddto.setLongitud("-57.7406177");
		
		return ddto;    		
	}

	@SuppressWarnings("unchecked")
	public List<FormasDePagoDTO> recuperarFormasdePago() {
		List<FormasDePagoDTO> lfpdto = new ArrayList<FormasDePagoDTO>();
		
		List<FormasDePago> lfp;
		Query q = em.createQuery("SELECT fp FROM FormasDePago fp ");
		lfp = (List<FormasDePago>) q.getResultList();
		
		for(FormasDePago fp: lfp) {
			FormasDePagoDTO fpdto = new FormasDePagoDTO();
			fpdto.setId(fp.getId());
			fpdto.setDescripcion(fp.getDescripcion());
			lfpdto.add(fpdto);
		}		
		
		return lfpdto;
	}
	
	public FormasDePago recuperarFormadePago(int id){		
		return em.find(FormasDePago.class, id);		
	}
	
	public Servicio recuperarServicio(int id) {		
		return em.find(Servicio.class, id);
	}

}
