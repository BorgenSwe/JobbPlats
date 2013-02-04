
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

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((CompetenceDTO)value).getName();
    }
}