/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Austin Beal
 * Section: 02 - 9:50
 * Date: 11/22/21
 * Time: 6:22 PM
 *
 * Project: csci205_final_project
 * Package: SchedulerMVC
 * Class: GUIView
 *
 * Description:
 *
 * ****************************************
 */

package SchedulerMVC;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * The GUI class for the Scheduler. Contains most of the graphical elements of the
 * class, as well as the event handler methods for the buttons associated with the GUI
 */
public class GUIView {

    /**A VBox containing the graphics for the login window*/
    private VBox loginWindow;

    /**A Button that the user presses to log in to the system*/
    private Button loginButton;

    /**A TextField where the user enters their login username*/
    private TextField usernameTextField;

    /**A TextField where the suer enters their login password*/
    private PasswordField passwordTextField;

    /**A List of the main buttons that appear throughout the code*/
    private List<Button> btnList;

    /**The first Button in the main window - allows the User to add a Task to the list of Tasks*/
    private Button btn1;

    /*The second Button in the main window - allows the User to set the time spent on a Task**/
    private Button btn2;

    /**The third Button in the main window - allows the User to start a new timer to run in the background*/
    private Button btn3;

    /**The fourth Button in the main window - allows the User to see a graph of their productivity*/
    private Button btn4;

    /**The fifth Button in the main window - allows the Admin to add a User to the system*/
    private Button btn5;

    /**The sixth Button in the main window - allows the Admin to change who the current system admin is*/
    private Button btn6;

    /**A public text object to be initialized and used within the startup window*/
    private TextField text;

    /**The Stage used to hold the taskInput scene*/
    private Stage taskInput;

    /**An ArrayList of rectangles that are used to display the tasks; initialized to be an empty list*/
    private ArrayList<Rectangle> rectsList = new ArrayList<>();

    /**A VBox used to contain the starting screen of the program*/
    private VBox startScreen;

    /**A Button allowing the user to login as an Administrator*/
    private Button adminBtn;

    /**A Button allowing the user to login as a User*/
    private Button userBtn;

    /**A VBox containing the main root window of the program*/
    private VBox mainRoot;

    /**A Label containing the current time as the program is running*/
    private Label timeText;

    /**A Timeline used to run a timer in the background*/
    private Timeline time;

    /**A Boolean indicating if there is already a timer running or not*/
    private boolean isRunning;

    /**A Button allowing the User to play the timer*/
    private Button playTimer;

    /**A Button allowing the User to pause the timer*/
    private Button pauseTimer;

    /**A Button allowing the User to stop the timer*/
    private Button stopTimer;

    /**The GUI Model to be initialized during the program*/
    private GUIModel theModel;

    /**An int value representing the number of seconds for the timer to run*/
    private int seconds;

    /**The primary Stage of our program*/
    private Stage primaryStage;

    /**
     * The Constructor for the View of the program
     * Initializes the model, and runs the first two scenes
     *
     * @param model, the GUI Model of the program
     */
    public GUIView(GUIModel model){
        //Initialize the model
        this.theModel = model;
        //Display the login screen, then display the startUp screen
        login();
        startUp();
    }

