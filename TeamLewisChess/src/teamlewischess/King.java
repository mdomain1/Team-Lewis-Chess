package teamlewischess;

/**
 * @see Piece
 */
public class King extends Piece {
    private boolean hasMoved;
    
    private boolean canCastle(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    public boolean isInCheck(int[][] fPieceTypeLocationsOnBoard)
    {
        return true;
    }
    
    static public boolean isValidMove(int[][] fPieceTypeLocationsOnBoard, Team fTeam)
    {
        //Just to satisfy program and to be updated with algorithm:
        return true;
    }
    
    static private boolean withinRangeOfPieceMobility(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    static private boolean noPieceBlocksPathToSquare(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    static private boolean moveDoesNotPlaceKingInCheck(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    public boolean hasMoved()
    {
        return hasMoved;
    }
    
    public void setHasMoved(boolean fHasMoved)
    {
        hasMoved = fHasMoved;
    }
    
    public King(int fLocation, int fTeam) {
        super(fLocation, fTeam);
        
        hasMoved = false;
    }
}
