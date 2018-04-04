package teamlewischess;

/**
 * Description pending...
 */
public class Bishop extends Piece {
    static public boolean isValidMove(int[][] fPieceTypeLocationsOnBoard, Team fTeam)
    {
        if(Bishop.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard)){
            
            if(Bishop.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard)){
            
                if(Bishop.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard)){
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    static private boolean withinRangeOfPieceMobility(int[][] fPieceTypeLocationsOnBoard)
    {        
     	int displacement = Game.getTargetedSquare() - TeamLewisChessController.getSquareClicked();
        
        // does the landingPos lie on the same diagonal line as the bishop?
        if (displacement % 7 == 0 || displacement % 9 == 0)
            return true;

        else
            return false;
    }
    
    static private boolean noPieceBlocksPathToSquare(int[][] fPieceTypeLocationsOnBoard)
    {	
        int rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        int columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());

        // compare piece colors of piece on TargetedSquare and piece on SquareClicked
        // if they're the same colors, we are blocked
        if(fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] >= 1 && fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] <= 6){
            if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 1 && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 6)
                return false;
        }
        else if(fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] >= 7 && fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] <= 12){
            if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 7 && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 12)
                return false;
        }
        
        // variables used for checking if path is blocked
        int displacement = Game.getTargetedSquare() - TeamLewisChessController.getSquareClicked();
        int numSquaresInBetweenBishopAndLandingPos = 0;
        
        int i = 0;
        int row = rowTargeted;
        int col = columnTargeted;
        
        // check if path is blocked
        if( displacement % 7 == 0 ){ //is the bishop moving along a positive slope?

            //  then bishop moving to Quad I?
            if ( displacement > 0){

                numSquaresInBetweenBishopAndLandingPos = displacement / 7 - 1;

                // then examine the squares in the direction of the upper-right corner of the board
                while( i < numSquaresInBetweenBishopAndLandingPos ){

                    // get coordinates of next location
                    row = row - 1;
                    col = col + 1;

                    // is this location NOT empty?
                    if(fPieceTypeLocationsOnBoard[row][col] != 0)
                        return false;

                    i++;
                }
            }
            else{ //( bishop is moving to Quad III )

                numSquaresInBetweenBishopAndLandingPos = Math.abs(displacement / 7) - 1;

                // line of examination is in the direction of bottom-left corner of the board
                while( i < numSquaresInBetweenBishopAndLandingPos ){

                    row = row + 1;
                    col = col - 1;

                    // is this location NOT empty?
                    if(fPieceTypeLocationsOnBoard[row][col] != 0)
                        return false;

                    i++;
                }
            }
        }     
        else { // the bishop is moving along a negative slope

            if ( displacement > 0){ //is bishop moving to Quad II?

                numSquaresInBetweenBishopAndLandingPos = displacement / 9 - 1;

                // yes? then examine squares in the direction towards upper-left corner of board
                while( i < numSquaresInBetweenBishopAndLandingPos ){

                    row = row - 1;
                    col = col - 1;

                    // is this location NOT empty?
                    if(fPieceTypeLocationsOnBoard[row][col] != 0)
                        return false;

                    i++;
                }
            }
            else{ //( bishop is moving to Quad IV )

                numSquaresInBetweenBishopAndLandingPos = Math.abs(displacement / 9) - 1;

                // line of examination is in the direction of bottom-right corner of the board
                while( i < numSquaresInBetweenBishopAndLandingPos ){

                    row = row + 1;
                    col = col + 1;

                    // is this location NOT empty?
                    if(fPieceTypeLocationsOnBoard[row][col] != 0)
                        return false;

                    i++;
                }
            }
        }
        // no piece blocks bishop path to squareClicked!
        return true;
    }
    
    static private boolean moveDoesNotPlaceKingInCheck(int[][] fPieceTypeLocationsOnBoard)
    { 
        //Just to satisfy program and to be update with algorithm:
        return false;
    }
    
    public Bishop(int fLocation, int fTeam) {
        super(fLocation, fTeam);
    }
}
