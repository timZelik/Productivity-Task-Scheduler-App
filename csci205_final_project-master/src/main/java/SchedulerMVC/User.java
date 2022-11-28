/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Austin Beal
 * Section: 02 - 9:50
 * Date: 11/19/21
 * Time: 10:26 AM
 *
 * Project: csci205_final_project
 * Package: a.b.baseclass
 * Class: User
 *
 * Description:
 *
 * ****************************************
 */

package SchedulerMVC;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The class that represents the Users of the program, The Users have a few data pieces to
 * represent them, including their name and age
 */
public class User {
    //All of these data fields are protected so that the inheriting Admin class will
    //be able to access them as well

    /**A String representing the name of the User*/
    protected String name;

    /**An int value representing the age of the User*/
    protected int age;

    /**A LocalDate representing the birthday of the User*/
    protected LocalDate birthday;

    /**An ArrayList that contains a list of Tasks for the User to Complete  */
    protected ArrayList<Task> listOfTasks;

    /**
     * The constructor for the User class, which initializes
     *  the name, age and birthday of the User, as well as sets
     *  listOfTasks as an empty ArrayList
     *
     * @param name a String representing the name of the User
     * @param age, an int value representing the age of the User
     * @param bd, a LocalDate variable representing the User's birthday
     */
    public User(String name, int age, LocalDate bd){
        //Initialize all three of the input parameters
        this.name = name;
        this.age = age;
        this.birthday = bd;
        //Initialize listOfTasks as an empty ArrayList to be populated with Tasks
        this.listOfTasks = new ArrayList<>();

    }

    /**
     * A helper method that takes in a Task and adds it to the User's list of Tasks
     *
     * @param t, the Task to be added to the User's list of Tasks
     */
    public void addTask(Task t){
     this.listOfTasks.add(t);
    }

    /**
     * A helper method to return the number of tasks the User has to do
     *
     * @return an int, the size of listOfTasks, indicating the number of
     * Tasks the User has to complete
     */
    public int numTasks(){
        return this.listOfTasks.size();
    }

    /**
     * The User's name, as a String
     *
     * @return a String containing the name of the User
     */
    public String getName() {
        return name;
    }

    /**
     * A helper method to return the age of the User
     *
     * @return an int value containing the age of the User
     */
    public int getAge() {
        return age;
    }

    /**
     * A helper method to return the User's birthday
     *
     * @return a LocalDate variable indicating the User's birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * A helper method to return the list of Tasks the User must complete
     *
     * @return an ArrayList containing the Tasks for the User to complete
     */
    public ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }
}
