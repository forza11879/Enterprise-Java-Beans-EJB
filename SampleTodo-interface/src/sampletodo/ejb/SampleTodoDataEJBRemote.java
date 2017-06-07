/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletodo.ejb;

import javax.ejb.Remote;
import sampletodo.entities.SampleTodoItem;

/**
 *
 * @author John
 */
@Remote
public interface SampleTodoDataEJBRemote {

    public SampleTodoItem[] getAllTodoItems();

    public void addTodoItem(SampleTodoItem item);

}
