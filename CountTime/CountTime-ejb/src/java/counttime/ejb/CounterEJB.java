/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counttime.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import static javax.ejb.ConcurrencyManagementType.CONTAINER;
import javax.ejb.Lock;
import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;
import javax.ejb.Singleton;

/**
 *
 * @author ipd
 */
@Singleton
@ConcurrencyManagement(CONTAINER)
@AccessTimeout(value = 120000)
public class CounterEJB implements CounterEJBRemote {

   private int counter;
    
    @PostConstruct
    public void initialize() {

        
    }
    
    
    @Override
    @Lock(WRITE)
    public void registerVisit() {
        System.out.println("registerVisit()");
        counter++;
    }

    @Override
    @Lock(READ)
    public int getTotalVisitCount() {
        System.out.println("getTotalVisitCount()");
        return counter;
    }

  
}
