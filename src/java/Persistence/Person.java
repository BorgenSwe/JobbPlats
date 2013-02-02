
package Persistence;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * This abstract class represents a person and is extended by Applicant 
 * and Recruiter
 * @author Jocke
 */
@Entity
@Table(name="Person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING,length=20)
@DiscriminatorValue("P")
public class Person implements PersonDTO {
    /**
     * Id of the person
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    /**
     * First name of the person 
     */
    protected String name;
    
    /**
     * Surname of the person
     */
    protected String surname;

    /***************
     * GET and SET * 
     ***************/
    public Long getId() {
        return id;
    }
    protected void setId(Long id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }
    @Override
    public String getSurname() {
        return surname;
    }
    protected void setSurname(String surname) {
        this.surname = surname;
    }
}
