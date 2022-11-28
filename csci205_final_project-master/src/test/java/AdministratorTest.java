import SchedulerMVC.Administrator;
import SchedulerMVC.Task;
import SchedulerMVC.User;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class for our Administrator object, where we test several of the methods
 * that are used within the class
 */
class AdministratorTest {

    /**The Administrator that will be used throughout the tests*/
    private Administrator a;

    /**The User that will be used throughout the tests*/
    private User u;

    @BeforeEach
    void setUP(){
        //Before each test, create a new Admin, and a new User, to be used in the testing
        u = new User("Austin", 19, LocalDate.now());
        a = new Administrator("Lawrence", 25, LocalDate.now(), "lJ201", "1234");
    }

    @org.junit.jupiter.api.Test
    //The test to assign a task to a user
    void assignTask() {
        //Create a new task and assign it to the user
        Task t = new Task(LocalDate.now(), LocalDate.now(), "Homework 1", "School");
        a.assignTask(u, t);
        //Make sure that the User's list of task contains the task that was just added
        assertTrue(u.getListOfTasks().contains(t));

    }
    //The test to determine whether a user was successfully added to the system
    @org.junit.jupiter.api.Test
    void addUser() {
        //Add the User to the Admin's list of Users
        a.addUser(u);
        //Test to see that the Admin's list of users contains the User that was just added
        assertTrue(a.getListOfUsers().contains(u));
    }

    //Test to see if getUsername accurately returns the username of the Admin
    @org.junit.jupiter.api.Test
    void getUserName() {
        //See if the method returns the username that we know it is
        assertEquals(a.getUserName(), "lJ201");
    }

    //Test to see if getPassword accurately returns the password of the Admin
    @org.junit.jupiter.api.Test
    void getPassword() {
        //See if the method returns the password that we know it is
        assertEquals(a.getPassword(), "1234");
    }

    @org.junit.jupiter.api.Test
    //Test to see if getListOfUsers accurately returns the Admin's list of Users
    void getListOfUsers() {
        //Add the user to the Admin's list of Users
        a.addUser(u);
        //Create a temp list, and add that User to the list as well
        ArrayList<User> tempList = new ArrayList<>();
        tempList.add(u);
        //Test to see if these two lists are accurate
        assertEquals(a.getListOfUsers(), tempList);
    }
}