package TestCodeThroughout.Schedule;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;

public class  ScheduleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AMLabel1;

    @FXML
    private Label AMLabel2;

    @FXML
    private Button addEvent;

    @FXML
    private Text colon1;

    @FXML
    private Text colon2;

    @FXML
    private DatePicker endDate;

    @FXML
    private Slider endHour;

    @FXML
    private Text endHourText;

    @FXML
    private Text endMinText;

    @FXML
    private Slider endMinute;

    @FXML
    private CheckBox endPM;

    @FXML
    private Text endTimeText;

    @FXML
    private DatePicker startDate;

    @FXML
    private Slider startHour;

    @FXML
    private Text startHourText;

    @FXML
    private Slider startMin;

    @FXML
    private Text startMinText;

    @FXML
    private CheckBox startPM;

    @FXML
    private Text startTimeText;

    @FXML
    void change(ActionEvent event) {
        if(startPM.isSelected())
            AMLabel1.setText("PM");
        else
            AMLabel1.setText("AM");
        if(endPM.isSelected())
            AMLabel2.setText("PM");
        else
            AMLabel2.setText("AM");
    }

    @FXML
    void submit(ActionEvent event) {
        System.out.println("Event submitted");
        //TODO: convert texts to time object and send to method that will add to calendar


        //this will reset all fields to default for new event
        startHour.setValue(startHour.getMin());
        endHour.setValue(endHour.getMin());
        startMin.setValue(startMin.getMin());
        endMinute.setValue(endMinute.getMin());
        startDate.setValue(null);
        endDate.setValue(null);
        startPM.setSelected(false);
        endPM.setSelected(false);
    }

    @FXML
    void initialize() {
        assert AMLabel1 != null : "fx:id=\"AMLabel1\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert AMLabel2 != null : "fx:id=\"AMLabel2\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert addEvent != null : "fx:id=\"addEvent\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert colon1 != null : "fx:id=\"colon1\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert colon2 != null : "fx:id=\"colon2\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert endDate != null : "fx:id=\"endDate\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert endHour != null : "fx:id=\"endHour\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert endHourText != null : "fx:id=\"endHourText\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert endMinText != null : "fx:id=\"endMinText\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert endMinute != null : "fx:id=\"endMinute\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert endPM != null : "fx:id=\"endPM\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert endTimeText != null : "fx:id=\"endTimeText\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert startDate != null : "fx:id=\"startDate\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert startHour != null : "fx:id=\"startHour\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert startHourText != null : "fx:id=\"startHourText\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert startMin != null : "fx:id=\"startMin\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert startMinText != null : "fx:id=\"startMinText\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert startPM != null : "fx:id=\"startPM\" was not injected: check your FXML file 'scheduler.fxml'.";
        assert startTimeText != null : "fx:id=\"startTimeText\" was not injected: check your FXML file 'scheduler.fxml'.";


        //have the time appear on the bottom based on slider from user input
        startHourText.textProperty().bind(startHour.valueProperty().asString("%02.0f"));
        endHourText.textProperty().bind(endHour.valueProperty().asString("%02.0f"));
        startMinText.textProperty().bind(startMin.valueProperty().asString("%02.0f"));
        endMinText.textProperty().bind(endMinute.valueProperty().asString("%02.0f"));
    }
}