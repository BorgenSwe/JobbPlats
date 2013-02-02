/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Date;

/**
 *
 * @author Jonas
 */
public class AvailabilityDTOImpl implements AvailabilityDTO {
    private Date from;
    private Date to;

    @Override
    public Date getFrom() {
	return from;
    }

    public void setFrom(Date from) {
	this.from = from;
    }

    @Override
    public Date getTo() {
	return to;
    }

    public void setTo(Date to) {
	this.to = to;
    }
    
    
}
