/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Austin Beal
 * Section: 02 - 9:50
 * Date: 11/22/21
 * Time: 6:27 PM
 *
 * Project: csci205_final_project
 * Package: SchedulerMVC
 * Class: GUIController
 *
 * Description:
 *
 * ****************************************
 */

package SchedulerMVC;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The controller for the application
 * This class connects the GUI to the Model, and contains
 * functionality such as initializing all the event handlers and creating
 * the login window
 */
public class GUIController {

    /**A GUIView object representing the GUI that the user will see when the program is run*/
    private GUIView theView;

    /**A GUIModel object that contains the model of the object, holding the Users, Admins, Tasks, etc.*/
    private GUIModel theModel;

    /**A Boolean object that is true if the Admin has been logged in successfully, amd false otherwise*/
    private Boolean loggedIn;

    /**A Stage object that represents the window the GUI is being shown on. Is constantly updated as more
     * functionality is taken*/
    private Stage theStage;

    /**A Boolean that is true if the current user is an admin, and false otherwise*/
    private Boolean isAdmin = false;

    /**
     * The constructor method for the GUI Controller, which initializes the
     * View and Model, sets the logged in to false, and generates the first event
     *
     * @param view , the GUI View of the Scheduler to be initialized
     * @param model the GUI Model of the Scheduler to be initialized
     */
    public GUIController(GUIView view, GUIModel model){
        //Initialize the view and the model, and set the logged in to be false, since
        //the user has not logged in yet
        this.theView = view;
        this.theModel = model;
        loggedIn = false;
        //We start the controller by initializing the first event - the welcome screen
        generateEvent();
    }

    /**
     * The generateEvent method generates the welcome window for the program
     * The user is given two options - to enter as a User or sign in as an Administrator
     * If the User button is clicked, the event handler is called to go to the main window
     * If the Administrator button is clicked, the event handler to go to the login window is called,
     * and then the user is taken to the main window if the credentials match
     */
    public void generateEvent(){
        //If the user chooses to log in as a User
        theView.getUserBtn().setOnAction(e ->{
            //They are shown the main window, which is initialized with the name of the User
            //As a parameter
            theView.mainWindow(theModel.getAdmin().getName());
            //Our stage is set to the primary stage of the program and shown
            theStage = theView.getPrimaryStage();
            theStage.show();
            //All the buttons on the main window are initialized with their event handlers
            try {
                initMainButtons();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        //If the User to Log in as an administrator
        theView.getAdminBtn().setOnAction(e -> {
            //We let the controller know that it is an administrator using the system
            this.isAdmin = true;
            //Initialize a new stage, and set the scene as the login window
            Stage s = new Stage();
            s.setScene(new Scene(theView.getLoginWindow()));
            theStage = s;
            theStage.show();
        });
        //We now need to set an event handler for the login button on the login screen
        theView.getLoginButton().setOnAction(e -> {
            //We store the username and password as the text entered in the text fields
            String enteredUN = theView.getuN().getText();
            String enteredPass = theView.getPass().getText();
            //If the username and password entered matches the username and password of the administrator
            if(enteredUN.equals(theModel.getAdmin().getUserName()) && enteredPass.equals(theModel.getAdmin().getPassword())){
                //Our stage is set to the primary stage of the program and shown
                Stage s = theView.mainWindow(theModel.getAdmin().getName());
                theStage = s;
                theStage.show();
                //All the buttons on the main window are initialized with their event handlers
                try {
                    initMainButtons();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    /**
     * This is a function that initializes the event handlers for the six main buttons of the program
     * Each is initialized by calling the event handler from the theView object that stores the GUI
     */
    public void initMainButtons() throws IOException {
        //The first button initialized is the button that allows the user to add a user
        theView.addUserEvent();
        //If the current user is an admin, we give them special privileges
        if(this.isAdmin){
            //We initialize the buttons to allow the admin to add a user to the system and change the current admin
            theView.addUserEvent();
            theView.changeAdminEvent();
        //If the current user is Not an admin, then they do not have these functionalities
        }else{
            //The user will instead get a pop-up alert that tells them they are not allowed to use this feature
            theView.restrictedAccessAlert();
        }
        //We then initialize the buttons to create the graphs, and the time events
        theView.createGraphsEvent();
        theView.timerEvent();
        theView.enterTimeEvent();
        //Since we want the new task to be created based on user input, we initialize
        //Create task to return an array of information necessary to create the task
        ArrayList<String> taskInfo = theView.createTaskEvent();
        //We then parse the data from our list
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate d = LocalDate.parse(taskInfo.get(2), formatter);
        //Once the data is parsed, we then create the new task, and add it to the list of tasks
        Task t = new Task(LocalDate.now(),d, taskInfo.get(0), taskInfo.get(1));
        theModel.getAdmin().addTask(t);

    }

    /**
     * A helper method to tell the system if the user has successfully logged in or not
     *
     * @return loggedIn, a boolean which represents whether the user has successfully logged in
     */
    public Boolean getLoggedIn() {
        return loggedIn;
    }


}
