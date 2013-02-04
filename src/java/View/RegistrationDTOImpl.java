
package View;

/**
 * Holds data about a registration as it is sent from the view down to the 
 * persistence layer. 
 * @author 573w3
 */
public class RegistrationDTOImpl implements RegistrationDTO {
    
    private static int CAPACITY = 10;
    
    private String name;
    private String surname;
    private String ssn;
    private String email;
    private CompetenceProfileDTOImpl[] competences;
    private AvailabilityDTOImpl[] availabilities;
    
    /**
     * Constructor
     */
    public RegistrationDTOImpl() {
        competences = new CompetenceProfileDTOImpl[CAPACITY];
        availabilities = new AvailabilityDTOImpl[CAPACITY];
        
        for (int i = 0; i < CAPACITY; i++) {
            competences[i] = new CompetenceProfileDTOImpl();
            availabilities[i] = new AvailabilityDTOImpl();
        }
    }
    
    /***************
     * GET and SET * 
     ***************/
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
    public CompetenceProfileDTOImpl[] getCompetence() {
        return competences;
    }
    public void setCompetence(CompetenceProfileDTOImpl[] competences) {
        this.competences = competences;
    }
    @Override
    public AvailabilityDTOImpl[] getAvailability() {
        return availabilities;
    }
    public void setAvailability(AvailabilityDTOImpl[] availabilities) {
        this.availabilities = availabilities;
    }
}
