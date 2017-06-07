/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.ejb;

import javax.ejb.Local;

/**
 *
 * @author ipd
 */
@Local
public interface CalculatorEJBLocal {

    double add(double val1, double val2);
    
}
