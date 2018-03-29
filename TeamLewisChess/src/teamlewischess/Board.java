package teamlewischess;

/**
 * Description pending...
 */
public class Board {
    int[][] pieceTypeLocationsOnBoard = new int[8][8];
    Team white = new Team();
    Team black = new Team();
    
    //White pieces:
    King wK = new King(60, 0);
    Queen wQ = new Queen(59, 0);
    Rook wR_1 = new Rook(56, 0);
    Rook wR_2 = new Rook(63, 0);
    Bishop wB_1 = new Bishop(58, 0);
    Bishop wB_2 = new Bishop(61, 0);
    Knight wN_1 = new Knight(57, 0);
    Knight wN_2 = new Knight(62, 0);
    Pawn wP_1 = new Pawn(48, 0);
    Pawn wP_2 = new Pawn(49, 0);
    Pawn wP_3 = new Pawn(50, 0);
    Pawn wP_4 = new Pawn(51, 0);
    Pawn wP_5 = new Pawn(52, 0);
    Pawn wP_6 = new Pawn(53, 0);
    Pawn wP_7 = new Pawn(54, 0);
    Pawn wP_8 = new Pawn(55, 0);
    
    //Black pieces:
    King bK = new King(4, 1);
    Queen bQ = new Queen(3, 1);
    Rook bR_1 = new Rook(0, 1);
    Rook bR_2 = new Rook(7, 1);
    Bishop bB_1 = new Bishop(2, 1);
    Bishop bB_2 = new Bishop(5, 1);
    Knight bN_1 = new Knight(1, 1);
    Knight bN_2 = new Knight(6, 1);
    Pawn bP_1 = new Pawn(8, 1);
    Pawn bP_2 = new Pawn(9, 1);
    Pawn bP_3 = new Pawn(10, 1);
    Pawn bP_4 = new Pawn(11, 1);
    Pawn bP_5 = new Pawn(12, 1);
    Pawn bP_6 = new Pawn(13, 1);
    Pawn bP_7 = new Pawn(14, 1);
    Pawn bP_8 = new Pawn(15, 1);
    
    public void resetBoardForNewGame()
    {
        
    }
    
    public boolean containsSelectablePiece()
    {
        //Just to satisfy program and to be updated with algorithm:
        return true;
    }
    
    public boolean pieceOnTargetedSquareCanMoveToSquareClicked()
    {
        //Just to satisfy program and to be updated with algorithm:
        return true;
    }
    
    public void updateBoard()
    {
        
    }
    
    static public int getRowFromLocation(int fLocation)
    {
        //Just to satisfy program and to be updated with algorithm:
        return 1;
    }
    
    static public int getColumnFromLocation(int fLocation)
    {
        //Just to satisfy program and to be updated with algorithm:
        return 1;
    }
    
    static public int getLocationFromRowAndColumn(int fRow, int fColumn)
    {
        //Just to satisfy program and to be updated with algorithm:
        return 1;
    }
    
    private boolean isACastlingMove()
    {
        //Just to satisfy program and to be updated with algorithm:
        return true;
    }
    
    private boolean isAnEnPassantMove()
    {
        //Just to satisfy program and to be updated with algorithm:
        return true;
    }
    
    private boolean isBeingPromoted()
    {
        //Just to satisfy program and to be updated with algorithm:
        return true;
    }
    
    private void updateGameStatus()
    {
        
    }
    
    public Board()
    {
        
    }
}
