package main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.util.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class timeFunctionality extends Application {

    /**
     * The start time will be instantiated as the time the user hits the button the first time
     */
    private LocalDateTime start;

    /**
     * The end time will be instantiated as the time the user hits a button the 2nd time
     */
    private LocalDateTime end;

    private Button startEndToggle;


    private int milliSeconds;
    private int seconds;
    private int minutes;
    private String milliSecondsStr;
    private String secondsStr;
    private String minutesStr;
    private Label label;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        /** Button Instantiations */
        //https://docs.oracle.com/javafx/2/ui_controls/button.htm
        Button tenMin = new Button("10 Minutes", new ImageView("10min.png"));
        Button thirtyMin = new Button("30 Minutes", new ImageView("30min.png"));
        Button sixtyMin = new Button("60 Minutes", new ImageView("60min.png"));

        VBox root = new VBox();

        startEndToggle = new Button("Start/End");
        Text difference = new Text();
        startEndToggle.setOnAction(x -> {
            if (start == null) {
                start = LocalDateTime.now();
                difference.setText("Time start, press button again to stop timer and get time");
            } else if (end == null) {  //do some math to convert hours/mins/seconds
                end = LocalDateTime.now();

                long seconds = ChronoUnit.SECONDS.between(start, end);
                difference.setText("Difference in time is: " + seconds + " seconds.");
                start = null;
                end = null;
            }
        });

        //String milliSecondsStr
       // String secondsStr = String.format("%02d", seconds);
        //String minutesStr = String.format("%02d", minutes);
        Label tenMinLabel = new Label (String.format("%02d", minutes));
        Label timerStr = new Label (minutesStr + ":" + secondsStr + ":" + milliSecondsStr);
        root.getChildren().addAll(difference);
        root.setSpacing(10);



        //10min timer is clicked
        tenMin.setOnAction(actionEvent -> {

            Label thirtyMinLabel = new Label ("hai");
            secondsStr = String.format("02%d", seconds);
            tenMinLabel.setText(String.valueOf(seconds));
            //minutesStr = String.format("%02d", minutes);
            //secondsStr = String.format("%02d", seconds);
            milliSecondsStr= String.format("%02d", milliSeconds);
            tenMin.setDisable(true);
            root.getChildren().add(thirtyMinLabel);
        });

        root.getChildren().addAll(startEndToggle);

        root.getChildren().addAll(tenMin, thirtyMin, sixtyMin);

        primaryStage.setScene(new Scene(root, 500, 200));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

}
