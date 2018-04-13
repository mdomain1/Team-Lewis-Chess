package teamlewischess;

/**
 * Description pending...
 */
public class Team {
    public boolean pawnMovedTwoSpacesLastMove;
    public int squarePawnMovedTwoLastMovedTo;
    public int numOfMovesNoCaptureOrPawnMoves;
    public boolean kingHasMoved;
    public boolean R_1_hasMoved; //White/black rook that starts on square 56/0
    public boolean R_2_hasMoved; //White/black rook that starts on square 63/7
    
    /**
     * 
     */
    public Team() {
        pawnMovedTwoSpacesLastMove = false;
        squarePawnMovedTwoLastMovedTo = -1;
        numOfMovesNoCaptureOrPawnMoves = 0;
        
        kingHasMoved = false;
        R_1_hasMoved = false; //White/black rook that starts on square 56/0
        R_2_hasMoved = false; //White/black rook that starts on square 63/7
    }
}
