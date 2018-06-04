package sessions;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ControladorAgencia
 */
@Stateless
@LocalBean
public class ControladorAgencia implements ControladorAgenciaRemote, ControladorAgenciaLocal {

    /**
     * Default constructor. 
     */
    public ControladorAgencia() {
        // TODO Auto-generated constructor stub
    }

}
