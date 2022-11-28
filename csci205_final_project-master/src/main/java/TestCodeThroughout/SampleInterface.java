package TestCodeThroughout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.xml.stream.Location;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static javafx.scene.text.Font.font;

public class SampleInterface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        StackPane topHaalf = new StackPane();
        Label welcome = new Label("Welcome, User");
        welcome.setAlignment(Pos.CENTER);
        welcome.setFont(Font.font("Impact", 20));
        welcome.setStyle("-fx-text-fill: white");
        Rectangle rect = new Rectangle(800, 50);
        rect.setFill(new Color(0.16, 0.4, 0.549, 1));
        topHaalf.getChildren().add(rect);
        topHaalf.getChildren().add(welcome);

        HBox bottomHalf = new HBox(10);
        VBox controls = new VBox(15);
        controls.setPrefWidth(200);
        Button btn1 = new Button("Add Task");
        Button btn2 = new Button("Start Timer");
        Button btn3 = new Button("Stop Timer");
        Button btn4 = new Button("See Productivity");
        Button btn5 = new Button("Add User");
        Button btn6 = new Button("Change Admin");
        controls.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6);
        controls.setAlignment(Pos.TOP_LEFT);

        //
        ArrayList<String> list = new ArrayList<>();
        String s1 = "HW #1";
        String s2 = "Lab 17";
        String s3 = "Quiz 3 - Study";
        String s4 = "Meeting with Academic Chair";
        String s5 = "Job Application!";

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        VBox tasks = new VBox(10);
        for(int i =0; i < list.size(); i++){
            HBox tabs = new HBox(10);
            StackPane task = new StackPane();
            Rectangle r = new Rectangle(400, 60);
            Rectangle tab = new Rectangle(15, 60);
            tabs.getChildren().add(tab);
            tabs.setAlignment(Pos.BASELINE_LEFT);
            r.setStyle("-fx-border-color: black");
            tab.setFill(new Color(0.792, 0.8588, 0.9019, 1));
            r.setFill(Color.WHITE);
            //https://www.dummies.com/programming/java/javafx-how-to-add-shadows/
            DropShadow shad = new DropShadow();
            shad.setOffsetX(3);
            shad.setOffsetY(3);
            shad.setWidth(5);
            shad.setHeight(5);
            shad.setRadius(2);
            r.setEffect(shad);
            Label lbl = new Label(list.get(i));
            task.getChildren().addAll(r, lbl, tabs);
            tasks.getChildren().add(task);
        }
        tasks.setAlignment(Pos.CENTER);

        VBox weatherPane = new VBox(20);


        //LocalDate cur = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy  @ hh:mm a"); //"yyyy/MMM/dd HH:mm:ss"
        LocalDateTime now = LocalDateTime.now();
        String s = now.format(dtf);
        Label date = new Label("Today is " + s.substring(0, s.indexOf('@')));
        date.setAlignment(Pos.CENTER);
        Label time = new Label("It is currently " + s.substring(s.indexOf('@')+1));



        //System.out.println(locale);



        weatherPane.getChildren().add(date);
        weatherPane.getChildren().add(time);
        weatherPane.setAlignment(Pos.CENTER);





        bottomHalf.getChildren().add(controls);

        bottomHalf.getChildren().add(tasks);

        bottomHalf.getChildren().add(weatherPane);
        controls.setAlignment(Pos.TOP_CENTER);
        root.getChildren().add(topHaalf);
        root.getChildren().add(bottomHalf);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
