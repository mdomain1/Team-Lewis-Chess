package teamlewischess;

/**
 * This should work for moving pieces and updating images. Just got to figure 
 * out how to implement it. 
 * https://docs.oracle.com/javase/8/javafx/events-tutorial/paper-doll.htm
 * 
 * private final Image previewImage;
    private final Image activeImage;
    private final Image equippedImage;
    
    private final ImageView currentImage;
    
    public void putOn() {
        currentImage.setImage(equippedImage);
    }
    
    public void takeOff() {
        currentImage.setImage(previewImage);
    }
    
    private void activate() {
        currentImage.setImage(activeImage);
    }
    
    public String getImageViewId() {
        return currentImage.getId();
    }
    
    public Node getNode() {
        return currentImage;
    }
    
    public Move(Image[] images) {
        this.previewImage = images[0];
        this.activeImage = images[1];
        this.equippedImage = images[2];
        
        currentImage = new ImageView();
        currentImage.setImage(previewImage);
        currentImage.setId(this.getClass().getSimpleName() + System.currentTimeMillis());
        
        currentImage.setOnDragDetected((MouseEvent event) -> {
            activate();
            Dragboard db = currentImage.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            // Store node ID in order to know what is dragged.
            content.putString(currentImage.getId());
            db.setContent(content);
            event.consume();
        });
    }
 */
public class Move {
    
}