/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Austin Beal
 * Section: 02 - 9:50
 * Date: 11/17/21
 * Time: 10:16 AM
 *
 * Project: csci205_final_project
 * Package: a.b.baseclass
 * Class: Task
 *
 * Description:
 *
 * ****************************************
 */

package SchedulerMVC;

import java.time.LocalDate;

/**
 * The class that represents the Tasks for the users to do within the program
 * Has simple information, such as the task's name and when it is due
 */
public class Task {

    /**A LocalDate variable that represents when the Task was entered into the program**/
    private LocalDate entryDate;

    /**A LocalDate variable that represents when the Task is due*/
    private LocalDate dueDate;

    /**A String representing the name of the task*/
    private String taskName;

    /*A String containing the type of task that it is**/
    private String taskType;

    /**An int value that is calculated to be the number of days left until a task is due*/
    private int daysUntilDue;

    /**
     * The constructor for a Task object. Takes in the four data types for the Task,
     * and initializes them
     *
     * @param entryDate a LocalDate representing when the Task was entered
     * @param dueDate a LocalDate representing when the Task is due
     * @param taskName a String representing the name of the Task
     * @param taskType a String representing the type of the Task
     */
    public Task(LocalDate entryDate, LocalDate dueDate, String taskName, String taskType) {
        //Initialize all the data types of the Task
        this.entryDate = entryDate;
        this.dueDate = dueDate;
        this.taskName = taskName;
        this.taskType = taskType;
    }

    /**
     * A helper method that returns when the Task was entered
     *
     * @return a LocalDate variable representing when the Task was entered
     */
    public LocalDate getEntryDate() {
        return entryDate;
    }

    /**
     *  A helper method allowing the user to set when the Task was entered
     *
     * @param entryDate a LocalDate variable that contains the updated entryDate for the Task
     */
    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
}
