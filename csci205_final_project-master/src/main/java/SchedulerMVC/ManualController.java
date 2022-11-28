/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Austin Beal
 * Section: 02 - 9:50
 * Date: 12/8/21
 * Time: 12:28 PM
 *
 * Project: csci205_final_project
 * Package: SchedulerMVC
 * Class: ManualController
 *
 * Description:
 *
 * ****************************************
 */

package SchedulerMVC;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 * This class is the Controller class for the Manual Time Entry.
 *  It contains all the logic and event handlers related to entering
 *  the amount of time that a User had spent on a task
 */
public class ManualController {
        /**
         * This is our label that shows our "AM" or "PM" in the start time text
         */
        @FXML
        private Label AMLabel1;

        /**
         * This is our label that shows our "AM" or "PM" in the end time text
         */
        @FXML
        private Label AMLabel2;

        /**
         * This is our button that will be used to add event and finalize all of the users inputs
         */
        @FXML
        private Button addEvent;

        /**
         * This is the colon used in the text in the window for our start time
         */
        @FXML
        private Text colon1;

        /**
         * This is the colon used in the text in the window for our end time
         */
        @FXML
        private Text colon2;

        /**
         * This is the text that appears above the date picker for end date.
         */
        @FXML
        private Text dateTimeEnd;

        /**
         * This is the text that appears above the date picker for start date.
         */
        @FXML
        private Text dateTimeStart;

        /**
         * This is the text that appears when the difference between the two dates is calculated.
         */
        @FXML
        private Text difference;

        /**
         * This is the datepicker for the end date that allows the user to open up a calendar
         * and select
         */
        @FXML
        private DatePicker endDate;

        /**A Slider that is used to set the endHour of the amount of time spent*/
        @FXML
        private Slider endHour;

        /**Text containing the endHour*/
        @FXML
        private Text endHourText;

        /**Text containing the end minute*/
        @FXML
        private Text endMinText;

        /**A Slider that is used to set the endMinute of the amount of time spent*/
        @FXML
        private Slider endMinute;

        /**A CheckBox used to indicate whether the endTime was entered in PM or not*/
        @FXML
        private CheckBox endPM;

        /**Text representing the whole end Time*/
        @FXML
        private Text endTimeText;

        /**A DatePicker for the user to select the startDate*/
        @FXML
        private DatePicker startDate;

        /**A Slider for the user to select the startHour*/
        @FXML
        private Slider startHour;

        /**Text containing the startHour*/
        @FXML
        private Text startHourText;

        /**A slider for the user to select the startMinute*/
        @FXML
        private Slider startMin;

        /**Text containing the startMinute*/
        @FXML
        private Text startMinText;

        /**A CheckBox indicating if the time entered was in PM or not*/
        @FXML
        private CheckBox startPM;

        /**Text containing the entire startTime*/
        @FXML
        private Text startTimeText;

        /**Text representing the time spent between the start and end times entered*/
        @FXML
        private Text timeSpentText;

        /**
         * This method will change the AM/PM text in the window based on user interaction with the checkbox
         * @param event
         */
        @FXML
        void change(ActionEvent event) {
            //If the startPM checkbox is checked, set the AM Label for startTime to PM
            if(startPM.isSelected())
                AMLabel1.setText("PM");
            //Otherwise, set the label to AM
            else
                AMLabel1.setText("AM");
            //If the endPM checkbox is checked, set the AM Label for endTime to PM
            if(endPM.isSelected())
                AMLabel2.setText("PM");
            //Otherwise, set the label to AM
            else
                AMLabel2.setText("AM");
        }

