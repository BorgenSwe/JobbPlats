/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Locale;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

/**
 *
 * @author 573w3
 */
@Stateless
public class LanguageBean {
    
    public void changeLanguage(String lang) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(
                                                            new Locale(lang));
    }
}
