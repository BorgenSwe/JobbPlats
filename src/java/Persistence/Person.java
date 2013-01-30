
package Persistence;

/**
 * This abstract class represents a person and is extended by Applicant 
 * and Recruiter
 * @author Jocke
 */
public abstract class Person {
    /**
     * First name of the person 
     */
    String name;
    /**
     * Surname of the person
     */
    String surname;

    /***************
     * GET and SET * 
     ***************/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
}
