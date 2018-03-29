package teamlewischess;

// TeamLewisChessController.java
// Controller that handles Rectangle and ImageView events, as well as the File menu events.
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class TeamLewisChessController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private Rectangle A8_Rectangle;
    @FXML private Rectangle A7_Rectangle;
    @FXML private Rectangle A6_Rectangle;
    @FXML private Rectangle A5_Rectangle;
    @FXML private Rectangle A4_Rectangle;
    @FXML private Rectangle A3_Rectangle;
    @FXML private Rectangle A2_Rectangle;
    @FXML private Rectangle A1_Rectangle;
    @FXML private Rectangle B8_Rectangle;
    @FXML private Rectangle B7_Rectangle;
    @FXML private Rectangle B6_Rectangle;
    @FXML private Rectangle B5_Rectangle;
    @FXML private Rectangle B4_Rectangle;
    @FXML private Rectangle B3_Rectangle;
    @FXML private Rectangle B2_Rectangle;
    @FXML private Rectangle B1_Rectangle;
    @FXML private Rectangle C8_Rectangle;
    @FXML private Rectangle C7_Rectangle;
    @FXML private Rectangle C6_Rectangle;
    @FXML private Rectangle C5_Rectangle;
    @FXML private Rectangle C4_Rectangle;
    @FXML private Rectangle C3_Rectangle;
    @FXML private Rectangle C2_Rectangle;
    @FXML private Rectangle C1_Rectangle;
    @FXML private Rectangle D8_Rectangle;
    @FXML private Rectangle D7_Rectangle;
    @FXML private Rectangle D6_Rectangle;
    @FXML private Rectangle D5_Rectangle;
    @FXML private Rectangle D4_Rectangle;
    @FXML private Rectangle D3_Rectangle;
    @FXML private Rectangle D2_Rectangle;
    @FXML private Rectangle D1_Rectangle;
    @FXML private Rectangle E8_Rectangle;
    @FXML private Rectangle E7_Rectangle;
    @FXML private Rectangle E6_Rectangle;
    @FXML private Rectangle E5_Rectangle;
    @FXML private Rectangle E4_Rectangle;
    @FXML private Rectangle E3_Rectangle;
    @FXML private Rectangle E2_Rectangle;
    @FXML private Rectangle E1_Rectangle;
    @FXML private Rectangle F8_Rectangle;
    @FXML private Rectangle F7_Rectangle;
    @FXML private Rectangle F6_Rectangle;
    @FXML private Rectangle F5_Rectangle;
    @FXML private Rectangle F4_Rectangle;
    @FXML private Rectangle F3_Rectangle;
    @FXML private Rectangle F2_Rectangle;
    @FXML private Rectangle F1_Rectangle;
    @FXML private Rectangle G8_Rectangle;
    @FXML private Rectangle G7_Rectangle;
    @FXML private Rectangle G6_Rectangle;
    @FXML private Rectangle G5_Rectangle;
    @FXML private Rectangle G4_Rectangle;
    @FXML private Rectangle G3_Rectangle;
    @FXML private Rectangle G2_Rectangle;
    @FXML private Rectangle G1_Rectangle;
    @FXML private Rectangle H8_Rectangle;
    @FXML private Rectangle H7_Rectangle;
    @FXML private Rectangle H6_Rectangle;
    @FXML private Rectangle H5_Rectangle;
    @FXML private Rectangle H4_Rectangle;
    @FXML private Rectangle H3_Rectangle;
    @FXML private Rectangle H2_Rectangle;
    @FXML private Rectangle H1_Rectangle;

    @FXML private ImageView A8_ImageView;
    @FXML private ImageView A7_ImageView;
    @FXML private ImageView A6_ImageView;
    @FXML private ImageView A5_ImageView;
    @FXML private ImageView A4_ImageView;
    @FXML private ImageView A3_ImageView;
    @FXML private ImageView A2_ImageView;
    @FXML private ImageView A1_ImageView;
    @FXML private ImageView B8_ImageView;
    @FXML private ImageView B7_ImageView;
    @FXML private ImageView B6_ImageView;
    @FXML private ImageView B5_ImageView;
    @FXML private ImageView B4_ImageView;
    @FXML private ImageView B3_ImageView;
    @FXML private ImageView B2_ImageView;
    @FXML private ImageView B1_ImageView;
    @FXML private ImageView C8_ImageView;
    @FXML private ImageView C7_ImageView;
    @FXML private ImageView C6_ImageView;
    @FXML private ImageView C5_ImageView;
    @FXML private ImageView C4_ImageView;
    @FXML private ImageView C3_ImageView;
    @FXML private ImageView C2_ImageView;
    @FXML private ImageView C1_ImageView;
    @FXML private ImageView D8_ImageView;
    @FXML private ImageView D7_ImageView;
    @FXML private ImageView D6_ImageView;
    @FXML private ImageView D5_ImageView;
    @FXML private ImageView D4_ImageView;
    @FXML private ImageView D3_ImageView;
    @FXML private ImageView D2_ImageView;
    @FXML private ImageView D1_ImageView;
    @FXML private ImageView E8_ImageView;
    @FXML private ImageView E7_ImageView;
    @FXML private ImageView E6_ImageView;
    @FXML private ImageView E5_ImageView;
    @FXML private ImageView E4_ImageView;
    @FXML private ImageView E3_ImageView;
    @FXML private ImageView E2_ImageView;
    @FXML private ImageView E1_ImageView;
    @FXML private ImageView F8_ImageView;
    @FXML private ImageView F7_ImageView;
    @FXML private ImageView F6_ImageView;
    @FXML private ImageView F5_ImageView;
    @FXML private ImageView F4_ImageView;
    @FXML private ImageView F3_ImageView;
    @FXML private ImageView F2_ImageView;
    @FXML private ImageView F1_ImageView;
    @FXML private ImageView G8_ImageView;
    @FXML private ImageView G7_ImageView;
    @FXML private ImageView G6_ImageView;
    @FXML private ImageView G5_ImageView;
    @FXML private ImageView G4_ImageView;
    @FXML private ImageView G3_ImageView;
    @FXML private ImageView G2_ImageView;
    @FXML private ImageView G1_ImageView;
    @FXML private ImageView H8_ImageView;
    @FXML private ImageView H7_ImageView;
    @FXML private ImageView H6_ImageView;
    @FXML private ImageView H5_ImageView;
    @FXML private ImageView H4_ImageView;
    @FXML private ImageView H3_ImageView;
    @FXML private ImageView H2_ImageView;
    @FXML private ImageView H1_ImageView;
    
    Game oneGame = new Game();
    static private int squareClicked;
    static private int squareMovedTo;
    static private int imageToUpdateSquareMovedTo;
    static private int specialSquareToWipe;
    static private int specialSquareMovedTo;
    static private int imageToUpdateSpecialSquareMovedTo;
    static private boolean highlightSquareClicked;
    
    @FXML void A1_ImageViewClicked(MouseEvent event) {
        //Testing / to be updated / for demonstration:
        oneGame.determineAndExeLogicAction();
    }

    @FXML void A2_ImageViewClicked(MouseEvent event) {
       
    }

    @FXML void A3_ImageViewClicked(MouseEvent event) {
        //It works!!!!
        Image movedPawn;
        movedPawn = new Image("/teamlewischess/images/whitepawn.png");
        A3_ImageView.setImage(movedPawn);
        A2_ImageView.setImage(null);
    }

    @FXML void A4_ImageViewClicked(MouseEvent event) {

    }

    @FXML void A5_ImageViewClicked(MouseEvent event) {

    }

    @FXML void A6_ImageViewClicked(MouseEvent event) {

    }

    @FXML void A7_ImageViewClicked(MouseEvent event) {

    }

    @FXML void A8_ImageViewClicked(MouseEvent event) {

    }

    @FXML void B1_ImageViewClicked(MouseEvent event) {

    }

    @FXML void B2_ImageViewClicked(MouseEvent event) {

    }

    @FXML void B3_ImageViewClicked(MouseEvent event) {

    }

    @FXML void B4_ImageViewClicked(MouseEvent event) {

    }

    @FXML void B5_ImageViewClicked(MouseEvent event) {

    }

    @FXML void B6_ImageViewClicked(MouseEvent event) {

    }

    @FXML void B7_ImageViewClicked(MouseEvent event) {

    }

    @FXML void B8_ImageViewClicked(MouseEvent event) {

    }

    @FXML void C1_ImageViewClicked(MouseEvent event) {

    }

    @FXML void C2_ImageViewClicked(MouseEvent event) {

    }

    @FXML void C3_ImageViewClicked(MouseEvent event) {

    }

    @FXML void C4_ImageViewClicked(MouseEvent event) {

    }

    @FXML void C5_ImageViewClicked(MouseEvent event) {

    }

    @FXML void C6_ImageViewClicked(MouseEvent event) {

    }

    @FXML void C7_ImageViewClicked(MouseEvent event) {

    }

    @FXML void D1_ImageViewClicked(MouseEvent event) {

    }

    @FXML void D2_ImageViewClicked(MouseEvent event) {

    }

    @FXML void D3_ImageViewClicked(MouseEvent event) {

    }

    @FXML void D4_ImageViewClicked(MouseEvent event) {

    }

    @FXML void D5_ImageViewClicked(MouseEvent event) {

    }

    @FXML void D6_ImageViewClicked(MouseEvent event) {

    }

    @FXML void D7_ImageViewClicked(MouseEvent event) {

    }

    @FXML void D8_ImageViewClicked(MouseEvent event) {

    }

    @FXML void E1_ImageViewClicked(MouseEvent event) {

    }

    @FXML void E2_ImageViewClicked(MouseEvent event) {

    }

    @FXML void E3_ImageViewClicked(MouseEvent event) {

    }

    @FXML void E4_ImageViewClicked(MouseEvent event) {

    }

    @FXML void E5_ImageViewClicked(MouseEvent event) {

    }

    @FXML void E6_ImageViewClicked(MouseEvent event) {

    }

    @FXML void E7_ImageViewClicked(MouseEvent event) {

    }

    @FXML void E8_ImageViewClicked(MouseEvent event) {

    }

    @FXML void F1_ImageViewClicked(MouseEvent event) {

    }

    @FXML void F2_ImageViewClicked(MouseEvent event) {

    }

    @FXML void F3_ImageViewClicked(MouseEvent event) {

    }

    @FXML void F4_ImageViewClicked(MouseEvent event) {

    }

    @FXML void F5_ImageViewClicked(MouseEvent event) {

    }

    @FXML void F6_ImageViewClicked(MouseEvent event) {

    }

    @FXML void F7_ImageViewClicked(MouseEvent event) {

    }

    @FXML void F8_ImageViewClicked(MouseEvent event) {

    }

    @FXML void G1_ImageViewClicked(MouseEvent event) {

    }

    @FXML void G2_ImageViewClicked(MouseEvent event) {

    }

    @FXML void G3_ImageViewClicked(MouseEvent event) {

    }

    @FXML void G4_ImageViewClicked(MouseEvent event) {

    }

    @FXML void G5_ImageViewClicked(MouseEvent event) {

    }

    @FXML void G6_ImageViewClicked(MouseEvent event) {

    }

    @FXML void G7_ImageViewClicked(MouseEvent event) {

    }

    @FXML void G8_ImageViewClicked(MouseEvent event) {

    }

    @FXML void H1_ImageViewClicked(MouseEvent event) {

    }

    @FXML void H2_ImageViewClicked(MouseEvent event) {

    }

    @FXML void H3_ImageViewClicked(MouseEvent event) {

    }

    @FXML void H4_ImageViewClicked(MouseEvent event) {

    }

    @FXML void H5_ImageViewClicked(MouseEvent event) {

    }

    @FXML void H6_ImageViewClicked(MouseEvent event) {

    }

    @FXML void H7_ImageViewClicked(MouseEvent event) {

    }

    @FXML void H8_ImageViewClicked(MouseEvent event) {

    }

    @FXML void NewGameMenuItemClicked(ActionEvent event) {
        
    }
    
    @FXML void CloseMenuItemClicked(ActionEvent event) {
        System.exit(0);
    }
    
    private void updateSquareImages()
    {
        
    }
    
    private void updateHighlightValue()
    {
        
    }
    
    static public void resetSquareAndImageVar()
    {
        
    }
    
    static public int getSquareClicked()
    {
        return squareClicked;
    }
        
    static public void setSquareMovedTo(int fSquare)
    {
        
    }
        
    static public void setImageToUpdateSquareMovedTo(int fImage)
    {
        
    }
       
    static public void setSpecialSquareToWipe(int fSquare)
    {
        
    }

    static public void setSpecialSquareMovedTo(int fSquare)
    {
        
    }
    
    static public void setImageToUpdateSpecialSquareMovedTo(int fImage)
    {
        
    }
        
    static public void setHighlightSquareClicked(boolean fHighlight)
    {
        
    }

    @FXML void initialize() {
        assert A8_Rectangle != null : "fx:id=\"A8_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A7_Rectangle != null : "fx:id=\"A7_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A6_Rectangle != null : "fx:id=\"A6_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A5_Rectangle != null : "fx:id=\"A5_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A4_Rectangle != null : "fx:id=\"A4_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A3_Rectangle != null : "fx:id=\"A3_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A2_Rectangle != null : "fx:id=\"A2_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A1_Rectangle != null : "fx:id=\"A1_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B8_Rectangle != null : "fx:id=\"B8_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B7_Rectangle != null : "fx:id=\"B7_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B6_Rectangle != null : "fx:id=\"B6_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B5_Rectangle != null : "fx:id=\"B5_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B4_Rectangle != null : "fx:id=\"B4_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B3_Rectangle != null : "fx:id=\"B3_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B2_Rectangle != null : "fx:id=\"B2_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B1_Rectangle != null : "fx:id=\"B1_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C8_Rectangle != null : "fx:id=\"C8_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C7_Rectangle != null : "fx:id=\"C7_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C6_Rectangle != null : "fx:id=\"C6_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C5_Rectangle != null : "fx:id=\"C5_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C4_Rectangle != null : "fx:id=\"C4_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C3_Rectangle != null : "fx:id=\"C3_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C2_Rectangle != null : "fx:id=\"C2_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C1_Rectangle != null : "fx:id=\"C1_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D8_Rectangle != null : "fx:id=\"D8_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D7_Rectangle != null : "fx:id=\"D7_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D6_Rectangle != null : "fx:id=\"D6_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D5_Rectangle != null : "fx:id=\"D5_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D4_Rectangle != null : "fx:id=\"D4_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D3_Rectangle != null : "fx:id=\"D3_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D2_Rectangle != null : "fx:id=\"D2_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D1_Rectangle != null : "fx:id=\"D1_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E8_Rectangle != null : "fx:id=\"E8_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E7_Rectangle != null : "fx:id=\"E7_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E6_Rectangle != null : "fx:id=\"E6_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E5_Rectangle != null : "fx:id=\"E5_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E4_Rectangle != null : "fx:id=\"E4_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E3_Rectangle != null : "fx:id=\"E3_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E2_Rectangle != null : "fx:id=\"E2_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E1_Rectangle != null : "fx:id=\"E1_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F8_Rectangle != null : "fx:id=\"F8_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F7_Rectangle != null : "fx:id=\"F7_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F6_Rectangle != null : "fx:id=\"F6_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F5_Rectangle != null : "fx:id=\"F5_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F4_Rectangle != null : "fx:id=\"F4_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F3_Rectangle != null : "fx:id=\"F3_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F2_Rectangle != null : "fx:id=\"F2_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F1_Rectangle != null : "fx:id=\"F1_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G8_Rectangle != null : "fx:id=\"G8_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G7_Rectangle != null : "fx:id=\"G7_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G6_Rectangle != null : "fx:id=\"G6_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G5_Rectangle != null : "fx:id=\"G5_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G4_Rectangle != null : "fx:id=\"G4_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G3_Rectangle != null : "fx:id=\"G3_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G2_Rectangle != null : "fx:id=\"G2_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G1_Rectangle != null : "fx:id=\"G1_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H8_Rectangle != null : "fx:id=\"H8_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H7_Rectangle != null : "fx:id=\"H7_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H6_Rectangle != null : "fx:id=\"H6_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H5_Rectangle != null : "fx:id=\"H5_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H4_Rectangle != null : "fx:id=\"H4_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H3_Rectangle != null : "fx:id=\"H3_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H2_Rectangle != null : "fx:id=\"H2_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H1_Rectangle != null : "fx:id=\"H1_Rectangle\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A8_ImageView != null : "fx:id=\"A8_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A7_ImageView != null : "fx:id=\"A7_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A6_ImageView != null : "fx:id=\"A6_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A5_ImageView != null : "fx:id=\"A5_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A4_ImageView != null : "fx:id=\"A4_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A3_ImageView != null : "fx:id=\"A3_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A2_ImageView != null : "fx:id=\"A2_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert A1_ImageView != null : "fx:id=\"A1_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B8_ImageView != null : "fx:id=\"B8_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B7_ImageView != null : "fx:id=\"B7_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B6_ImageView != null : "fx:id=\"B6_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B5_ImageView != null : "fx:id=\"B5_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B4_ImageView != null : "fx:id=\"B4_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B3_ImageView != null : "fx:id=\"B3_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B2_ImageView != null : "fx:id=\"B2_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert B1_ImageView != null : "fx:id=\"B1_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C8_ImageView != null : "fx:id=\"C8_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C7_ImageView != null : "fx:id=\"C7_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C6_ImageView != null : "fx:id=\"C6_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C5_ImageView != null : "fx:id=\"C5_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C4_ImageView != null : "fx:id=\"C4_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C3_ImageView != null : "fx:id=\"C3_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C2_ImageView != null : "fx:id=\"C2_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert C1_ImageView != null : "fx:id=\"C1_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D8_ImageView != null : "fx:id=\"D8_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D7_ImageView != null : "fx:id=\"D7_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D6_ImageView != null : "fx:id=\"D6_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D5_ImageView != null : "fx:id=\"D5_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D4_ImageView != null : "fx:id=\"D4_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D3_ImageView != null : "fx:id=\"D3_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D2_ImageView != null : "fx:id=\"D2_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert D1_ImageView != null : "fx:id=\"D1_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E8_ImageView != null : "fx:id=\"E8_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E7_ImageView != null : "fx:id=\"E7_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E6_ImageView != null : "fx:id=\"E6_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E5_ImageView != null : "fx:id=\"E5_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E4_ImageView != null : "fx:id=\"E4_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E3_ImageView != null : "fx:id=\"E3_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E2_ImageView != null : "fx:id=\"E2_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert E1_ImageView != null : "fx:id=\"E1_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F8_ImageView != null : "fx:id=\"F8_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F7_ImageView != null : "fx:id=\"F7_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F6_ImageView != null : "fx:id=\"F6_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F5_ImageView != null : "fx:id=\"F5_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F4_ImageView != null : "fx:id=\"F4_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F3_ImageView != null : "fx:id=\"F3_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F2_ImageView != null : "fx:id=\"F2_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert F1_ImageView != null : "fx:id=\"F1_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G8_ImageView != null : "fx:id=\"G8_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G7_ImageView != null : "fx:id=\"G7_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G6_ImageView != null : "fx:id=\"G6_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G5_ImageView != null : "fx:id=\"G5_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G4_ImageView != null : "fx:id=\"G4_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G3_ImageView != null : "fx:id=\"G3_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G2_ImageView != null : "fx:id=\"G2_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert G1_ImageView != null : "fx:id=\"G1_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H8_ImageView != null : "fx:id=\"H8_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H7_ImageView != null : "fx:id=\"H7_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H6_ImageView != null : "fx:id=\"H6_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H5_ImageView != null : "fx:id=\"H5_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H4_ImageView != null : "fx:id=\"H4_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H3_ImageView != null : "fx:id=\"H3_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H2_ImageView != null : "fx:id=\"H2_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
        assert H1_ImageView != null : "fx:id=\"H1_ImageView\" was not injected: check your FXML file 'TeamLewisChess.fxml'.";
    }
}
