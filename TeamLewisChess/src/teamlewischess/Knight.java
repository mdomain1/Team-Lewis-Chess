package teamlewischess;

import java.util.ArrayList;
import java.util.List;

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
    static public boolean isValidMove(int[][] fPieceTypeLocationsOnBoard, Team fTeam) {
//         System.out.println("Knight withinRange of PieceMobility: " + 
//                 Knight.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard));
//         System.out.println("noPieceBlocksPathToSquare: " + 
//                 Knight.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard));
//         System.out.println("moveDoesNotPlaceKingInCheck:  " + 
//                 Knight.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard));
                 
        if(Knight.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard)){
            
            if(Knight.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard)){
            
                if(Knight.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard)){
                    
                    return true;
                }
            }
        }
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    /**
     * 
     * @param fPieceTypeLocationsOnBoard
     * @return 
     */
    static private boolean withinRangeOfPieceMobility(int[][] fPieceTypeLocationsOnBoard) {
        final int SIZE = 8;
        final int MAX_ROW = 7;
        final int MIN_ROW = 0;
        final int MAX_COL = 7;
        final int MIN_COL = 0;
        final List<String> legalMoves = new ArrayList<>();
        final List<Integer> legalSquares = new ArrayList<>();

        int squareTargeted = Game.getTargetedSquare();
        int squareClicked = TeamLewisChessController.getSquareClicked();
         //System.out.println("squareTargeted = " + squareTargeted);
         //System.out.println("squareClicked = " + squareClicked);
         int cindx = Board.getColumnFromLocation(squareTargeted);
         int rindx = Board.getRowFromLocation(squareTargeted);
         String moveString;
         int squareNum=-1;
         //Just to satisfy program and to be updated with algorithm:
        for ( int r = rindx - 2; r < rindx +3 ; r=r+4) {
           
            for (int c = cindx -1; c < cindx +2; c+=2) {
                //System.out.print("rindx, cindx = " + rindx + "," + cindx + ": =  " + r + ", " +c);
                if(r >=MIN_ROW && r <= MAX_ROW && c >= MIN_COL && c <= MAX_COL) {
                    //System.out.println("");
                    moveString = "r"+r+"c"+c;
                    legalMoves.add(moveString);
                    squareNum=c+(r*SIZE);
                   
                    
                    legalSquares.add(c+(r*SIZE));

                } else {
                    //System.out.println(" illegal move");
                
                }
            }
        }
        for ( int r = rindx -1; r< rindx +2; r+=2) {
            for (int c = cindx-2; c < cindx + 3; c+=4) {
                //System.out.print("rindx, cindx = " + rindx + "," + cindx + ": =  " + r + ", " +c);
                if(r >=MIN_ROW && r <= MAX_ROW && c >= MIN_COL && c <= MAX_COL) {
                    //System.out.println("");
                    moveString = "r"+r+"c"+c;
                    legalMoves.add(moveString);
                    legalSquares.add(c+(r*SIZE));
                    
                } else {
                    //System.out.println(" illegal move");
                
                }
            }
            
        }
        
        for (int lm : legalSquares) {
            //System.out.println("Legal Square = " + lm);
            if(squareClicked==lm) {
                //System.out.println("match found, can move if empty or opponent on square");
                return true;
            }
        }
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
        //return false;
        return true;
    }
    
    /**
     * 
     * @param fPieceTypeLocationsOnBoard
     * @return 
     */
    static private boolean moveDoesNotPlaceKingInCheck(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        //return false;
        return true;

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
