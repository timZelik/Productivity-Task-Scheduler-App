/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Austin Beal
 * Section: 02 - 9:50
 * Date: 11/22/21
 * Time: 6:30 PM
 *
 * Project: csci205_final_project
 * Package: SchedulerMVC
 * Class: GUIModel
 *
 * Description:
 *
 * ****************************************
 */

package SchedulerMVC;

import java.time.LocalDate;


/**
 * The class that contains the Model for the MVc. The model is responsible
 * for storing and handling the data of the program. In this class, we instantiate an
 * Administrator as well as several users
 */
public class GUIModel {

    /**The Administrator object representing the current admin of the application*/
    private Administrator admin;

    /**
     * The constructor for the Model of the application. The constructor initializes the
     * Administrator, as well as creates three sample users to be added to the program as well
     */
    public GUIModel() {
        //Initializes the new Administrator of the project
        admin = new Administrator("Austin", 19, LocalDate.now(), "alb049", "20221");
        //Creates three new sample users
        User u = new User("Tim", 19, LocalDate.now());
        User u2 = new User("Conrad", 19, LocalDate.now());
        User u3 = new User("Jordan", 19, LocalDate.now());
        //Adds these sample users to the program
        admin.addUser(u);
        admin.addUser(u2);
        admin.addUser(u3);

    }

    /**
     * A helper method that returns the admin of the program
     *
     * @return admin, the object representing the administrator of the program
     */
    public Administrator getAdmin() {
        return admin;
    }

    /**
     * Allows the user to set the admin based on information put in by the user
     *
     * @param u a User object containing the new User to become the admin
     * @param username, a String containing the new Admin's username
     * @param password, a String containing the new Admin's password
     */
    public void setAdmin(User u, String username, String password){
        admin = new Administrator(u.getName(), u.getAge(), u.getBirthday(), username, password);
    }
}
