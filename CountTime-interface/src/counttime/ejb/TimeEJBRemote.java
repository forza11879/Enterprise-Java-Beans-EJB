/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counttime.ejb;

import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author ipd
 */
@Remote
public interface TimeEJBRemote {
    
    public Date getCurrentDateTime(); // returns java.util.Date object with current time of the server
    
}
