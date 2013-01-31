
package Persistence;

/**
 *
 * @author Joakim
 */
public interface RecruiterDTO extends PersonDTO{
    /***************
     * GET and SET * 
     ***************/
    public Long getId();
    public String getUsername();
    public String getPassword();
}