    /**
     * A method that generates the startup window of the program
     * This is the first window that the user will see
     */
    public void startUp(){
        //Initialize the startScreen, and set the padding, spacing, width, etc.
        startScreen = new VBox(10);
        startScreen.setSpacing(5);
        startScreen.setPrefWidth(250);
        startScreen.setPadding(new Insets(10,5,10,5));
        startScreen.setAlignment(Pos.CENTER);
        startScreen.setStyle("-fx-border-color: black");

        //Initialize a new text object, and set the color, font, size
        Text txt = new Text();
        txt.setText("Productivity");
        txt.setFill(Color.LIGHTSEAGREEN);
        txt.setFont(Font.font(30));
        txt.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        //Create a new reflection and set the Fraction
        Reflection reflection= new Reflection();
        reflection.setFraction(0.9);

        //Get the image from our resources folder and set the width and height of it
        URL url = getClass().getResource("img.png");
        Image image = new Image("img.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        //Create a button for the user to login as an Administrator
        adminBtn = new Button("Admin");
        adminBtn.setLayoutX(100);
        adminBtn.setLayoutY(160);
        adminBtn.setScaleX(1.2);
        //adminBtn.setMinSize(10,10);
        adminBtn.setStyle("-fx-text-fill: black");

        //Create a button for the user to login as a User
        userBtn = new Button("  User  ");
        userBtn.setLayoutX(100);
        userBtn.setLayoutY(300);
        userBtn.setScaleX(1.2);
        userBtn.setStyle("-fx-text-fill: black");

        //Add all the objects to the start screen, and set the background
        startScreen.getChildren().add(txt);
        startScreen.getChildren().add(imageView);
        startScreen.getChildren().add(adminBtn);
        startScreen.getChildren().add(userBtn);
        startScreen.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    /**
     * A method that is called when the User chooses to log in as an Admin
     * They are brought to a login screen, which is initialized within this method
     */
    public void login() {
        //Initialize our window as a VBox, and set the alignment and spacing
        loginWindow = new VBox(10);
        loginWindow.setAlignment(Pos.CENTER);
        loginWindow.setPadding(new Insets(15));

        //Initialize two new HBoxes, one to hold the objects for the Username information, and
        //one for the password information
        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);

        //Create the respective labels and text fields for the user to enter the information
        Label userName = new Label("Username");
        Label password = new Label("Password");
        usernameTextField = new TextField();
        passwordTextField = new PasswordField();

        //Add these objects to their respective HBoxes, and add these HBoxes to the window
        hbox1.getChildren().addAll(userName, usernameTextField);
        hbox2.getChildren().addAll(password, passwordTextField);
        loginWindow.getChildren().addAll(hbox1, hbox2);

        //Create a button for the user to press to log in, and add it to the  window
        loginButton = new Button("Login");
        loginWindow.getChildren().add(loginButton);
    }

    /**
     * The method that initializes all the graphical components of the
     * main window of the program, such as the buttons, time, and tasks remaining
     *
     * @param n a String containing a name to be displayed at the top of the program
     * @return a Stage containing the graphical components initialized in the method
     */
    public Stage mainWindow(String n){
        //Create our new stage
        primaryStage = new Stage();
        //Initialize the main root of our program as a new VBox
        mainRoot = new VBox(10);

        //The top half of our window will be stackPane containing the information we need
        StackPane topHalf = new StackPane();
        //Add a welcome message to the user, personalized with their name, and add graphical
        //components to this to style it
        Label welcome = new Label("Welcome, " + n);
        welcome.setAlignment(Pos.CENTER);
        welcome.setFont(Font.font("Impact", 20));
        welcome.setStyle("-fx-text-fill: white");
        Rectangle rect = new Rectangle(800, 50);
        rect.setFill(new Color(0.16, 0.4, 0.549, 1));
        //Add the rectangle and the welcome message to the top of our program
        topHalf.getChildren().add(rect);
        topHalf.getChildren().add(welcome);

        //The bottom half of our program contains the brunt of the graphics
        //Initialize a new HBox, which will be split into three sections
        HBox bottomHalf = new HBox(10);

        //The first section holds all the Buttons of the program
        VBox controls = new VBox(15);
        controls.setPrefWidth(200);
        controls.setAlignment(Pos.TOP_CENTER);
        //Initialize our six buttons, and add them to our list of buttons
        btn1 = new Button("Add Task");
        btn2 = new Button("Set Time Spent");
        btn3 = new Button("Start New Timer");
        btn4 = new Button("See Productivity");
        btn5 = new Button("Add User");
        btn6 = new Button("Change Admin");
        btnList = new ArrayList<>();
        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);
        btnList.add(btn4);
        btnList.add(btn5);
        btnList.add(btn6);
        //For each button in our list of Buttons, add the button to our control pane
        for(Button btn: btnList){
            controls.getChildren().add(btn);
        }

        //The Middle section of our window will contain rectangles that display all of the
        //Tasks the users must complete
        VBox tasks = new VBox(10);
        tasks.setAlignment(Pos.CENTER);
        //These are sample tasks that we have created, which are used to demonstrate this functionality
        ArrayList<String> list = new ArrayList<>();
        String s1 = "HW #1";
        String s2 = "Lab 17";
        String s3 = "Quiz 3 - Study";
        String s4 = "Meeting with Academic Chair";
        String s5 = "Job Application!";
        //Add these sample tasks to our sample list of tasks
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        //We want to go through our list of tasks and add them as labels to our rectangles
        for(int i =0; i < list.size(); i++){
            //Initialize an HBox to hold the rectangle and the colored tab for style
            HBox tabs = new HBox(10);
            //Each task will be a stackPane, with the rectangle and text stacked
            StackPane task = new StackPane();
            //Initialize our rectangle and tab, and style the rectangles
            Rectangle r = new Rectangle(400, 60);
            Rectangle tab = new Rectangle(15, 60);
            tabs.getChildren().add(tab);
            tabs.setAlignment(Pos.BASELINE_LEFT);
            r.setStyle("-fx-border-color: black");
            tab.setFill(new Color(0.792, 0.8588, 0.9019, 1));
            r.setFill(Color.WHITE);
            //https://www.dummies.com/programming/java/javafx-how-to-add-shadows/
            //Create a new drop shadow to be displayed for style
            DropShadow shad = new DropShadow();
            shad.setOffsetX(3);
            shad.setOffsetY(3);
            shad.setWidth(5);
            shad.setHeight(5);
            shad.setRadius(2);
            r.setEffect(shad);
            //Add the rectangle that we created to our rectangle list
            rectsList.add(r);
            //Add our label to the rectangle, and add our task to the list
            Label lbl = new Label(list.get(i));
            task.getChildren().addAll(r, lbl, tabs);
            tasks.getChildren().add(task);
        }

        //The third section of our window will display the current date and time
        VBox timePane = new VBox(20);
        //Add in our date time formatter, get the current date and time, and parse it
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy  @ hh:mm a"); //"yyyy/MMM/dd HH:mm:ss"
        LocalDateTime now = LocalDateTime.now();
        String s = now.format(dtf);
        //Add the parsed date and time to their respective labels, and position it
        Label date = new Label("Today is " + s.substring(0, s.indexOf('@')));
        date.setAlignment(Pos.CENTER);
        Label time = new Label("It is currently " + s.substring(s.indexOf('@')+1));
        //Add our date and time to our third section
        timePane.getChildren().add(date);
        timePane.getChildren().add(time);
        timePane.setAlignment(Pos.CENTER);
        //Add the three sections of our bottom half window to our bottom half pane
        bottomHalf.getChildren().add(controls);
        bottomHalf.getChildren().add(tasks);
        bottomHalf.getChildren().add(timePane);
        //Add our top and bottom half to our root, set our stage with the new scene of the root
        //And return the stage
        mainRoot.getChildren().add(topHalf);
        mainRoot.getChildren().add(bottomHalf);
        primaryStage.setScene(new Scene(mainRoot, 800, 600));
        return primaryStage;
    }

