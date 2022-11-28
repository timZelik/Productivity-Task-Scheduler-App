package TestCodeThroughout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TestButtons extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("+");
        btn.setStyle("-fx-background-color: #29668c");
        btn.setFont(Font.font("Comic Sans", 20));
        FlowPane root = new FlowPane(btn);
        root.setStyle("-fx-background-color: cyan");
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
