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
        int row = getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int column = getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        if (Game.getCurrentTeamsTurn() == 0)
        {
            switch (pieceTypeLocationsOnBoard[row][column]) {
                case 1:
                    return true;
                case 2:
                    return true;
                case 3:
                    return true;
                case 4:
                    return true;
                case 5:
                    return true;
                case 6:
                    return true;
                default:
                    return false;
            }
        }
        else if (Game.getCurrentTeamsTurn() == 1)
        {
            switch (pieceTypeLocationsOnBoard[row][column]) {
                case 7:
                    return true;
                case 8:
                    return true;
                case 9:
                    return true;
                case 10:
                    return true;
                case 11:
                    return true;
                case 12:
                    return true;
                default:
                    return false;
            }
        }
        
        //Won't ever execute, but IDE doesn't know that a switch block will be entered:
        return false;
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
        return (fLocation / 8);
    }
    
    static public int getColumnFromLocation(int fLocation)
    {
        //Just to satisfy program and to be updated with algorithm:
        return (fLocation % 8);
    }
    
    static public int getLocationFromRowAndColumn(int fRow, int fColumn)
    {        
        return ((fRow * 8) + fColumn);
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
        //All squares with no pieces on them (rows 2-5) are initialized to 0,
        //no piece is on these squares.
        for (int i = 2; i <= 5; i++)
        {
            for (int j = 0; j <=7; j++)
            {
                pieceTypeLocationsOnBoard[i][j] = 0;
            }
        }
        
        pieceTypeLocationsOnBoard[0][0] = 8;  //black rook
        pieceTypeLocationsOnBoard[0][1] = 9;  //black knight
        pieceTypeLocationsOnBoard[0][2] = 10; //black bishop
        pieceTypeLocationsOnBoard[0][3] = 11; //black queen
        pieceTypeLocationsOnBoard[0][4] = 12; //black king
        pieceTypeLocationsOnBoard[0][5] = 10; //black bishop
        pieceTypeLocationsOnBoard[0][6] = 9;  //black knight
        pieceTypeLocationsOnBoard[0][7] = 8;  //black rook
        pieceTypeLocationsOnBoard[1][0] = 7;  //black pawn
        pieceTypeLocationsOnBoard[1][1] = 7;  //black pawn
        pieceTypeLocationsOnBoard[1][2] = 7;  //black pawn
        pieceTypeLocationsOnBoard[1][3] = 7;  //black pawn
        pieceTypeLocationsOnBoard[1][4] = 7;  //black pawn
        pieceTypeLocationsOnBoard[1][5] = 7;  //black pawn
        pieceTypeLocationsOnBoard[1][6] = 7;  //black pawn
        pieceTypeLocationsOnBoard[1][7] = 7;  //black pawn
        pieceTypeLocationsOnBoard[6][0] = 1;  //white pawn
        pieceTypeLocationsOnBoard[6][1] = 1;  //white pawn
        pieceTypeLocationsOnBoard[6][2] = 1;  //white pawn
        pieceTypeLocationsOnBoard[6][3] = 1;  //white pawn
        pieceTypeLocationsOnBoard[6][4] = 1;  //white pawn
        pieceTypeLocationsOnBoard[6][5] = 1;  //white pawn
        pieceTypeLocationsOnBoard[6][6] = 1;  //white pawn
        pieceTypeLocationsOnBoard[6][7] = 1;  //white pawn
        pieceTypeLocationsOnBoard[7][0] = 2;  //white rook
        pieceTypeLocationsOnBoard[7][1] = 3;  //white knight
        pieceTypeLocationsOnBoard[7][2] = 4;  //white bishop
        pieceTypeLocationsOnBoard[7][3] = 5;  //white queen
        pieceTypeLocationsOnBoard[7][4] = 6;  //white king
        pieceTypeLocationsOnBoard[7][5] = 4;  //white bishop
        pieceTypeLocationsOnBoard[7][6] = 3;  //white knight
        pieceTypeLocationsOnBoard[7][7] = 2;  //white rook
    }
}
