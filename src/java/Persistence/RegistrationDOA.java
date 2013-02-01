
package Persistence;

import View.RegistrationDTO;
import java.util.List;

/**
 * 
 * @author Jocke
 */
public interface RegistrationDOA {
    public void register(RegistrationDTO registration);
    public List<Competence> getAllComptences();
}
