/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This entity represent a type of competence available in the system.
 * @author Jocke
 */
@Entity
public class Competence implements Serializable, CompetenceDTO {
    private static final long serialVersionUID = 1L;
    
    /**
     * Id of the competence type
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the competence type. 
     * The map is used for internationalization. The key is the locale code("sv"
     * for swedish and "en" for english).
     */
    private Map<String, String> name;
    
    /***************
     * GET and SET * 
     ***************/
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public String getName() {
        return name.get(FacesContext.getCurrentInstance().getViewRoot().getLocale().toString());
    }

    /**
     * Generates a hash code
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    /**
     * Checks if the object is equal to another object
     * @param object
     * @return whether or not the objects are equal
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    /**
     * creates a string representation of the object 
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        return "Persistence.Competence[ id=" + id + " ]";
    }
}
