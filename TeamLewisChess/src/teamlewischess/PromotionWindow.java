/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamlewischess;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author grano
 */
public class PromotionWindow {
    
    public void displayPromotionWindow() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("promotionWindow.fxml"));

        Scene scene = new Scene(root); // attach scene graph to scene
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(final WindowEvent event) {
                event.consume();
            }
        });
        
        //stage.setTitle("Team Lewis Chess"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait(); // display the stage
    }
}
