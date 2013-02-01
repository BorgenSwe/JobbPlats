/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * This entity represent a applicant for a job
 * @author Jocke
 */
@Entity
public class Applicant extends Person implements Serializable, ApplicantDTO {
    private static final long serialVersionUID = 1L;
    
    /**
     * Id of the applicant
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Social Security Number (Svenska: Personnummer)
     */
    private String ssn;
    
    /**
     * Email address
     */
    private String email;
    
    /**
     * The dates the applicant is available for work
     */
    @OneToMany
    private List<Availability> availability;
    
    /**
     * The competence and experience of the applicant
     */
    @OneToMany
    private List<CompetenceProfile> competence;
    
    /***************
     * GET and SET * 
     ***************/
    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    @Override
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Availability> getAvailability() {
        return availability;
    }
    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }
    public List<CompetenceProfile> getCompetence() {
        return competence;
    }
    public void setCompetence(List<CompetenceProfile> competence) {
        this.competence = competence;
    }
    @Override
    public List<AvailabilityDTO> getAvailabilityDTO() {
        return null;
    }
    @Override
    public List<CompetenceProfileDTO> getCompetenceDTO() {
        return null;
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
        if (!(object instanceof Applicant)) {
            return false;
        }
        Applicant other = (Applicant) object;
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
        return "Persistence.Applicant[ id=" + id + " ]";
    }
}
