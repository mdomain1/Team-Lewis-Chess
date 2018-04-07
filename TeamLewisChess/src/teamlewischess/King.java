package teamlewischess;

/**
 * Description pending...
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
        return true;
    }
    
    static public boolean isValidMove(int[][] fPieceTypeLocationsOnBoard, Team fTeam)
    {
        System.out.println("King withinRange of PieceMobility: " + 
                 King.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard));
         //System.out.println("noPieceBlocksPathToSquare: " + 
           //      King.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard));
         //System.out.println("moveDoesNotPlaceKingInCheck:  " + 
           //      King.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard));
         
        //if(King.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard)){
          //  if(King.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard)){
            //    if(King.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard)){
                    return true;
            //    }
          //  }
        //}
       // return false;
    }
    
    static private boolean withinRangeOfPieceMobility(int[][] fPieceTypeLocationsOnBoard)
    {
        int[] rowKingMove = new int[8];
        int[] columnKingMove = new int[8];
        
        rowKingMove[0] = 1; columnKingMove[0] = 0;
        rowKingMove[1] = 1; columnKingMove[1] = 1;
        rowKingMove[2] = 1; columnKingMove[2] = -1;
        rowKingMove[3] = -1; columnKingMove[3] = 0;
        rowKingMove[4] = -1; columnKingMove[4] = 1;
        rowKingMove[5] = -1; columnKingMove[5] = -1;
        rowKingMove[6] = 0; columnKingMove[6] = 1;
        rowKingMove[7] = 0; columnKingMove[7] = -1;
        
        int rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        int columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        for(int i = 0; i < 8; i++){
            
            int nextRow = rowTargeted + rowKingMove[i];
            int nextColumn = columnTargeted + columnKingMove[i];
            
                if(nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7)
                    if(nextRow == rowClicked && nextColumn == columnClicked)
                        return true;
              }        
        // withinRangeOfPieceMobility
        return false;
    }
    
    static private boolean noPieceBlocksPathToSquare(int[][] fPieceTypeLocationsOnBoard)
    {
        // Unaccounted: castling (need to check if paths are clear on long and short sides of king)
        // algorithm in the works:
        //      decide which king wants to perform castling
        
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
