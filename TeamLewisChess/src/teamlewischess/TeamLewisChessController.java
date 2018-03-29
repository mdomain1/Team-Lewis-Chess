package teamlewischess;

// TeamLewisChessController.java
// Controller that handles Rectangle and ImageView events, as well as the File menu events.
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class TeamLewisChessController implements Initializable{

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
    
    @FXML private Pane A8_Pane;
    @FXML private Pane A7_Pane;
    @FXML private Pane A6_Pane;
    @FXML private Pane A5_Pane;
    @FXML private Pane A4_Pane;
    @FXML private Pane A3_Pane;
    @FXML private Pane A2_Pane;
    @FXML private Pane A1_Pane;
    @FXML private Pane B8_Pane;
    @FXML private Pane B7_Pane;
    @FXML private Pane B6_Pane;
    @FXML private Pane B5_Pane;
    @FXML private Pane B4_Pane;
    @FXML private Pane B3_Pane;
    @FXML private Pane B2_Pane;
    @FXML private Pane B1_Pane;
    @FXML private Pane C8_Pane;
    @FXML private Pane C7_Pane;
    @FXML private Pane C6_Pane;
    @FXML private Pane C5_Pane;
    @FXML private Pane C4_Pane;
    @FXML private Pane C3_Pane;
    @FXML private Pane C2_Pane;
    @FXML private Pane C1_Pane;
    @FXML private Pane D8_Pane;
    @FXML private Pane D7_Pane;
    @FXML private Pane D6_Pane;
    @FXML private Pane D5_Pane;
    @FXML private Pane D4_Pane;
    @FXML private Pane D3_Pane;
    @FXML private Pane D2_Pane;
    @FXML private Pane D1_Pane;
    @FXML private Pane E8_Pane;
    @FXML private Pane E7_Pane;
    @FXML private Pane E6_Pane;
    @FXML private Pane E5_Pane;
    @FXML private Pane E4_Pane;
    @FXML private Pane E3_Pane;
    @FXML private Pane E2_Pane;
    @FXML private Pane E1_Pane;
    @FXML private Pane F8_Pane;
    @FXML private Pane F7_Pane;
    @FXML private Pane F6_Pane;
    @FXML private Pane F5_Pane;
    @FXML private Pane F4_Pane;
    @FXML private Pane F3_Pane;
    @FXML private Pane F2_Pane;
    @FXML private Pane F1_Pane;
    @FXML private Pane G8_Pane;
    @FXML private Pane G7_Pane;
    @FXML private Pane G6_Pane;
    @FXML private Pane G5_Pane;
    @FXML private Pane G4_Pane;
    @FXML private Pane G3_Pane;
    @FXML private Pane G2_Pane;
    @FXML private Pane G1_Pane;
    @FXML private Pane H8_Pane;
    @FXML private Pane H7_Pane;
    @FXML private Pane H6_Pane;
    @FXML private Pane H5_Pane;
    @FXML private Pane H4_Pane;
    @FXML private Pane H3_Pane;
    @FXML private Pane H2_Pane;
    @FXML private Pane H1_Pane;
    
    @FXML private Image A8_Image;
    @FXML private Image A7_Image;
    @FXML private Image A6_Image;
    @FXML private Image A5_Image;
    @FXML private Image A4_Image;
    @FXML private Image A3_Image;
    @FXML private Image A2_Image;
    @FXML private Image A1_Image;
    @FXML private Image B8_Image;
    @FXML private Image B7_Image;
    @FXML private Image B6_Image;
    @FXML private Image B5_Image;
    @FXML private Image B4_Image;
    @FXML private Image B3_Image;
    @FXML private Image B2_Image;
    @FXML private Image B1_Image;
    @FXML private Image C8_Image;
    @FXML private Image C7_Image;
    @FXML private Image C6_Image;
    @FXML private Image C5_Image;
    @FXML private Image C4_Image;
    @FXML private Image C3_Image;
    @FXML private Image C2_Image;
    @FXML private Image C1_Image;
    @FXML private Image D8_Image;
    @FXML private Image D7_Image;
    @FXML private Image D6_Image;
    @FXML private Image D5_Image;
    @FXML private Image D4_Image;
    @FXML private Image D3_Image;
    @FXML private Image D2_Image;
    @FXML private Image D1_Image;
    @FXML private Image E8_Image;
    @FXML private Image E7_Image;
    @FXML private Image E6_Image;
    @FXML private Image E5_Image;
    @FXML private Image E4_Image;
    @FXML private Image E3_Image;
    @FXML private Image E2_Image;
    @FXML private Image E1_Image;
    @FXML private Image F8_Image;
    @FXML private Image F7_Image;
    @FXML private Image F6_Image;
    @FXML private Image F5_Image;
    @FXML private Image F4_Image;
    @FXML private Image F3_Image;
    @FXML private Image F2_Image;
    @FXML private Image F1_Image;
    @FXML private Image G8_Image;
    @FXML private Image G7_Image;
    @FXML private Image G6_Image;
    @FXML private Image G5_Image;
    @FXML private Image G4_Image;
    @FXML private Image G3_Image;
    @FXML private Image G2_Image;
    @FXML private Image G1_Image;
    @FXML private Image H8_Image;
    @FXML private Image H7_Image;
    @FXML private Image H6_Image;
    @FXML private Image H5_Image;
    @FXML private Image H4_Image;
    @FXML private Image H3_Image;
    @FXML private Image H2_Image;
    @FXML private Image H1_Image;
    
    List<Pane> paneList = new ArrayList<>();
    List<Image> imgList= new ArrayList<>();
    List<ImageView> iviews = new ArrayList<>();
    List<String> imageNames = new ArrayList<>();
    
    String imgPrefix = "resources/images/";
    String imgName = "";
    String pieceAbbrev = "";
    String colorAbbrev = "";
    String colorTop = "B";
    String colorBottom = "W";   // ""
    final int NUM_SQUARE_SIDE = 8;
    private static Node pick1 = null;
    private static Node pick2 = null;
    private static Pane mMove1 = null;
    private static Pane mMove2 = null;
    private static int mClick = 0;
    private static int firstHash = 0;
    private static int secondHash = 0;
    private static int firstHashT = 0;
    private static int secondHashT = 0;
    private static Pane moveFromPane = null;
    private static Pane moveToPane = null;
    private static ImageView ivMove = null;
    private static ImageView ivTaken = null;
    private  ImageView imv1 = new ImageView();
    private  ImageView imv2 = new ImageView();
    private static final Image imEmpty = new Image("teamlewischess/images/empty.png");
    private static final ImageView imvEmpty = new ImageView(imEmpty);
    
    Game oneGame = new Game();
    
    //@Override
    public void initialize(URL url, ResourceBundle rg) {
                iviews.add(A8_ImageView);iviews.add(B8_ImageView);iviews.add(C8_ImageView);iviews.add(D8_ImageView);
        iviews.add(E8_ImageView);iviews.add(F8_ImageView);iviews.add(G8_ImageView);iviews.add(H8_ImageView);
        iviews.add(A7_ImageView);iviews.add(B7_ImageView);iviews.add(C7_ImageView);iviews.add(D7_ImageView);
        iviews.add(E7_ImageView);iviews.add(F7_ImageView);iviews.add(G7_ImageView);iviews.add(H7_ImageView); 
        iviews.add(A6_ImageView);iviews.add(B6_ImageView);iviews.add(C6_ImageView);iviews.add(D6_ImageView);
        iviews.add(E6_ImageView);iviews.add(F6_ImageView);iviews.add(G6_ImageView);iviews.add(H6_ImageView);  
        iviews.add(A5_ImageView);iviews.add(B5_ImageView);iviews.add(C5_ImageView);iviews.add(D5_ImageView);
        iviews.add(E5_ImageView);iviews.add(F5_ImageView);iviews.add(G5_ImageView);iviews.add(H5_ImageView);  
        iviews.add(A4_ImageView);iviews.add(B4_ImageView);iviews.add(C4_ImageView);iviews.add(D4_ImageView);
        iviews.add(E4_ImageView);iviews.add(F4_ImageView);iviews.add(G4_ImageView);iviews.add(H4_ImageView); 
        iviews.add(A3_ImageView);iviews.add(B3_ImageView);iviews.add(C3_ImageView);iviews.add(D3_ImageView);
        iviews.add(E3_ImageView);iviews.add(F3_ImageView);iviews.add(G3_ImageView);iviews.add(H3_ImageView);
        iviews.add(A2_ImageView);iviews.add(B2_ImageView);iviews.add(C2_ImageView);iviews.add(D2_ImageView);
        iviews.add(E2_ImageView);iviews.add(F2_ImageView);iviews.add(G2_ImageView);iviews.add(H2_ImageView); 
        iviews.add(A1_ImageView);iviews.add(B1_ImageView);iviews.add(C1_ImageView);iviews.add(D1_ImageView);
        iviews.add(E1_ImageView);iviews.add(F1_ImageView);iviews.add(G1_ImageView);iviews.add(H1_ImageView);
        
        paneList.add(A8_Pane);paneList.add(B8_Pane);paneList.add(C8_Pane);paneList.add(D8_Pane);
        paneList.add(E8_Pane);paneList.add(F8_Pane);paneList.add(G8_Pane);paneList.add(H8_Pane);
        paneList.add(A7_Pane);paneList.add(B7_Pane);paneList.add(C7_Pane);paneList.add(D7_Pane);
        paneList.add(E7_Pane);paneList.add(F7_Pane);paneList.add(G7_Pane);paneList.add(H7_Pane); 
        paneList.add(A6_Pane);paneList.add(B6_Pane);paneList.add(C6_Pane);paneList.add(D6_Pane);
        paneList.add(E6_Pane);paneList.add(F6_Pane);paneList.add(G6_Pane);paneList.add(H6_Pane);  
        paneList.add(A5_Pane);paneList.add(B5_Pane);paneList.add(C5_Pane);paneList.add(D5_Pane);
        paneList.add(E5_Pane);paneList.add(F5_Pane);paneList.add(G5_Pane);paneList.add(H5_Pane);  
        paneList.add(A4_Pane);paneList.add(B4_Pane);paneList.add(C4_Pane);paneList.add(D4_Pane);
        paneList.add(E4_Pane);paneList.add(F4_Pane);paneList.add(G4_Pane);paneList.add(H4_Pane); 
        paneList.add(A3_Pane);paneList.add(B3_Pane);paneList.add(C3_Pane);paneList.add(D3_Pane);
        paneList.add(E3_Pane);paneList.add(F3_Pane);paneList.add(G3_Pane);paneList.add(H3_Pane);
        paneList.add(A2_Pane);paneList.add(B2_Pane);paneList.add(C2_Pane);paneList.add(D2_Pane);
        paneList.add(E2_Pane);paneList.add(F2_Pane);paneList.add(G2_Pane);paneList.add(H2_Pane); 
        paneList.add(A1_Pane);paneList.add(B1_Pane);paneList.add(C1_Pane);paneList.add(D1_Pane);
        paneList.add(E1_Pane);paneList.add(F1_Pane);paneList.add(G1_Pane);paneList.add(H1_Pane);
      
        System.out.println("calling setImageNames");
        setImageNames();
        for (Pane pane : paneList) {
            pane.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (mClick == 0) {
                        // TODO 
                        firstHash = 0;
                        firstHashT = 0;
                        secondHash = 0;
                        secondHashT = 0;
                    }
                    mClick++;
                    if (mClick == 1) {
                        System.out.println("\n\nclicked it 1");
                        System.out.println("Target: " + event.getTarget());
                        System.out.println("Source: " + event.getSource());
                        
                        firstHash = event.getSource().hashCode();
                        firstHashT = event.getTarget().hashCode();
                        System.out.println("1: firstHash = " + firstHash);
                        System.out.println("1: firstHashT = " + firstHashT);
                        if(firstHash == firstHashT) {
                            mClick=0;
                            System.out.println("fistHash = firstHashT");
                        }else {
                        moveFromPane = (Pane) event.getSource();
                        System.out.println("moveFromPane children = " + moveFromPane.getChildren().size());
                        imv1 = (ImageView) event.getTarget();
                        if (imv1.getImage() == null) {
                            System.out.println("imv1 get imge = null");

                            mClick = 0;
                        } else if (imv1.getImage() != null) {

                            System.out.println("image at imv1 not equal to null");
                            imv1 = (ImageView) event.getTarget();
                            //Image img1 = imv1.getImage();
                            //ImageView currentImage = new ImageView();
                            //currentImage.setImage(img1);
                            //currentImage.setId(img1.getClass().getSimpleName() + System.currentTimeMillis());
                            //System.out.println("currentImage.getId() " + currentImage.getId());

                            //moveFromPane.getChildren().remove(imv1);
                        } else {
                            System.out.println("1: Shouldn't get here");
                            mClick = 0;
                        }
                        }

                    } else if (mClick == 2) {
                        System.out.println("\nclicked it 2");
                        System.out.println("Target: " + event.getTarget());
                        System.out.println("Source: " + event.getSource());
                        secondHash = event.getSource().hashCode();
                        secondHashT = event.getTarget().hashCode();
                        System.out.println("2: hashCode = " + secondHash);
                        System.out.println("2: hashCodeT = " + secondHashT);
                        moveToPane = (Pane) event.getSource();
                        imv2 = (ImageView) event.getTarget();
                        if (imv2.getImage() == null) {

                            System.out.println("imv2 equal to null ...");
                            Image im2 = imv2.getImage();

                            //moveToPane.getChildren().remove(imv2);
                            moveToPane.getChildren().add(imv1);
                            moveFromPane.getChildren().remove(imv1);
                            moveFromPane.getChildren().add(imvEmpty);
                            System.out.println("added imageview");

                            mClick = 0;
                        } else if (imv2.getImage() != null) {
                            if (firstHash != secondHash) {
                                System.out.println("firstHash != secondHash");
                                moveToPane.getChildren().remove(imv2);
                                moveToPane.getChildren().add(imv1);
                                moveFromPane.getChildren().remove(imv1);
                                moveFromPane.getChildren().add(imvEmpty);

                                mClick = 0;
                            }else {
                                System.out.println("first hash == secondHash");
                                mClick = 1;
                            }
                            
                            
                        } else {
                            System.out.println("2: Shouldn't be here");
                            mClick=0;
                        }

                    }
                }
            });
        }
    } // end initialize
    
    @FXML void A1_ImageViewClicked(MouseEvent event) {
        oneGame.determineAndExeLogicAction();
    }

    @FXML
    void A2_ImageViewClicked(MouseEvent event) {     
    }

    @FXML
    void A3_ImageViewClicked(MouseEvent event) {
        //It works!!!!
//        Image movedPawn;
//        movedPawn = new Image("/teamlewischess/images/WP.png");
//        A3_ImageView.setImage(movedPawn);
//        A2_ImageView.setImage(null);
//          event.consume();
        
    }

    @FXML
    void A4_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void A5_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void A6_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void A7_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void A8_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void B1_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void B2_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void B3_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void B4_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void B5_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void B6_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void B7_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void B8_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void C1_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void C2_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void C3_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void C4_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void C5_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void C6_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void C7_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void D1_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void D2_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void D3_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void D4_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void D5_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void D6_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void D7_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void D8_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void E1_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void E2_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void E3_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void E4_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void E5_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void E6_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void E7_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void E8_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void F1_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void F2_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void F3_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void F4_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void F5_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void F6_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void F7_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void F8_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void G1_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void G2_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void G3_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void G4_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void G5_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void G6_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void G7_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void G8_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void H1_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void H2_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void H3_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void H4_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void H5_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void H6_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void H7_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void H8_ImageViewClicked(MouseEvent event) {

    }

    @FXML
    void NewGameMenuItemClicked(ActionEvent event) {
        System.out.println("Button pushed: New Game");
        System.out.println("Remove all imageViews from panes");
        for (Pane pane : paneList) {
            pane.getChildren().removeAll(iviews);
        }
        
        System.out.println("put the starting arrangement of imageviews in the panes");
        int i = 0;
        for (Pane pane : paneList) {
            pane.getChildren().add(iviews.get(i));
            i++;
        }
       // add Panes to the list of Panes
        paneList.clear();
        paneList.add(A8_Pane);paneList.add(B8_Pane);paneList.add(C8_Pane);paneList.add(D8_Pane);
        paneList.add(E8_Pane);paneList.add(F8_Pane);paneList.add(G8_Pane);paneList.add(H8_Pane);
        paneList.add(A7_Pane);paneList.add(B7_Pane);paneList.add(C7_Pane);paneList.add(D7_Pane);
        paneList.add(E7_Pane);paneList.add(F7_Pane);paneList.add(G7_Pane);paneList.add(H7_Pane); 
        paneList.add(A6_Pane);paneList.add(B6_Pane);paneList.add(C6_Pane);paneList.add(D6_Pane);
        paneList.add(E6_Pane);paneList.add(F6_Pane);paneList.add(G6_Pane);paneList.add(H6_Pane);  
        paneList.add(A5_Pane);paneList.add(B5_Pane);paneList.add(C5_Pane);paneList.add(D5_Pane);
        paneList.add(E5_Pane);paneList.add(F5_Pane);paneList.add(G5_Pane);paneList.add(H5_Pane);  
        paneList.add(A4_Pane);paneList.add(B4_Pane);paneList.add(C4_Pane);paneList.add(D4_Pane);
        paneList.add(E4_Pane);paneList.add(F4_Pane);paneList.add(G4_Pane);paneList.add(H4_Pane); 
        paneList.add(A3_Pane);paneList.add(B3_Pane);paneList.add(C3_Pane);paneList.add(D3_Pane);
        paneList.add(E3_Pane);paneList.add(F3_Pane);paneList.add(G3_Pane);paneList.add(H3_Pane);
        paneList.add(A2_Pane);paneList.add(B2_Pane);paneList.add(C2_Pane);paneList.add(D2_Pane);
        paneList.add(E2_Pane);paneList.add(F2_Pane);paneList.add(G2_Pane);paneList.add(H2_Pane); 
        paneList.add(A1_Pane);paneList.add(B1_Pane);paneList.add(C1_Pane);paneList.add(D1_Pane);
        paneList.add(E1_Pane);paneList.add(F1_Pane);paneList.add(G1_Pane);paneList.add(H1_Pane);
        
        System.out.println("Clear the list of ImageView");
        iviews.clear();
        iviews.add(A8_ImageView);iviews.add(B8_ImageView);iviews.add(C8_ImageView);iviews.add(D8_ImageView);
        iviews.add(E8_ImageView);iviews.add(F8_ImageView);iviews.add(G8_ImageView);iviews.add(H8_ImageView);
        iviews.add(A7_ImageView);iviews.add(B7_ImageView);iviews.add(C7_ImageView);iviews.add(D7_ImageView);
        iviews.add(E7_ImageView);iviews.add(F7_ImageView);iviews.add(G7_ImageView);iviews.add(H7_ImageView); 
        iviews.add(A6_ImageView);iviews.add(B6_ImageView);iviews.add(C6_ImageView);iviews.add(D6_ImageView);
        iviews.add(E6_ImageView);iviews.add(F6_ImageView);iviews.add(G6_ImageView);iviews.add(H6_ImageView);  
        iviews.add(A5_ImageView);iviews.add(B5_ImageView);iviews.add(C5_ImageView);iviews.add(D5_ImageView);
        iviews.add(E5_ImageView);iviews.add(F5_ImageView);iviews.add(G5_ImageView);iviews.add(H5_ImageView);  
        iviews.add(A4_ImageView);iviews.add(B4_ImageView);iviews.add(C4_ImageView);iviews.add(D4_ImageView);
        iviews.add(E4_ImageView);iviews.add(F4_ImageView);iviews.add(G4_ImageView);iviews.add(H4_ImageView); 
        iviews.add(A3_ImageView);iviews.add(B3_ImageView);iviews.add(C3_ImageView);iviews.add(D3_ImageView);
        iviews.add(E3_ImageView);iviews.add(F3_ImageView);iviews.add(G3_ImageView);iviews.add(H3_ImageView);
        iviews.add(A2_ImageView);iviews.add(B2_ImageView);iviews.add(C2_ImageView);iviews.add(D2_ImageView);
        iviews.add(E2_ImageView);iviews.add(F2_ImageView);iviews.add(G2_ImageView);iviews.add(H2_ImageView); 
        iviews.add(A1_ImageView);iviews.add(B1_ImageView);iviews.add(C1_ImageView);iviews.add(D1_ImageView);
        iviews.add(E1_ImageView);iviews.add(F1_ImageView);iviews.add(G1_ImageView);iviews.add(H1_ImageView);
        
       
//         for (Pane pane : paneList) {
//          pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent event) {
//                           mMove2 = (Pane) event.getSource();
//                           if(mMove2 != mMove1) {
//                               mMove2.setEffect(shadow);
//                               if(mMove1 != null) mMove1.setEffect(null);
//                               mMove1 = mMove2;
//                           }
//
//                    }
//                });
//       }
//        
        System.out.println("put the starting images in the starting imageviews");
        String imageName = new String();

        for (int row = 0; row < NUM_SQUARE_SIDE; row++) {
        
            for (int col = 0; col < NUM_SQUARE_SIDE; col ++) {
                try {
                    imageName = imageNames.get((row)*8+col);                    
                    Image img = new Image(imageName);

                    iviews.get((row)*8+col).setImage(null);
                    iviews.get((row)*8+col).setImage(img);
  
                } catch (RuntimeException ex)  {  //(IOException ex) {
                    System.out.println("Failed with exception: " + ex.getMessage() + " "  + imageName);
                }

            }
        }  
    }
    
    @FXML
    void CloseMenuItemClicked(ActionEvent event) {
        System.exit(0);
    }
    
    private void setImageNames() {
        System.out.println("size of imageNames entering setImageNames = " + imageNames.size());
        String pieceAbbrev = "";
        String colorAbbrev = "";
        String colorTop = "black";   // B
        String colorBottom = "white";   // W
        if (imageNames.size() < 64) {
            String imgPrefix = "teamlewischess/images/"; // resources/images/";teamlewischess/images/"
            String imageName;
            
            for (int row = 0; row < NUM_SQUARE_SIDE; row++) {
                if (row > 1 && row < NUM_SQUARE_SIDE-1) {
                    colorAbbrev = "E";
                }
                for (int col = 0; col < NUM_SQUARE_SIDE ; col++) {
                    //System.out.println("row = " + row + ", col = " + col);
                    if (row == 0 || row == 1) {
                        colorAbbrev = colorTop;
                    } else if ((row == 7) || (row == 6)) {
                        colorAbbrev = colorBottom;
                    } else {
                        colorAbbrev = "empty";
                    }
                    if ((row == 0) || (row == NUM_SQUARE_SIDE-1)) {
                        if (col == 0 || col == NUM_SQUARE_SIDE-1) {
                            pieceAbbrev = "rook";  // R
                        } else if (col == 1 || col == 6) {
                            pieceAbbrev = "knight";   //N
                        } else if (col == 2 || col == 5) {
                            pieceAbbrev = "bishop"; // B
                        } else if (col == 3) {
                            pieceAbbrev = "queen";  // Q
                        } else if (col == 4) {
                            pieceAbbrev = "king";   // K
                        }
                    }
                    if ((row == 1) || (row == 6)) {
                        pieceAbbrev = "pawn";   //pawn
                    }
                    if (colorAbbrev.contentEquals("empty")) {    // E
                        imageName = imgPrefix + "empty" + ".png";   // EE
                    } else {
                        imageName = imgPrefix + colorAbbrev + pieceAbbrev + ".png";
                    }

                    imageNames.add(imageName);
                    Image img = new Image(imageName);
                    imgList.add(img);
                }
            }// end load imageNmes
        } // end if 
//         System.out.println("Access List using Iterator");
//        Iterator iterator = imageNames.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        System.out.println();
//        System.out.println("Access List using Short form of for-loop");
//        for(String s: imageNames){
//            System.out.println(s);
//        }
       
    }

}
