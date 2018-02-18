// https://stackoverflow.com/questions/24082063/chessboard-with-automatic-resizing

package teamlewischess;

import javafx.application.Application;
import static javafx.application.Application.launch;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import teamlewischess.ImageViewPane;
import static java.nio.file.Files.size;
import static javafx.scene.paint.Color.color;

public class TeamLewisChess extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        final int size = 8 ;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                StackPane square = new StackPane();
                square.setMinSize(50,50);
                String pieceAbbrev = "";
                String colorAbbrev = "";
                String color ;
                Color colorCode;
                // row goes from 1 to 8 (0 to 7), column goes from 1 to 8(0 to 7)
                // row+ col % 2 == 0 >>  row 00,01, 02, 03, 04, 05, 06, 07,
                //                           10,11, 12, 13, 14, 15, 16, 17   
                //   56 56 58 59 60 61 62 63
                //   48 49 50 51 52 53 54 55
                //   40 41 42 43 44 45 46 47
                //   32 33 34 34 36 37 38 39
                //   24 25 26 27 28 29 30 31
                //   16 17 18 19 20 21 22 23
                //    8  9 10 11 12 13 14 15
                //    0  1  2  3  4  5  6  7
                //
                
                if ((row + col) % 2 == 0) {
                    //color = "antiquewhite"; //"white";
                    //colorCode = Color.rgb(0XFF,0XFA,0XCD,1.0);
                    color = "#FFFACD";
                    
                    //color = colorCode.toString();
                } else {
                    color = "#593E1A"; // "black";
                    //colorCode = Color.rgb(0X59,0X3E,0X1A,1.0);
                    //color = colorCode.toString();
                }
                
                if (row == 0 || row == 1)
                    colorAbbrev = "B";
                else if ((row == 7 )|| (row == 6))
                    colorAbbrev = "W";
                
                if (( row == 0 ) || (row == 7 )) {
                    if (col == 0 || col == 7 ) 
                        pieceAbbrev = "R";
                    else if (col == 1 || col == 6)
                        pieceAbbrev = "N";
                    else if ( col == 2 || col == 5)
                        pieceAbbrev = "B";
                    else if ( col == 3 ) 
                        pieceAbbrev = "Q";
                    else if ( col == 4 )
                        pieceAbbrev = "K";
                }
                
                if (( row == 1) || (row == 6)) {
                    pieceAbbrev = "P";
                }
                
                String imageName = colorAbbrev + pieceAbbrev + ".gif";
                //square.setStyle("-fx-background-color: #FFFZCDFF");
                square.setStyle("-fx-background-color: "+color+";"); //"+color+";");
                if (row == 0 || row == 1 || row == 6 || row ==7) {
                try {
                    Image img = new Image( getClass().getResource(imageName).openStream());
                    System.out.println("image name = " + imageName);
                    //Image img = new Image( getClass().getResource("Tigers.jpg").openStream());
                    ImageViewPane imageViewPane = new ImageViewPane(new ImageView(img));
                    square.getChildren().add(imageViewPane);
                } catch (IOException ex) {
                    //.getLogger(ImageViewPaneTest.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Failed with exception: " + ex.getMessage());
                }
                 //StackPane root = new StackPane();
                // root.getChildren().add(imageViewPane);
                }
                root.add(square, col, row);
                
            }
        }
        for (int i = 0; i < size; i++) {
            root.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            root.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
        
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
