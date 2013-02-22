
package Persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * This entity represent a applicant for a job
 * @author Joakim Borgström
 */
@Entity
@DiscriminatorValue("A")
public class Applicant extends Person implements Serializable, ApplicantDTO {
    private static final long serialVersionUID = 1L;
    
    /**
     * Social Security Number (Svenska: Personnummer)
     */
    @Column(name="ssn")
    private String ssn;
    
    /**
     * Email address
     */
    @Column(name="email")
    private String email;
    
    /**
     * The dates the applicant is available for work
     */
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy="applicant")
    private List<Availability> availability;
    
    /**
     * The competence and experience of the applicant
     */
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy="applicant")
    private List<CompetenceProfile> competence;
    
    /***************
     * GET and SET * 
     ***************/
    @Override
    public String getSsn() {
        return ssn;
    }
    protected void setSsn(String ssn) {
        this.ssn = ssn;
    }
    @Override
    public String getEmail() {
        return email;
    }
    protected void setEmail(String email) {
        this.email = email;
    }
    public List<Availability> getAvailability() {
        return availability;
    }
    protected void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }
    public List<CompetenceProfile> getCompetence() {
        return competence;
    }
    protected void setCompetence(List<CompetenceProfile> competence) {
        this.competence = competence;
    }
    @Override
    public List<AvailabilityDTO> getAvailabilityDTO() {
        List<AvailabilityDTO> availDTO = new ArrayList();
        for(Availability a:availability){
            availDTO.add(a);
        }
        return availDTO;
    }
    @Override
    public List<CompetenceProfileDTO> getCompetenceDTO() {
        List<CompetenceProfileDTO> compDTO = new ArrayList();
        for(CompetenceProfile c:competence){
            compDTO.add(c);
        }
        return compDTO;
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
        return "Applicant Id=" + id + ", Name=" + name + ", Surname=" + surname + ", SSN=" 
                + ssn + ", Email=" + email;
    }
}
