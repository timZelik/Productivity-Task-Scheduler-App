# CSCI 205 - Software Engineering and Design
Bucknell University
Lewisburg, PA
### Course Info
Instructor: Professor King
Semester: Fall Semester 2021
## Team Information

Tim Zelikovsky: CS Major and Men's tennis athlete. Passionate about CS, scrum master for this project and 
excited to develop this project and flaunt about it in future interviews.

Austin Beal: Java/Coding Prometheus. 2024 CS & Math Double Major. Legendary problem-solving ability and extremely devoted to CS. 

Jordan Miller: 2024 CS Major. Striker on the Men's Soccer Team. Unreal athlete, great CS knowledge and easy to work with. 

Conrad Persowski: 2024 CS Minor. Very strong developer/coder. Great Problem-solving ability 
## Project Information
The project that we have created is designed to allow the user to manage their schedules and keep
everything that they need to get done. The user is able to enter their tasks and when they are due, 
log in the amount of time they have spent on specific problems, and even start and stop
timers to have a computer automatically keep track of the time spent. Once data has been logged, the
program is able to compile this data and determine the average time spent on each type of task,
which the user can use to reflect on how their time is spent, and make improvements based on 
this

If a person is an administrator of the project, they are given expanded functionality. Administrators
also have the ability to add users to the program, change who the  Admin of the program is, and 
even assign tasks to other users. The Administrator must have a set username and password, and will
be brought to a separate login screen if the admin button is selected, prompting them to
enter their login credentials

## Package Structure
Our package structure is as follows. We have a src folder which holds all the files within the project
The source package contains both a main and a test package, each containing a Java folder with the
respective code. The src/main/java package has two packages - a SchedulerMVC package, and a TestCodeThroughout
package. SchedulerMVC contains the main code to run the program. This includes, the Model, Controller, View
Main, and all the other associated classes, like Task and User. The TestCodeThroughout package is essentially
our 'scratch'  file, where we tested the code and tried out different things before implementing it in our
MVC code. In our src/test/java package, we have the three JUnit tests for our respective classes, and are able
to run these tests to determine whether our code functions properly or not


## Libraries
We used two external libraries within our project
- JavaFX v17, wih modules to javafx.controls and javafx.fxml
  - https://docs.oracle.com/javase/8/javafx/api/toc.htm
- JUnit v5.8, with the following modules
  - implementation 'org.junit.jupiter:junit-jupiter:5.7.0' 
  - testImplementation'org.junit.jupiter:junit-jupiter:5.8.0' 
  - testRuntimeOnly'org.junit.jupiter:junit-jupiter-engine:5.8.0'
  - https://junit.org/junit5/docs/current/user-guide/

## Presentation Video File
This is the link used to view our final project presentation video:
https://mediaspace.bucknell.edu/media/cscifinalprojvid/1_drcjpp3w
