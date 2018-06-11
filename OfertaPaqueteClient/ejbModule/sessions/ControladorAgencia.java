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
	
	
    public ControladorAgencia() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaAgencia(String nombre, String direccion) {
    	if(!validarAgencia(nombre,direccion)) {
    		System.out.println("La agencia no existe");
    		Agencia nAgencia = new Agencia (nombre,direccion,"Pendiente");
    		em.persist(nAgencia);
    		System.out.println("Cree la agencia");
    		
    	}else {
    		System.out.println("La agencia existe");
    	}
    	
    }
    
    private boolean validarAgencia(String nombre, String direccion) {
		try {
			Query q = em.createQuery("SELECT a FROM Agencia a WHERE a.nombre LIKE :nom AND a.direccion LIKE dire")
					.setParameter("nom", nombre)
					.setParameter("dire", direccion);
			Agencia ap = (Agencia) q.getSingleResult();
			if(ap != null ) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    
    /*
     * public List findWithName(String name) {
    return em.createQuery(
        "SELECT c FROM Customer c WHERE c.name LIKE :custName")
        .setParameter("custName", name)
        .getResultList();
}
     */



}
