
package Persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This entity is used for localization of words in the database. The entity 
 * contains the language of the translation and the translated text.
 * @author Joakim Borgström
 */
@Entity
public class Localization implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Id of the localization
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="localization_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="competence_for")
    private Competence competenceFor;
    
    /**
     * Language of the localization
     */
    @Column(name="word_language")
    private String lang;
    
    /**
     * Translation to the language above
     */
    @Column(name="word_translation")
    private String trans;
    
    /***************
     * GET and SET * 
     ***************/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }
    public String getTrans() {
        return trans;
    }
    public void setTrans(String trans) {
        this.trans = trans;
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
        if (!(object instanceof Localization)) {
            return false;
        }
        Localization other = (Localization) object;
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
        return "Persistence.Localization[ id=" + id + " ]";
    }
}
