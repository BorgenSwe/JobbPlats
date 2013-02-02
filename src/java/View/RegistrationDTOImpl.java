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
        availabilities = new AvailabilityDTOImpl[10];
        
        for (int i = 0; i < competences.length; i++) {
            competences[i] = new CompetenceProfileDTOImpl();
            availabilities[i] = new AvailabilityDTOImpl();
        }
    }
    
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
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
    
    @Override
    public CompetenceProfileDTO[] getCompetence() {
        return competences;
    }
    
    @Override
    public AvailabilityDTO[] getAvailabilty() {
        return availabilities;
    }
}
