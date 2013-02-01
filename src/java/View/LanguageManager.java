/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Locale;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author 573w3
 */
@Named(value = "languageManager")
@ManagedBean
public class LanguageManager {

    /**
     * Creates a new instance of LanguageManager
     */
    public LanguageManager() {
    }
    
    public void change() {
        System.out.println("Nuvarande locale: " + FacesContext.getCurrentInstance().getViewRoot().getLocale());
        //FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("sv"));
        if (FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage().equals(Locale.ENGLISH.getLanguage())) {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.FRENCH);
        } else FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
    }
}