        /**
         * This method will show the user how much time they spent between start and
         * completion in task as well as resetting all the values for the next user input.
         * @param event; method runs when button is pressed
         */
        @FXML
        void submit(ActionEvent event) {
            //If the start date and end date have been selected
            if (startDate.getValue() != null && endDate.getValue() != null) {
                //Find the difference in minutes between the start time and end time and
                //set the text as this difference
                long minutes = findTimeDiff();
                difference.setText(minutes + " minutes.");
                //this will reset all fields to default for new event
                startHour.setValue(startHour.getMin());
                endHour.setValue(endHour.getMin());
                startMin.setValue(startMin.getMin());
                endMinute.setValue(endMinute.getMin());
                startDate.setValue(null);
                endDate.setValue(null);
                startPM.setSelected(false);
                endPM.setSelected(false);
                AMLabel1.setText("AM");
                AMLabel2.setText("AM"); }
            else {
                //If the dates are not selected, an error is given to the user
                difference.setText("ERROR: Please select 2 dates above");
            }
        }

        /**
         * This method will return the value in minutes of the difference between the 2 times entered
         * @return minutes; between the 2 times
         */
        private long findTimeDiff() {
            //Convert timepicker + sliders to datetime and find difference
            double convHour = Math.round(startHour.getValue()); //need to round here for appropriate conversion
            double convMin = Math.round(startMin.getValue());

            if (startPM.isSelected() && startHour.getValue() != 12.0) //changes 1:00PM -> 13:00
                convHour = startHour.getValue() + 12.0;
            else if (startHour.getValue() == 12.0 && startPM.isSelected() == false) //handles 12:00am -> 0:00 in conversion
                convHour = 0.0;
            LocalDateTime start = startDate.getValue().atTime((int)convHour,(int)convMin);
            convHour = Math.round(endHour.getValue());
            convMin = Math.round(endMinute.getValue());
            if (endPM.isSelected() && endHour.getValue() != 12.0) //changes 1:00PM -> 13:00
                convHour = endHour.getValue() + 12.0;
            else if (endHour.getValue() == 12.0 && endPM.isSelected() == false) //handles 12:00am -> 0:00 in conversion
                convHour = 0.0;
            LocalDateTime end = endDate.getValue().atTime((int)convHour,(int)convMin);

            long minutes = ChronoUnit.MINUTES.between(start,end);
            //long seconds = ChronoUnit.SECONDS.between(start,end) - (minutes*60) - (hours*60*60);
            return minutes;
        }

    /**
     * Initialize the objects of the FXML class
     */
        @FXML
        void initialize() {
            assert AMLabel1 != null : "fx:id=\"AMLabel1\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert AMLabel2 != null : "fx:id=\"AMLabel2\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert addEvent != null : "fx:id=\"addEvent\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert colon1 != null : "fx:id=\"colon1\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert colon2 != null : "fx:id=\"colon2\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert dateTimeEnd != null : "fx:id=\"dateTimeEnd\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert dateTimeStart != null : "fx:id=\"dateTimeStart\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert difference != null : "fx:id=\"difference\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert endDate != null : "fx:id=\"endDate\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert endHour != null : "fx:id=\"endHour\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert endHourText != null : "fx:id=\"endHourText\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert endMinText != null : "fx:id=\"endMinText\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert endMinute != null : "fx:id=\"endMinute\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert endPM != null : "fx:id=\"endPM\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert endTimeText != null : "fx:id=\"endTimeText\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert startDate != null : "fx:id=\"startDate\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert startHour != null : "fx:id=\"startHour\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert startHourText != null : "fx:id=\"startHourText\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert startMin != null : "fx:id=\"startMin\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert startMinText != null : "fx:id=\"startMinText\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert startPM != null : "fx:id=\"startPM\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert startTimeText != null : "fx:id=\"startTimeText\" was not injected: check your FXML file 'manualTimer.fxml'.";
            assert timeSpentText != null : "fx:id=\"timeSpentText\" was not injected: check your FXML file 'manualTimer.fxml'.";


            //have the time appear on the bottom based on slider from user input
            startHourText.textProperty().bind(startHour.valueProperty().asString("%02.0f"));
            endHourText.textProperty().bind(endHour.valueProperty().asString("%02.0f"));
            startMinText.textProperty().bind(startMin.valueProperty().asString("%02.0f"));
            endMinText.textProperty().bind(endMinute.valueProperty().asString("%02.0f"));
        }
    }


