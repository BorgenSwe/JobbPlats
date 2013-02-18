/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Locale;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

/**
 * Controls what locale is set and makes it possible to display the site in 
 * different languages. 
 * @author 573w3
 */
@Stateless
public class LanguageBean {
    
    /**
     * Change the language by setting the locale. 
     * @param lang The locale to be set. 
     */
    public void changeLanguage(String lang) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(
                                                            new Locale(lang));
    }
}
