package TestCodeThroughout.StartUpGui;/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Jordan Miller* Section: 9:50
 * Date: 09/13/2021
 * Time: 11:59pm
 *
 * Project: Lab 02
 * Package: PACKAGE_NAME
 * Class: finalProject.finalProject
 *
 * Description: Lab 02, getting familiar with intellij
 *
 * *****************************************/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class startUp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException{
        VBox root = new VBox();
        root.setSpacing(5);
        root.setPrefWidth(250);
        root.setPadding(new Insets(10,5,10,5));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-border-color: black");



        Text txt = new Text();
        txt.setText("Productivity");
        txt.setFill(Color.LIGHTSEAGREEN);
        txt.setFont(Font.font(30));
        txt.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        //txt.setY(40);
        //txt.setX(50);


        Reflection reflection= new Reflection();
        reflection.setFraction(0.9);

        URL url = getClass().getResource("img.png");
        Image image = new Image("img.png");
        //Image image = new Image(url.toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);


        Button adminBtn = new Button("Admin");
        adminBtn.setLayoutX(100);
        adminBtn.setLayoutY(160);
        adminBtn.setScaleX(1.2);
        //adminBtn.setMinSize(10,10);
        adminBtn.setStyle("-fx-text-fill: black");

        Button userBtn = new Button("  User  ");
        userBtn.setLayoutX(100);
        userBtn.setLayoutY(300);
        userBtn.setScaleX(1.2);
        //adminBtn.setMinSize(10,20);
        userBtn.setStyle("-fx-text-fill: black");






        root.getChildren().add(txt);
        root.getChildren().add(imageView);
        root.getChildren().add(adminBtn);
        root.getChildren().add(userBtn);
        root.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
        primaryStage.setScene(new Scene(root,250,250));
        primaryStage.show();


    }
}