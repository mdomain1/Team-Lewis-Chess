package teamlewischess;

/**
 * @see Piece
 */
public class Knight extends Piece {
    /**
     * 
     * @param fPieceTypeLocationsOnBoard
     * @param fTeam
     * @return 
     */
    static public boolean isValidMove(int[][] fPieceTypeLocationsOnBoard, Team fTeam)
    {
        //Just to satisfy program and to be updated with algorithm:
        return true;
    }
    
    /**
     * 
     * @param fPieceTypeLocationsOnBoard
     * @return 
     */
    static private boolean withinRangeOfPieceMobility(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    /**
     * 
     * @param fPieceTypeLocationsOnBoard
     * @return 
     */
    static private boolean noPieceBlocksPathToSquare(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    /**
     * 
     * @param fPieceTypeLocationsOnBoard
     * @return 
     */
    static private boolean moveDoesNotPlaceKingInCheck(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    /**
     * 
     * @param fLocation
     * @param fTeam 
     */
    public Knight(int fLocation, int fTeam) {
        super(fLocation, fTeam);
    }
}
