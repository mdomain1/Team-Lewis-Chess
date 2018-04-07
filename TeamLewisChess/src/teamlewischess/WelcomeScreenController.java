package teamlewischess;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WelcomeScreenController {

   // @FXML private ImageView WelcomeScreen;
    
    @FXML public ImageView startGame;
    
    @FXML void startGame(MouseEvent event) {
       TeamLewisChess.playSoundMove();
        
       Stage stage = (Stage) startGame.getScene().getWindow();
       stage.close();
    }
}
