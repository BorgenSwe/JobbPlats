
package Persistence;

import java.util.Date;

/**
 * DTO of Availability
 * @author Joakim
 */
public interface AvailabilityDTO {
    /***************
     * GET and SET * 
     ***************/
    public Long getId();
    public Date getDatefrom();
    public Date getDateto();
}
