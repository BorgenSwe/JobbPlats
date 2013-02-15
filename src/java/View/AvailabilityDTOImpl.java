
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Jonas
 */
public class AvailabilityDTOImpl implements AvailabilityDTO {
    private Date from;
    private Date to;
    @Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}|^$", message="Invalid to date")
    private String stringTo;
    @Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}|^$", 
                                                    message="Invalid from date")
    private String stringFrom;
    
    private Date parseDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // Gör så att det måste vara exakt det angivna formatet
        //format.setLenient(false); 
        
        try {
            Date date = format.parse(str);
            return date != null ? date : null;
        } catch (ParseException ex) {
            
        }
        return null;
    }

    /**
     * Constructor
     */
    public AvailabilityDTOImpl(){
        
    }
    
    /***************
     * GET and SET * 
     ***************/
    @Override
    public Date getFrom() {
	return from;
    }
    public String getStringFrom() {
        return stringFrom;
    }
    public void setStringFrom(String from) {
        this.from = parseDate(from);
        stringFrom = from;
    }
    @Override
    public Date getTo() {
	return to;
    }
    public String getStringTo() {
        return stringTo;
    }
    public void setStringTo(String to) {
	this.to = parseDate(to);
        stringTo = to;
    }
}