    /**
     * The event handler for creating a Task based on the user input
     * This method initializes the window that is shown when the user
     * wants to input a task
     *
     * @return an ArrayList of strings containing the information that the user input
     */
    public ArrayList<String> createTaskEvent(){
        //We will initialize the empty list of strings to be populated with the user information
        ArrayList<String> taskInfo = new ArrayList<>();
        //Create an event for when the button is clicked
        btn1.setOnAction(e -> {
            //Create a new stage for the window to be shown on
            taskInput = new Stage();
            //Initialize our root as a vbox, and set the padding and spacing
            VBox root = new VBox(10);
            root.setPadding(new Insets(10));
            //Create a space for the user to enter the name of the task, and add it to a HBox
            HBox top = new HBox(5);
            Label lbl = new Label("Task Name: ");
            text = new TextField();
            top.getChildren().addAll(lbl, text);
            //Create an options list, for the User to select it to the label, and add it to a different HBOx
            HBox mid = new HBox(5);
            Label lbl2 = new Label("Task Type: ");
            ObservableList<String> types = FXCollections.observableArrayList(
                    "School",
                    "Job",
                    "Personal",
                    "Other"
            );
            ComboBox<String> options = new ComboBox<>(types);
            TextField text2 = new TextField();
            mid.getChildren().addAll(lbl2, options);

            //Create a third HBox for the user to select the due date, as well as initialize a button
            HBox bottom = new HBox(5);
            Label dueDate = new Label("Due Date: ");
            DatePicker beg = new DatePicker();
            Button createBtn = new Button("Create");
            bottom.getChildren().addAll(dueDate, beg);

            //When the create button is pressed
            createBtn.setOnAction(ev -> {
                //Get all the information from textFields and boxes, and add them to our list
                String name = text.getText();
                String type = text2.getText();
                LocalDate date = beg.getValue();
                String d = date.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
                taskInfo.add(name);
                taskInfo.add(type);
                taskInfo.add(d);
            });
            //Align our three HBoxes, and add them to our root
            top.setAlignment(Pos.CENTER);
            mid.setAlignment(Pos.CENTER);
            bottom.setAlignment(Pos.CENTER);
            root.getChildren().add(top);
            root.getChildren().add(mid);
            root.getChildren().add(bottom);
            root.getChildren().add(createBtn);
            //Create a new scene with our root, set the stage with our scene, and show it
            Scene sc = new Scene(root, 400, 150);
            taskInput.setScene(sc);
            taskInput.show();
        });
        //Return the stage
        return taskInfo;
    }

