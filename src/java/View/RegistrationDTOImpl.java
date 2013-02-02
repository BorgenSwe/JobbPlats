/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author 573w3
 */
public class RegistrationDTOImpl implements RegistrationDTO {
    
    private String name;
    private String surname;
    private String ssn;
    private String email;
    private CompetenceProfileDTOImpl[] competences;
    private AvailabilityDTOImpl[] availabilities;
    
    
    public RegistrationDTOImpl() {
        competences = new CompetenceProfileDTOImpl[10];
        
        for (int i = 0; i < competences.length; i++) {
            competences[i] = new CompetenceProfileDTOImpl();
        }
    }
    
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
    
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public CompetenceProfileDTO[] getCompetence() {
        return competences;
    }
    
    public AvailabilityDTO[] getAvailabilty() {
        return availabilities;
    }
}
