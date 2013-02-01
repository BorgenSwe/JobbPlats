/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Jocke
 */
public interface RegistrationDTO {
    public String getName();
    public String getSurname();
    public String getSsn();
    public String getEmail();
    public CompetenceProfileDTO[] getCompetence();
    public AvailabilityDTO[] getAvailabilty();
}