    /**
     * The event handler for the user wanting to add a new User to the system
     * Allows the User to enter new User's name, age and birthday, and creates
     * a new user from this
     */
    public void addUserEvent(){
        //When the button to create this User is pressed
        btn5.setOnAction(event -> {
            //Create our root as a VBox, and set the padding
            VBox root = new VBox(10);
            root.setPadding(new Insets(10));
            //Create a HBox for the user to enter a name, and add a TextField and Label
            HBox name = new HBox(10);
            Label lbl1 = new Label("Name: ");
            TextField nameInput = new TextField();
            name.getChildren().addAll(lbl1, nameInput);
            name.setAlignment(Pos.CENTER);
            //Create a HBox for the user to enter an age, and add a TextField and Label
            HBox age = new HBox(10);
            Label ageLbl = new Label("Age: ");
            TextField ageTextField = new TextField();
            ageTextField.setPrefColumnCount(2);
            age.getChildren().addAll(ageLbl, ageTextField);
            age.setAlignment(Pos.CENTER);
            //Create a VBox for the user to select a birthday, and add a DatePicker and Label
            VBox text = new VBox(10);
            DatePicker bdaySelect = new DatePicker();
            bdaySelect.setValue(LocalDate.of(2002, 1, 1));
            Label lbl = new Label("Please enter their birthday");
            text.getChildren().addAll(lbl, bdaySelect);
            text.setAlignment(Pos.CENTER);
            //Add these three new boxes to our rot
            root.getChildren().addAll(name, age, text);
            //Create a new stage for our event, set the scene as the root, and show
            Stage s = new Stage();
            s.setTitle("Create a new user");
            s.setScene(new Scene(root, 500, 200));
            s.show();


        });
    }

    /**
     * The event for if a User wants to create a new timer to run in the background
     * The user can select a 10, 30, 60 or custom minute timers, and it will run in the
     * background, and alert the user when the timer has finished
     */
    public void timerEvent(){
        //When the button to select a timer is pressed
        btn3.setOnAction(e -> {
            //https://docs.oracle.com/javafx/2/ui_controls/button.htm
            //Create a label to hold the current time remaining, and set the font
            timeText = new Label();
            timeText.setFont(Font.font(20));
            //Initialize our four buttons, with the three of them having images associated with them as well
            ToggleButton tenMin = new ToggleButton("10 Minutes", new ImageView("10min.png"));
            ToggleButton thirtyMin = new ToggleButton("30 Minutes", new ImageView("30min.png"));
            ToggleButton sixtyMin = new ToggleButton("60 Minutes", new ImageView("60min.png"));
            ToggleButton custom = new ToggleButton("Custom");
            // Source: https://docs.oracle.com/javafx/2/ui_controls/button.htm
            //There is currently no timer running
            isRunning = false;
            //Set the event for if a 10 minute timer is selected
            tenMin.setOnAction(event -> {
                //If a timer is running, stop the current timer
                if(isRunning){
                    time.stop();
                }
                //Then, set isRunning to true, set the proper number of seconds, and start the countdown
                isRunning = true;
                seconds = 600;
                countDown();

            });
            //Set the event for if a 30 minute timer is selected
            thirtyMin.setOnAction(event -> {
                //If a timer is running, stop the current timer
                if(isRunning){
                    time.stop();
                }
                //Then, set isRunning to true, set the proper number of seconds, and start the countdown
                isRunning = true;
                seconds = 1800;
                countDown();
            });
            //Set the event for if a 30 minute timer is selected
            sixtyMin.setOnAction(event -> {
                //If a timer is running, stop the current timer
                if(isRunning){
                    time.stop();
                }

                //Then, set isRunning to true, set the proper number of seconds, and start the countdown
                isRunning = true;
                seconds = 3600;
                countDown();

            });
            //If the user selects to run a custom timer
            custom.setOnAction(event ->{
                //Create a new box where the user can enter the amount of time seconds to run the timer for
                VBox root = new VBox(10);
                root.setAlignment(Pos.CENTER);
                root.setPadding(new Insets(10));
                Label amountOfSeconds = new Label("Enter the amount of time you would like in seconds");
                TextField secondsInput = new TextField();
                Button enterBtn = new Button("Start Timer");
                enterBtn.setOnAction(enterEv -> {
                    //Parse the number of seconds from the user input, update the seconds, and start the countdown
                    seconds = Integer.parseInt(secondsInput.getText());
                    countDown();
                });
                //Add all of our objects to our mini scene
                root.getChildren().addAll(amountOfSeconds, secondsInput, enterBtn);
                //Create a new stage and show it with the scene as our root
                Stage s = new Stage();
                s.setScene(new Scene(root, 200, 200));
                s.show();
            });

            //Create another VBox to hold our buttons, set the spacing and alignment, and add the buttons
            VBox root = new VBox(10);
            root.setAlignment(Pos.CENTER);
            root.setPadding(new Insets(10));
            HBox buttons = new HBox(10);
            buttons.setAlignment(Pos.CENTER);
            root.getChildren().add(timeText);
            buttons.getChildren().addAll(tenMin, thirtyMin, sixtyMin, custom);
            //Create buttons to start, stop, and pause our timer, and add it to an HBox
            playTimer = new  Button("Play");
            pauseTimer = new Button("Pause");
            stopTimer = new Button("Stop");
            HBox controlBtns = new HBox(10);
            controlBtns.setAlignment(Pos.CENTER);
            controlBtns.getChildren().addAll(playTimer, pauseTimer, stopTimer);
            //Add all of our buttons as well as our control buttons to our root
            root.getChildren().addAll(buttons, controlBtns);
            //Create a new Stage with our root as the scene and show the stage
            Stage s = new Stage();
            s.setScene(new Scene(root, 700, 200));
            s.show();
        });
    }

