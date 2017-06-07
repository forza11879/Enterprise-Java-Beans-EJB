/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletodo.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author John
 */
public class SampleTodoItem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static int counter;
    
    public SampleTodoItem() { }

    public SampleTodoItem(String task, Date dueDate, boolean isDone) {
        
         id = ++counter;
        setTask(task);
        setDueDate(dueDate);
        setIsDone(isDone);
    }

    private int id;
    private String task;
    private Date dueDate;
    private boolean isDone;

    /**
     * @return the id
     */
    @Override
    public String toString() {
        return String.format("%d: %s due %s is %s", getId(), getTask(), getDueDate(),
                isIsDone() ? "done" : "pending");
    }
    
    
    
    public int getId() {
        return id;
    }

    /**
     * @return the task
     */
    public String getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(String task) {
        
        if (task.isEmpty()) {
            throw new IllegalArgumentException("Task description must not be emtpy");
        }
        
        this.task = task;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the isDone
     */
    public boolean isIsDone() {
        return isDone;
    }

    /**
     * @param isDone the isDone to set
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
    
    
    
    
    

}
