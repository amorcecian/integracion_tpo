package sessions;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Agencia;

/**
 * Session Bean implementation class ControladorAgencia
 */
@Stateless
@LocalBean
public class ControladorAgencia implements ControladorAgenciaRemote {
	
	@PersistenceContext(unitName="MyPU")
	   private EntityManager em;
	

    /**
     * Default constructor. 
     */
    public ControladorAgencia() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaAgencia(String nombre, String direccion) {
    	if(!validarAgencia(nombre,direccion)) {

    		Agencia nAgencia = new Agencia (nombre,direccion,"Pendiente");
    		em.persist(nAgencia);

    		
    	}else {
    		System.out.println("La agencia existe");
    	}
    	
    }
    
    private boolean validarAgencia(String nombre, String direccion) {
		try {
			Query q = em.createQuery("SELECT COUNT(a.nombre) FROM Agencia a WHERE a.nombre LIKE :nom AND a.direccion LIKE :dire ")
					.setParameter("nom", nombre)
					.setParameter("dire", direccion);
			
			Long x = (Long) q.getSingleResult();
			
			
			if(x >= 1 ) {				
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
