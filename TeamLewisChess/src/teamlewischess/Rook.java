package teamlewischess;

import java.util.ArrayList;
import java.util.List;

/**
 * @see Piece
 */
public class Rook extends Piece {
    private boolean hasMoved;

    static public boolean isValidMove(int[][] fPieceTypeLocationsOnBoard, Team fTeam) {
               
        if(Rook.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard)){
            
            if(Rook.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard)){
            
                if(Rook.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard)){
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    static private boolean withinRangeOfPieceMobility(int[][] fPieceTypeLocationsOnBoard) {
    
        final int MAX_ROW = 7;
        final int MIN_ROW = 0;
        final int MAX_COL = 7;
        final int MIN_COL = 0;
        final int SIZE = 8;
        final List<Integer> possibleMoves = new ArrayList<>();
        final List<Integer> legalMoves = new ArrayList<>();

        int squareTargeted = Game.getTargetedSquare();
        int squareClicked = TeamLewisChessController.getSquareClicked();
        int cindx = Board.getColumnFromLocation(squareTargeted);
        int rindx = Board.getRowFromLocation(squareTargeted);
        int square = -1;
        for (int c = cindx - 1; c >= MIN_COL; c--) {
            square = c + (rindx) * SIZE;
            possibleMoves.add(square);

        }
        for (int c = cindx + 1; c <= MAX_COL; c++) {
            square = c + rindx * SIZE;
            possibleMoves.add(square);
        }

        for (int r = rindx - 1; r >= MIN_ROW; r--) {
            square = cindx + r * SIZE;
            possibleMoves.add(square);

        }
        for (int r = rindx + 1; r <= MAX_ROW; r++) {
            square = cindx + r * SIZE;
            possibleMoves.add(square);
        }

        
        for (int lm : possibleMoves) {
           
            if (squareClicked == lm) {
                //System.out.println("Match lm = " + lm );
                return true;
            }
        }

        return false;
    }
    
    static private boolean noPieceBlocksPathToSquare(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        //return false;
        return true;
    }
    
    static private boolean moveDoesNotPlaceKingInCheck(int[][] fPieceTypeLocationsOnBoard)
    {
        //Just to satisfy program and to be updated with algorithm:
        //return false;
        return true;
    }
    
    public boolean hasMoved()
    {
        return hasMoved;
    }
    
    public void setHasMoved(boolean fHasMoved)
    {
        hasMoved = fHasMoved;
    }
    
    public Rook(int fLocation, int fTeam) {
        super(fLocation, fTeam);
    }
}
