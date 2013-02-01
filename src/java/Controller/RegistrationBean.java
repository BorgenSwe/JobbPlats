/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Persistence.Competence;
import Persistence.CompetenceDTO;
import Persistence.RegistrationDOA;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
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
