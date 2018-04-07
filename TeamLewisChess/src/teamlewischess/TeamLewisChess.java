// TeamLewisChess.java
// Main application class that loads and displays Team Lewis's chess GUI.
package teamlewischess;

/**
 * package teamlewischess Main extends Application
 * 
 * @author TeamLewisChess Isaiah Gregov, Leana Tran, Adam Perry, Marcus Page, Peggy Haeger
 * 
 * Credits: The picture of the board and the piece movement sounds are taken from chess.com.
 * The pieces are free images taken from a free images website.
 */

//Imported to play piece move sounds:
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import javafx.animation.PauseTransition;
//import java.io.FileInputStream;
//import java.io.InputStream;
import javax.swing.JOptionPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
//import javafx.embed.swing.JFXPanel;

//Imported for GUI window:
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class TeamLewisChess extends Application {
    
    /**
     * 
     * @param stage FXML
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        displayWelcomeScreen();
     
        Parent root = FXMLLoader.load(getClass().getResource("TeamLewisChess.fxml"));

        Scene scene = new Scene(root); // attach scene graph to scene
        stage.setTitle("Team Lewis Chess"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.setResizable(false);
        stage.show(); // display the stage
    }
    /**
     * launches main application
     * @param args 
     */
    public static void main(String[] args) {      
      // create a TeamLewisChess object and call its start method
      launch(args);
    }
   
    //Call this method in Board class when piece moves but does not capture, place in check, or castles.
    //Credit: JavaTutorials101 on YouTube
    /**
     *  @see Board
     *  call this method in Board class when piece moves but does not capture, place in check, or castles.
     *  Credit: JavaTutorials101 on YouTube
     *  Requires move.wav  
     */
    public static void playSoundMove()
    {
        try {
            //JFXPanel j = new JFXPanel();
            String uri = new File("Move.wav").toURI().toString();
            new MediaPlayer(new Media(uri)).play();
            
            //JOptionPane.showMessageDialog(null, uri);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //Call this method in Board class when piece captures.
    //Credit: JavaTutorials101 on YouTube
    /**
     *  @see Board
     *  Call this method in Board class when piece captures.
     *  Credit: JavaTutorials101 on YouTube
     *  Requires capture.wav  
     */
    public static void playSoundCapture()
    {
        try {
            //JFXPanel j = new JFXPanel();
            String uri = new File("Capture.wav").toURI().toString();
            new MediaPlayer(new Media(uri)).play();
            
            //JOptionPane.showMessageDialog(null, uri);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //Call this method in Board class when piece is moved and enemy king is placed in check.
    //Credit: JavaTutorials101 on YouTube
     /**
     *  @see Board
     *  Call this method in Board class when piece is moved and enemy king is placed in check.
     *  Credit: JavaTutorials101 on YouTube
     *  Requires check.wav  
     */
    public static void playSoundCheck()
    {
        try {
            //JFXPanel j = new JFXPanel();
            String uri = new File("Check.wav").toURI().toString();
            new MediaPlayer(new Media(uri)).play();
            
            //JOptionPane.showMessageDialog(null, uri);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //Call this method in Board class when a king castles castles.
    //Credit: JavaTutorials101 on YouTube
    /**
     * @see Board
     * Call this method in Board class when a king castles castles.
     * Credit: JavaTutorials101 on YouTube
     * Requires: castle.wav
     */
    public static void playSoundCastle()
    {
        try {
            //JFXPanel j = new JFXPanel();
            String uri = new File("Castle.wav").toURI().toString();
            new MediaPlayer(new Media(uri)).play();
            
            //JOptionPane.showMessageDialog(null, uri);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
   }
    
    public void displayWelcomeScreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        Scene scene = new Scene(root); // attach scene graph to scene
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        
        //stage.setTitle("Team Lewis Chess"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();     
    }       
}

