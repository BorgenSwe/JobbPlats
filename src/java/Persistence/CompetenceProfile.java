
package Persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jocke
 */
@Entity
@Table(name = "competence_profile")
public class CompetenceProfile implements Serializable, CompetenceProfileDTO {
    private static final long serialVersionUID = 1L;
    
    /**
     * Id of the competence. Used by JPA
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="competence_profile_id")
    private Long id;

    /**
     * Number of years of experience. 1 decimal possible.
     */
    @Column(name="years_of_experience")
    private float years;
    
    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="competence_id")
    private Competence competence;
    
    @ManyToOne
    @JoinColumn(name="person_id")
    private Applicant applicant;
    
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
    public float getYears() {
        return years;
    }
    protected void setYears(float years) {
        this.years = years;
    }

    @Override
    public Competence getCompetenceType() {
        return competence;
    }

    protected void setCompetenceType(Competence competence) {
        this.competence = competence;
    }
    protected void setApplicant(Applicant applicant) {
        this.applicant = applicant;
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
        if (!(object instanceof CompetenceProfile)) {
            return false;
        }
        CompetenceProfile other = (CompetenceProfile) object;
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
        return "Persistence.CompetenceProfile[ id=" + id + " ]";
    }
}
