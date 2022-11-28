/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Austin Beal
 * Section: 02 - 9:50
 * Date: 11/17/21
 * Time: 10:27 AM
 *
 * Project: csci205_final_project
 * Package: a.b.baseclass
 * Class: Administrator
 *
 * Description:
 *
 * ****************************************
 */

package SchedulerMVC;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *The class for the administrator of the application. The administrator is another user
 * of the application, thus why it is extended from User, but it also has more
 * functionality than user, such as login information and the ability to assign
 * tasks to other users
 */
public class Administrator extends User {

    /**A List representing all the users in the program that the Administrator has access to*/
    private List<User> listOfUsers;

    /**A String containing the username of the Admin*/
    private String userName;

    /**A String containing the password of the Admin*/
    private String password;

    private String user;

    /**
     * The constructor of the Administrator, which calls the constructor for its super
     * class, User, and the initializes the Admin's username and password
     *
     * @param name, A string containing the name of the administrator
     * @param age, an int containing the age of the admin
     * @param bd, a LocalDate variable containing the birthday of the admin
     * @param userName a String that contains the admin's username
     * @param password a String representing the password of the admin
     */
    public Administrator(String name, int age, LocalDate bd, String userName, String password){
        //Call to User, initialize the username and password
        super(name, age, bd);
        this.userName = userName;
        this.password = password;
        //Initialize the list of users as an empty ArrayList ready to be populated
        this.listOfUsers = new ArrayList<>();
    }



    /**
     * Takes in a user and a task, and adds that task to the user
     *
     * @param u, the User that the task is being assigned to
     * @param t, the Task that is being assigned to the user
     */
    public void assignTask(User u, Task t){
        u.addTask(t);
    }

    /**
     * Allows the Admin to add a new User to the program, taking in all the
     * necessary data to create the User. The user is then added to the Admin's
     * list of users
     *
     * @param name , A String containing the name of the User being added
     * @param age , An int containing the age of the User being added
     * @param bd , A LocalDate containing the birthday of the User being added
     */
    public void addUser(String name, int age, LocalDate bd){
        User u = new User(name, age, bd);
        listOfUsers.add(u);
    }

    /**
     * Another method allowing the Administrator to add a User to the program
     * The user is already created, so the given User is simply added to the list
     *
     * @param u , The User to be added to the program
     */
    public void addUser(User u){
        listOfUsers.add(u);
    }

    /**
     * A method that displays the administrator of the program, as well as the users
     * and the amount of tasks that they have remaining
     */
    public void seeUsers(){
        //First print out the administrator
        System.out.println(this.name + ": Administrator");
        //Loop through the list of users
        for(int i = 0; i < listOfUsers.size(); i++){
            User u = listOfUsers.get(i);
            //Print out the user's name and the number of tasks they have remaining
            System.out.println(u.name + " (User): " + u.numTasks() + " tasks remaining");
        }
    }

    /**
     * A helper method to get the username of the Admin
     *
     * @return The String containing the username of the Admin
     */
    public String getUserName() {
        return userName;
    }

    /**
     * A helper method to get the password of the Admin
     *
     * @return The String containing the password of the Admin
     */
    public String getPassword() {
        return password;
    }

    /**
     * A helper method to get the list of users of the Admin
     *
     * @return The ArrayList containing the list of users of the Admin
     */
    public List<User> getListOfUsers() {
        return listOfUsers;
    }
}
