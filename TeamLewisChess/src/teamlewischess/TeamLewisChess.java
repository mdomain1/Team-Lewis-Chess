// TeamLewisChess.java
// Main application class that loads and displays Team Lewis's chess GUI.
package teamlewischess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TeamLewisChess extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = 
         FXMLLoader.load(getClass().getResource("TeamLewisChess.fxml"));

      Scene scene = new Scene(root); // attach scene graph to scene
      stage.setTitle("Team Lewis Chess"); // displayed in window's title bar
      stage.setScene(scene); // attach scene to stage
      stage.show(); // display the stage
   }

   public static void main(String[] args) {
      // create a TeamLewisChess object and call its start method
      launch(args);
   } 
}
