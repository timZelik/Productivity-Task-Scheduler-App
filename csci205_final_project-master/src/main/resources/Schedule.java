package FinalProject;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.Scene;
import java.time.LocalDate;
import java.util.Calendar;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


public class Schedule extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    //https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/date-picker.htm
    /**
     * Learn about functionality of different code task
     * Learned: how to utilize DatePicker using javafx
     * Still learning: how to implement and use time with javafx
     * Possibility: using JFoenix library to get JFXMLTimePicker:
     * https://github.com/sshahine/JFoenix/blob/master/jfoenix/src/main/java/com/jfoenix/controls/JFXTimePicker.java
     */
    public void start(Stage stage) {
        VBox vbox = new VBox(10);
        Scene scene = new Scene(vbox, 100, 100);
        DatePicker beg = new DatePicker();
        DatePicker end = new DatePicker();
        stage.setScene(scene);
        beg.setValue(LocalDate.now());
        end.setValue(LocalDate.now());

        Label beg1 = new Label("Beginning Date: ");
        Label end1 = new Label("Ending Date: ")

        vbox.getChildren().add(beg1);
        vbox.getChildren().add(beg);
        vbox.getChildren().add(end1);
        vbox.getChildren().add(end);
        stage.show();
    }

}
