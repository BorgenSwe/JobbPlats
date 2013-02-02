package Persistence;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This entity represent a recruiter working at the company.
 * @author Jocke
 */
@Entity
@DiscriminatorValue("R")
public class Recruiter extends Person implements Serializable, RecruiterDTO {
    private static final long serialVersionUID = 1L;
    
    /**
     * Username of the recruiter
     */
    private String username;
    
    /**
     * password of the recruiter
     */
    private String password;
    
    /***************
     * GET and SET * 
     ***************/
    @Override
    public String getUsername() {
        return username;
    }
    protected void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    protected void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Recruiter)) {
            return false;
        }
        Recruiter other = (Recruiter) object;
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
        return "Persistence.Recruiter[ id=" + id + " ]";
    }
    
}
