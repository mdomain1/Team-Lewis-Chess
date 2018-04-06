package teamlewischess;

/**
 * Description pending...
 */
public class Team {
    public boolean isCheckmated;
    public boolean pawnMovedTwoSpacesLastMove;
    public int squarePawnMovedTwoLastMovedTo;
    public int numOfMovesNoCaptureOrPawnMoves;
    
    /**
     * 
     */
    public Team() {
        isCheckmated = false;
        pawnMovedTwoSpacesLastMove = false;
        squarePawnMovedTwoLastMovedTo = -1;
        numOfMovesNoCaptureOrPawnMoves = 0;
    }
}
