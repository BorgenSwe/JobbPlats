
package Persistence;

import java.io.Serializable;
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
     * A list of localizations.
     */
    //@OneToMany
    //private List<Localization> name;
    private String name;
    
    /***************
     * GET and SET * 
     ***************/
    @Override
    public Long getId() {
        return id;
    }
    protected void setId(Long id) {
        this.id = id;
    }
    @Override
    public String getName() {
        /*String language = FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
        
        for(Localization localization:name) {
            if(localization.getLang().equalsIgnoreCase(language)) {
                return localization.getTrans();
            }
        }
        
        return name.get(0).getTrans();*/
        
        return name;
    }
    protected void setName(String name) {
        this.name = name;
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
