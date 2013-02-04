/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jonas
 */
public class AvailabilityDTOImpl implements AvailabilityDTO {
    private Date from;
    private Date to;
    
    private Date parseDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // Gör så att det måste vara exakt det angivna formatet
        //format.setLenient(false); 
        
        try {
            Date date = format.parse(str);
            return date != null ? date : null;
        } catch (ParseException ex) {
            System.out.println("errorz");
        }
        return null;
    }

    @Override
    public Date getFrom() {
	return from;
    }

    public void setFrom(String from) {
        this.from = parseDate(from);
    }

    @Override
    public Date getTo() {
	return to;
    }

    public void setTo(String to) {
	this.to = parseDate(to);
    }
}
