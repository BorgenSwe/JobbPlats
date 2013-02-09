
package View;

import Controller.LanguageBean;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * This managed bean handles the locale-setting in the view
 * @author 573w3
 */
@Named(value = "languageManager")
@ManagedBean
@RequestScoped
public class LanguageManager implements Serializable {

    @EJB
    private LanguageBean languageBean;
    
    /**
     * Creates a new instance of LanguageManager
     */
    public LanguageManager() {
    }
    
    public void changeLanguage(String lang) {
        languageBean.changeLanguage(lang);
    }
}
