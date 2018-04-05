/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamlewischess;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/*
 * Description pending...
 */
public class PromotionWindowController {
    
    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private ImageView Knight_ImageView;
    @FXML private ImageView Bishop_ImageView;
    @FXML private ImageView Queen_ImageView;
    @FXML private ImageView Rook_ImageView;

    @FXML void Bishop_ImageView_OnMouseEntered(MouseEvent event) {

    }

    @FXML void Bishop_ImageView_OnMouseExited(MouseEvent event) {

    }

    @FXML void Bishop_ImageView_OnMousePressed(MouseEvent event) {

    }

    @FXML void Bishop_ImageView_OnMouseReleased(MouseEvent event) {
        Board.isBeingPromotedToBishop = true;
        
        Stage stage = (Stage) Bishop_ImageView.getScene().getWindow();
        stage.close();
    }

    @FXML void Knight_ImageView_OnMouseEntered(MouseEvent event) {

    }

    @FXML void Knight_ImageView_OnMouseExited(MouseEvent event) {

    }

    @FXML void Knight_ImageView_OnMousePressed(MouseEvent event) {

    }

    @FXML void Knight_ImageView_OnMouseReleased(MouseEvent event) {
        Board.isBeingPromotedToKnight = true;

        Stage stage = (Stage) Knight_ImageView.getScene().getWindow();
        stage.close();
    }

    @FXML void Queen_ImageView_OnMouseEntered(MouseEvent event) {

    }

    @FXML void Queen_ImageView_OnMouseExited(MouseEvent event) {

    }

    @FXML void Queen_ImageView_OnMousePressed(MouseEvent event) {

    }

    @FXML void Queen_ImageView_OnMouseReleased(MouseEvent event) {
        Board.isBeingPromotedToQueen = true;
        
        Stage stage = (Stage) Queen_ImageView.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void Rook_ImageView_OnMouseEntered(MouseEvent event) {

    }

    @FXML
    void Rook_ImageView_OnMouseExited(MouseEvent event) {

    }

    @FXML
    void Rook_ImageView_OnMousePressed(MouseEvent event) {

    }

    @FXML
    void Rook_ImageView_OnMouseReleased(MouseEvent event) {
        Board.isBeingPromotedToRook = true;
        
        Stage stage = (Stage) Rook_ImageView.getScene().getWindow();
        stage.close();
    }

    @FXML void initialize() {
        assert Knight_ImageView != null : "fx:id=\"Knight_ImageView\" was not injected: check your FXML file 'promotionWindow.fxml'.";
        assert Bishop_ImageView != null : "fx:id=\"Bishop_ImageView\" was not injected: check your FXML file 'promotionWindow.fxml'.";
        assert Queen_ImageView != null : "fx:id=\"Queen_ImageView\" was not injected: check your FXML file 'promotionWindow.fxml'.";
        assert Rook_ImageView != null : "fx:id=\"Rook_ImageView\" was not injected: check your FXML file 'promotionWindow.fxml'.";
        
        Image imageOne;
        
        if (Game.getCurrentTeamsTurn() == 0) {            
            imageOne = new Image("/teamlewischess/images/whiteKnight.png");
            Knight_ImageView.setImage(imageOne);
            imageOne = new Image("/teamlewischess/images/whiteBishop.png");
            Bishop_ImageView.setImage(imageOne);
            imageOne = new Image("/teamlewischess/images/whiteQueen.png");
            Queen_ImageView.setImage(imageOne);
            imageOne = new Image("/teamlewischess/images/whiteRook.png");
            Rook_ImageView.setImage(imageOne);
        } else {
            imageOne = new Image("/teamlewischess/images/blackKnight.png");
            Knight_ImageView.setImage(imageOne);
            imageOne = new Image("/teamlewischess/images/blackBishop.png");
            Bishop_ImageView.setImage(imageOne);
            imageOne = new Image("/teamlewischess/images/blackQueen.png");
            Queen_ImageView.setImage(imageOne);
            imageOne = new Image("/teamlewischess/images/blackRook.png");
            Rook_ImageView.setImage(imageOne);
        }
    }
}
