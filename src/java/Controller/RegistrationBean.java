
package Controller;

import Persistence.Competence;
import Persistence.CompetenceDTO;
import Persistence.RegistrationDOA;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * EJB that operates in the applications business layer. 
 * The RegistrationManager class injects this EJB and uses it to process 
 * business logic and communicate with the persistence layer. 
 * @author 573w3
 */
@Stateless
public class RegistrationBean {

    //@EJB
    //private RegistrationDOA persistence;
    
    public List<CompetenceDTO> getAllCompetences() {
        return new ArrayList<CompetenceDTO>();//persistence.getAllComptences();
    }
}
