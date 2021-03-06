

package Persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * This entity represent a period of time where an applicant is available for 
 * work
 * @author Joakim Borgström
 */
@Entity
public class Availability implements Serializable, AvailabilityDTO {
    private static final long serialVersionUID = 1L;
    
    /**
     * Id of the Availability entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="availability_id")
    private Long id;

    /**
     * From date
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="from_date")
    private Date datefrom;
    
    /**
     * To date
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="to_date")
    private Date dateto;
    
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
    public Date getDatefrom() {
        return datefrom;
    }
    protected void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }
    @Override
    public Date getDateto() {
        return dateto;
    }
    protected void setDateto(Date dateto) {
        this.dateto = dateto;
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
        if (!(object instanceof Availability)) {
            return false;
        }
        Availability other = (Availability) object;
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
        return "Persistence.Availability[ id=" + id + " ]";
    }

    
    
}