    /**
     * The event handler for the user to change the Administrator of the program
     * The user is given a menu of all the Users of the program, and select one to
     * become the admin
     *
     * NOTE This function is only allowed for Admins
     */
    public void changeAdminEvent(){
        //When the button to change the admin is clicked
        btn6.setOnAction(e -> {
            //Create a new root to hold our components, and set the alignment and spacing
            VBox root = new VBox(10);
            root.setPadding(new Insets(10));
            root.setAlignment(Pos.CENTER);
            //Create a dropdown menu of all the users in the program
            // and add it to a combo box
            ObservableList<String> types = FXCollections.observableArrayList();
            for(User u: theModel.getAdmin().getListOfUsers()){
                types.add(u.getName());
            }
            ComboBox<String> options = new ComboBox<>(types);
            //Create an HBox for the user to enter the new Admin's username
            HBox userName = new HBox(5);
            Label unText = new Label("Set the new admin's username");
            TextField unInput = new TextField();
            userName.getChildren().addAll(unText, unInput);
            //Create an HBox for the user to enter the new Admin's password
            HBox pass = new HBox(5);
            Label passText = new Label("Please set the new admin's password");
            PasswordField passField = new PasswordField();
            pass.getChildren().addAll(passText, passField);
            //Create an HBox for the user to confirm the new Admin's password
            HBox confirmPass = new HBox(5);
            Label confirmPassText = new Label("Please set the new admin's password");
            PasswordField confirmPassField = new PasswordField();
            confirmPass.getChildren().addAll(confirmPassText, confirmPassField);
            //Add all of our components to our root
            root.getChildren().add(options);
            root.getChildren().addAll(userName, pass, confirmPass);
            //Create our new stage, set the scene with the root, and show the stage
            Stage s = new Stage();
            s.setScene(new Scene(root, 400, 150));
            s.show();

        });
    }

    /**
     * A popup message to appear if the User is attempting to access functionality that is
     * reserved for only the Admins
     */
    public void restrictedAccessAlert(){
        //If a User tries to add a User
        btn5.setOnAction(e-> {
            //Create a new alert and let the user know this is a restricted function. Show the alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Change Admin Failure");
            alert.setHeaderText("Restricted Access!");
            alert.setContentText("You do not have access to this feature.\nPlease contact your administrator");
            alert.show();
        });
        //If a User tries to add change the Admin
        btn6.setOnAction(e-> {
            //Create a new alert and let the user know this is a restricted function. Show the alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Change Admin Failure");
            alert.setHeaderText("Restricted Access!");
            alert.setContentText("You do not have access to this feature.\nPlease contact your administrator");
            alert.show();
        });

    }

