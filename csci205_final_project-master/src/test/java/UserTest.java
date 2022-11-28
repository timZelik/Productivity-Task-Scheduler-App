import SchedulerMVC.Task;
import SchedulerMVC.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class for the User object, where several of the methods
 * found within that class are tested
 */
class UserTest {

    /**The User that will be used throughout each test*/
    private User u;

    @BeforeEach
    //Before each test, initialize our User object
    void setUp(){

        u = new User("Austin", 19, LocalDate.now());
    }

    @Test
    //Test to see if the addTask method successfully adds tasks
    void addTask() {
        //Create the new task, and add it to the user
        Task t = new Task(LocalDate.now(), LocalDate.now(), "Homework #25", "School");
        u.addTask(t);
        //Test to see if the task is in the User's list of tasks
        assertTrue(u.getListOfTasks().contains(t));
    }

    @Test
    //A test to see numTasks accurately returns the number of tasks the user is assigned
    void numTasks() {
        //See that the list is initially empty
        assertEquals(u.numTasks(), 0);
        //Create and add three tasks to the User's list
        Task t1 = new Task(LocalDate.now(), LocalDate.now(), "Homework #25", "School");
        Task t2 = new Task(LocalDate.now(), LocalDate.now(), "Walk Dog", "Personal");
        Task t3 = new Task(LocalDate.now(), LocalDate.now(), "Meeting @ 7", "Work");
        u.addTask(t1);
        u.addTask(t2);
        u.addTask(t3);
        //See that the numTasks() now returns 3
        assertEquals(u.numTasks(), 3);
    }

    @Test
    //Test to see if getBirthday works
    void getBirthday() {
        //See if getBirthday returns the birthday that was assigned for the user
        assertEquals(u.getBirthday(), LocalDate.now());
    }

    @Test
    //Test to see if getListOfTasks() returns an accurate list of tasks
    void getListOfTasks() {
        //Create 3 Tasks and add them to the user's list
        Task t1 = new Task(LocalDate.now(), LocalDate.now(), "Homework #25", "School");
        Task t2 = new Task(LocalDate.now(), LocalDate.now(), "Walk Dog", "Personal");
        Task t3 = new Task(LocalDate.now(), LocalDate.now(), "Meeting @ 7", "Work");
        u.addTask(t1);
        u.addTask(t2);
        u.addTask(t3);
        //Create a temp list of Tasks, and add the same 3 Tasks
        ArrayList<Task> tempList = new ArrayList<>();
        tempList.add(t1);
        tempList.add(t2);
        tempList.add(t3);
        //Test to see if these lists are equal to each other
        assertEquals(u.getListOfTasks(), tempList);
    }

}