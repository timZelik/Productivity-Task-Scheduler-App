import SchedulerMVC.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 *The Test class for our Task object, where we test the methods that are
 * associated with the Task object
 */
class TaskTest {

    /**The Task object to be used throughout the tests*/
    private Task t;

    /**A LocalDate to be used throughout the test class*/
    private LocalDate newDate;

    @BeforeEach
    //Before each test, instantiate the task and the new date
    void setUp(){
        //Set new date to be tomorrow
        newDate = LocalDate.now().plusDays(1);
        //Instantiate the task
        t = new Task(LocalDate.now(), newDate, "Homework #7", "School");
    }

    @Test
    //Test to see if getEntryDate() accurately returns the entry date
    void getEntryDate() {
        //Test to see if the method returns the value that it was set to
        assertEquals(t.getEntryDate(), LocalDate.now());
    }

    @Test
    //Test to see if setEntryDate() correctly updates the entryDate of the Task
    void setEntryDate() {
        //Set the entryDate as the newDate
        t.setEntryDate(newDate);
        //Test to see if the date is now set to be the updated value
        assertEquals(t.getEntryDate(), newDate);
    }
}