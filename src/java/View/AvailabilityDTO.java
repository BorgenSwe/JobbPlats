
package View;

import java.util.Date;

/**
 * DTO of a availability period in a registration
 * @author Jocke
 */
public interface AvailabilityDTO {
    /***************
     * GET and SET * 
     ***************/
    public Date getFrom();
    public Date getTo();
}
