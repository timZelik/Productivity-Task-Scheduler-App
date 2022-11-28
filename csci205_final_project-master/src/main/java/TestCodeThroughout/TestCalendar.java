package TestCodeThroughout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TestCalendar extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox(10);
        Scene scene = new Scene(vbox, 100, 100);
        DatePicker beg = new DatePicker();
        DatePicker end = new DatePicker();
        stage.setScene(scene);
        beg.setValue(LocalDate.now());
        end.setValue(LocalDate.now());
        Button btn = new Button("Show Date");

        Label beg1 = new Label("Beginning Date: ");
        Label end1 = new Label("Ending Date: ");
        vbox.setPrefSize(1000  , 1000);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(beg1);
        vbox.getChildren().add(beg);
        vbox.getChildren().add(end1);
        vbox.getChildren().add(end);
        vbox.getChildren().add(btn);
        btn.setOnAction( e -> {
                    System.out.println("Start: " + beg.getValue());
            System.out.println("End: "+ end.getValue());
            System.out.println("Type: " + beg.getValue().getClass());
                });
        stage.sizeToScene();
        stage.setMinHeight(200);
        stage.setMinWidth(300);
        stage.show();
    }
}
