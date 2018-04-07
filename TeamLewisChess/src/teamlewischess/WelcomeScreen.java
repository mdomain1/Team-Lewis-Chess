package teamlewischess;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * Description pending...
 */
public class WelcomeScreen {
    
    /**
     *
     * @throws IOException
     */
    public void displayWelcomeScreen() throws IOException
    {
        playSoundMove();   
        
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        Scene scene = new Scene(root); // attach scene graph to scene
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        
        //stage.setTitle("Team Lewis Chess"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait(); // display the stage
        
        playSoundMove();
    }
    
    public static void playSoundMove()
    {
        try {
            String uri = new File("Move.wav").toURI().toString();
            new MediaPlayer(new Media(uri)).play();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
