package teamlewischess;

/**
 * @see Piece
 */
public class King extends Piece {
    private boolean hasMoved;
    
    private boolean canCastle(int[][] fPieceTypeLocationsOnBoard)
    {
        //Note: Have to make sure that the rook that the king is castling with is an original rook
        //and not a pawn promoted to a rook.
        
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    public boolean isInCheck(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
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
        // Unaccounted: castling
        int rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        int columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        if(fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] >= 1 && fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] <= 6){
            if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 1 && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 6)
                return false;
        }
        else if(fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] >= 7 && fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] <= 12){
            if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 7 && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 12)
                return false;
        }
        
        // noPieceBlocksPathToSquare
        return true;
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
