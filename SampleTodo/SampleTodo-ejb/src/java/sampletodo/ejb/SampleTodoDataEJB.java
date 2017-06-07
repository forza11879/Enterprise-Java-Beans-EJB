/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletodo.ejb;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import static javax.ejb.ConcurrencyManagementType.CONTAINER;
import javax.ejb.Lock;
import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;
import javax.ejb.Singleton;
import sampletodo.entities.SampleTodoItem;

/**
 *
 * @author John
 */
@Singleton
@ConcurrencyManagement(CONTAINER)
@AccessTimeout(value=120000)
public class SampleTodoDataEJB implements SampleTodoDataEJBRemote {

 
    private ArrayList<SampleTodoItem> todoList;

    @PostConstruct
    public void initialize() {
        
        System.out.println("SampleTodoDataEJB.initalize()");
        todoList = new ArrayList<>();
        
    }

    @Override
    @Lock(READ)
    public SampleTodoItem[] getAllTodoItems() {
        System.out.println("SampleTodoDateEJB.getAllTodoItems()");
        return todoList.toArray(new SampleTodoItem[0]);
    }

    @Override
    @Lock(WRITE)
    public void addTodoItem(SampleTodoItem item) {
        System.out.println("SampleTodoDataEJB.addTodoItem()");
        todoList.add(item);
    }
   
}