    /**
     * The helper method that runs the timer in the background
     * This method was largely modeled based on a YouTube video that we found
     * The link to the video is below
     */
    private void countDown(){
        //https://www.youtube.com/watch?v=t2Bv6hwELsU&ab_channel=PaschalGangmei
        //Create a new timeline and set the cycle to run infinitely
        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        //Set our three buttons to pause, play, and stop the timer, respectively, when they clicked
        pauseTimer.setOnAction(e-> {
            time.pause();
        });
        playTimer.setOnAction(e-> {
            time.play();
        });
        stopTimer.setOnAction(e-> {
            //Set the text to an empty string to remove the timer if the timer is stopped
            timeText.setText("");
            time.stop();
        });
        //If the time is null, stop the timer
        if(time != null){
            time.stop();
        }
        //Create a new KeyFrame to run every one second
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            /**
             * The event to handle the keyframe changing
             *
             * @param event , the event
             */
            @Override

            public void handle(ActionEvent event) {
                //Decrement our seconds with each cycle of the timeline
                seconds--;
                //Format the seconds to look like proper time based on how many seconds remain
                if(seconds == 3600){
                    timeText.setText("1:00:00");
                }
                else if(seconds >= 60){
                    if(seconds % 60 > 0){
                        if(seconds % 60 >= 10){
                            timeText.setText(seconds / 60 + ":" + seconds % 60 );
                        }else{
                            timeText.setText(seconds / 60 + ":0" + seconds % 60 );
                        }

                    }else{
                        timeText.setText(seconds/ 60 + ":0" + seconds%60);
                    }

                }
                else if(seconds >= 10){
                    timeText.setText("0:" + seconds);

                }
                else{
                    timeText.setText("0:0" + seconds);
                }

                //If the seconds have become less than or equal to zero
                if(seconds <= 0){
                    //Stop the timer, and alert the user that the timer is done
                    time.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Timer Complete");
                    alert.setHeaderText("The timer has been finished");
                    alert.setContentText("Your timer has been complete\nPlease input how much time you spent on this assignment");
                    alert.show();
                }
            }
        });
        //Add the keyframes, and play the timer
        time.getKeyFrames().add(frame);
        time.playFromStart();
    }

    /**
     * The event to crate graphs of productivity of the user
     * We were unable to completely implement this, thus the data is sample data
     */
    public void createGraphsEvent(){
        //When the button to see the productivity is clicked
        btn4.setOnAction(e -> {
            //Create our root for the graphs to be shown on
            VBox root = new VBox(10);
            //Create new xAxis and yAxis, and create a Bar Chart based on these axes
            CategoryAxis xAxis = new CategoryAxis();
            NumberAxis yAxis = new NumberAxis();
            BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);
            //Create a new dataSeries, and add our sample data to our graphs
            XYChart.Series dataSeries1 = new XYChart.Series();
            dataSeries1.setName("Commitments");
            dataSeries1.getData().add(new XYChart.Data("Other", 100));
            dataSeries1.getData().add(new XYChart.Data("School", 10));
            dataSeries1.getData().add(new XYChart.Data("Personal", 20));
            dataSeries1.getData().add(new XYChart.Data("Job",70));
            barChart.getData().add(dataSeries1);
            //Add our bar chart to the root, create a new Stage and set the scene,and show our stage
            root.getChildren().add(barChart);
            Stage s = new Stage();
            s.setScene(new Scene(root,500,500));
            s.setTitle("Productivity Chart");
            s.show();
        });

    }

    /**
     * The event handler for the user entering the timer spent on a task
     * Allows the user to select when they started and stopped working on the task,
     * and displays the amount of time spent on that task
     *
     * @throws IOException due to it being run through FXML
     */
    public void enterTimeEvent() throws IOException {
        //When the button to add time spent is clicked
        btn2.setOnAction(e -> {
            //Create a new FXML loader and load our FXML file with our loader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/manualTimer.fxml"));
            Parent root = null;
            try {
                //Set the root as the loaded filer
                root = loader.load();
            //If there is no file to load, throw an exception
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //Create a new stage, set the scene, and show
            Stage s = new Stage();
            s.setScene(new Scene(root, 400, 400));
            s.setTitle("Manual Timer: ");
            s.show();
        });


    }
    //These are the necessary getters that are used throughout the program
    //They return the object that is in their name
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public VBox getLoginWindow() {
        return loginWindow;
    }

    public VBox getStartScreen() {
        return startScreen;
    }

    public TextField getuN() {return usernameTextField;}

    public TextField getPass() {
        return passwordTextField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getAdminBtn() {
        return adminBtn;
    }

    public Button getUserBtn() {
        return userBtn;
    }




}
