
package View;

import Persistence.CompetenceDTO;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * This converter converts strings to competence and vice versa.
 * @author 573w3
 */
public class ListConverter implements Converter {

    /**
     * Retrieves the Object representation of a CompetenceDTO
     * @param context FacesContext
     * @param component UIComponent
     * @param value String representation of the Object
     * @return Object representation
     */
    @Override
    public Object getAsObject(FacesContext context, 
                                        UIComponent component, String value) {
        RegistrationManager regMan = context.getApplication().
                evaluateExpressionGet(context, "#{registrationManager}", 
                                                    RegistrationManager.class);
        
        List<CompetenceDTO> comps = regMan.getCompetenceNames();
        
        for (int i = 0; i < comps.size(); i++) {
            if (comps.get(i).getName().equals(value)) {
                return comps.get(i);
            }
        }
        
        return null;
    }

    /**
     * Retrieves the String representation of a CompetenceDTO
     * @param context FacesContext
     * @param component UIComponent
     * @param value Object that is being parsed as String
     * @return String representation
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((CompetenceDTO)value).getName();
    }
}