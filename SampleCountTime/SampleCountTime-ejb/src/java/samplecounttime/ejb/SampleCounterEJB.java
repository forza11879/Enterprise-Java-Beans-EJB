/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplecounttime.ejb;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import static javax.ejb.ConcurrencyManagementType.CONTAINER;
import javax.ejb.Singleton;

/**
 *
 * @author John
 */
@Singleton
@ConcurrencyManagement(CONTAINER)
@AccessTimeout(value = 120000)
public class SampleCounterEJB implements SampleCounterEJBRemote {
    
    private int counter;

    @Override
    public void registerVisit() {
        System.out.println("registerVisit()");
        counter++;
    }

    @Override
    public int getTotalVisitCount() {
        System.out.println("getTotalVisitCount()");
        return counter;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
