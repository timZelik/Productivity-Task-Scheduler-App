package SchedulerMVC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class for the Scheduler Application. The class, which extends from
 * Application, combines the three components of our project (Model, View, Controller),
 * all so that they will run together and the program will execute
 */
public class GUIMain extends Application {

    /**A GUIModel object containing the model for the application*/
    private GUIModel theModel;

    /**A GUIView object containing the view for the application*/
    private GUIView theView;

    /**A GUIController object containing the controls for the application*/
    private GUIController theController;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The method that initializes the necessary objects for our application to run
     * Takes care of initializing the Model, Controller, and View
     *
     * @throws Exception if it is unable to properly run
     */
    @Override
    public void init() throws Exception {
        //Inherit out init function, and initialize our model, view, and controller
        super.init();
        this.theModel = new GUIModel();
        this.theView = new GUIView(theModel);
        this.theController = new GUIController(theView,theModel);
    }


    /**
     * The start method which starts the program. Given the stage for our
     * program to run on, we set the scene of our stage, and then size it properly and show,
     * for our application to run
     *
     * @param primaryStage the Stage for the program to be run upon
     */
    @Override
    public void start(Stage primaryStage) {
        //Set the scene of our stage as the start screen, as created in theView
        Scene scene = new Scene(theView.getStartScreen(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        //Size the scene properly, and show it so that the first window will run
        primaryStage.show();
    }
}
