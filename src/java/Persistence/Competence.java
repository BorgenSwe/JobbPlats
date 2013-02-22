
package Persistence;

import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * This entity represent a type of competence available in the system.
 * @author Joakim Borgström
 */
@Entity
public class Competence implements Serializable, CompetenceDTO {
    private static final long serialVersionUID = 1L;
    
    /**
     * Id of the competence type
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="competence_id")
    private Long id;

    /**
     * Name of the competence type. 
     * A list of localizations.
     */
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy="competenceFor")
    private List<Localization> name;
    
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
        String language = FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
        for(Localization localization:name) {
            if(localization.getLang().equalsIgnoreCase(language)) {
                return localization.getTrans();
            }
        }
        return name.get(0).getTrans();
    }
    protected void setName(String name) {
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
        Competence other = (Competence) object;
        if (!this.id.equals(other.id)) {
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
        return getName();
    }
}
