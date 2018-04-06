package teamlewischess;

import java.io.IOException;

/**
 * 
 * Board class.
 */
public class Board {
    PromotionWindow onePromotionWindow; //For promoting pawns
    //These booleans are used in Step 3 of the updateBoard method to promote the pawns to
    //what the user selects. These variables are static so that they can be updated
    //in the PromotionWindowController class. This is the only location they are updated;
    //They are not retrieved or updated from anywhere else. They are reset back to false
    //at the beginning of Step 3 of updateBoard.
    static public boolean isBeingPromoted;
    static public boolean isBeingPromotedToKnight;
    static public boolean isBeingPromotedToBishop;
    static public boolean isBeingPromotedToRook;
    static public boolean isBeingPromotedToQueen;
    
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
    
    /**
     * Resets board
     * @see TeamLewisChessController
     */
    public void resetBoardForNewGame()
    {
        //White pieces' starting positions:
        wK.setLocation(60);
        wQ.setLocation(59);
        wR_1.setLocation(56);
        wR_2.setLocation(63);
        wB_1.setLocation(58);
        wB_2.setLocation(61);
        wN_1.setLocation(57);
        wN_2.setLocation(62);
        wP_1.setLocation(48);
        wP_2.setLocation(49);
        wP_3.setLocation(50);
        wP_4.setLocation(51);
        wP_5.setLocation(52);
        wP_6.setLocation(53);
        wP_7.setLocation(54);
        wP_8.setLocation(55);

        //Black pieces' starting positions:
        bK.setLocation(4);
        bQ.setLocation(3);
        bR_1.setLocation(0);
        bR_2.setLocation(7);
        bB_1.setLocation(2);
        bB_2.setLocation(5);
        bN_1.setLocation(1);
        bN_2.setLocation(6);
        bP_1.setLocation(8);
        bP_2.setLocation(9);
        bP_3.setLocation(10);
        bP_4.setLocation(11);
        bP_5.setLocation(12);
        bP_6.setLocation(13);
        bP_7.setLocation(14);
        bP_8.setLocation(15);
        
        //White pieces' captured boolean variables:
        wK.setCaptured(false);
        wQ.setCaptured(false);
        wR_1.setCaptured(false);
        wR_2.setCaptured(false);
        wB_1.setCaptured(false);
        wB_2.setCaptured(false);
        wN_1.setCaptured(false);
        wN_2.setCaptured(false);
        wP_1.setCaptured(false);
        wP_2.setCaptured(false);
        wP_3.setCaptured(false);
        wP_4.setCaptured(false);
        wP_5.setCaptured(false);
        wP_6.setCaptured(false);
        wP_7.setCaptured(false);
        wP_8.setCaptured(false);

        //Black pieces' captured boolean variables:
        bK.setCaptured(false);
        bQ.setCaptured(false);
        bR_1.setCaptured(false);
        bR_2.setCaptured(false);
        bB_1.setCaptured(false);
        bB_2.setCaptured(false);
        bN_1.setCaptured(false);
        bN_2.setCaptured(false);
        bP_1.setCaptured(false);
        bP_2.setCaptured(false);
        bP_3.setCaptured(false);
        bP_4.setCaptured(false);
        bP_5.setCaptured(false);
        bP_6.setCaptured(false);
        bP_7.setCaptured(false);
        bP_8.setCaptured(false);
        
        white.isCheckmated = false;
        white.numOfMovesNoCaptureOrPawnMoves = 0;
        white.pawnMovedTwoSpacesLastMove = false;
        white.squarePawnMovedTwoLastMovedTo = -1;
        
        black.isCheckmated = false;
        black.numOfMovesNoCaptureOrPawnMoves = 0;
        black.pawnMovedTwoSpacesLastMove = false;
        black.squarePawnMovedTwoLastMovedTo = -1;
        
        wK.setHasMoved(false);
        wR_1.setHasMoved(false);
        wR_2.setHasMoved(false);
        bK.setHasMoved(false);
        bR_1.setHasMoved(false);
        bR_2.setHasMoved(false);
        
        wP_1.setPromoted(false);
        wP_1.setPromotedToKnight(false);
        wP_1.setPromotedToBishop(false);
        wP_1.setPromotedToRook(false);
        wP_1.setPromotedToQueen(false);
        
        wP_2.setPromoted(false);
        wP_2.setPromotedToKnight(false);
        wP_2.setPromotedToBishop(false);
        wP_2.setPromotedToRook(false);
        wP_2.setPromotedToQueen(false);
        
        wP_3.setPromoted(false);
        wP_3.setPromotedToKnight(false);
        wP_3.setPromotedToBishop(false);
        wP_3.setPromotedToRook(false);
        wP_3.setPromotedToQueen(false);
        
        wP_4.setPromoted(false);
        wP_4.setPromotedToKnight(false);
        wP_4.setPromotedToBishop(false);
        wP_4.setPromotedToRook(false);
        wP_4.setPromotedToQueen(false);
        
        wP_5.setPromoted(false);
        wP_5.setPromotedToKnight(false);
        wP_5.setPromotedToBishop(false);
        wP_5.setPromotedToRook(false);
        wP_5.setPromotedToQueen(false);
        
        wP_6.setPromoted(false);
        wP_6.setPromotedToKnight(false);
        wP_6.setPromotedToBishop(false);
        wP_6.setPromotedToRook(false);
        wP_6.setPromotedToQueen(false);
        
        wP_7.setPromoted(false);
        wP_7.setPromotedToKnight(false);
        wP_7.setPromotedToBishop(false);
        wP_7.setPromotedToRook(false);
        wP_7.setPromotedToQueen(false);
        
        wP_8.setPromoted(false);
        wP_8.setPromotedToKnight(false);
        wP_8.setPromotedToBishop(false);
        wP_8.setPromotedToRook(false);
        wP_8.setPromotedToQueen(false);
        
        bP_1.setPromoted(false);
        bP_1.setPromotedToKnight(false);
        bP_1.setPromotedToBishop(false);
        bP_1.setPromotedToRook(false);
        bP_1.setPromotedToQueen(false);
        
        bP_2.setPromoted(false);
        bP_2.setPromotedToKnight(false);
        bP_2.setPromotedToBishop(false);
        bP_2.setPromotedToRook(false);
        bP_2.setPromotedToQueen(false);
        
        bP_3.setPromoted(false);
        bP_3.setPromotedToKnight(false);
        bP_3.setPromotedToBishop(false);
        bP_3.setPromotedToRook(false);
        bP_3.setPromotedToQueen(false);
        
        bP_4.setPromoted(false);
        bP_4.setPromotedToKnight(false);
        bP_4.setPromotedToBishop(false);
        bP_4.setPromotedToRook(false);
        bP_4.setPromotedToQueen(false);
        
        bP_5.setPromoted(false);
        bP_5.setPromotedToKnight(false);
        bP_5.setPromotedToBishop(false);
        bP_5.setPromotedToRook(false);
        bP_5.setPromotedToQueen(false);
        
        bP_6.setPromoted(false);
        bP_6.setPromotedToKnight(false);
        bP_6.setPromotedToBishop(false);
        bP_6.setPromotedToRook(false);
        bP_6.setPromotedToQueen(false);
        
        bP_7.setPromoted(false);
        bP_7.setPromotedToKnight(false);
        bP_7.setPromotedToBishop(false);
        bP_7.setPromotedToRook(false);
        bP_7.setPromotedToQueen(false);
        
        bP_8.setPromoted(false);
        bP_8.setPromotedToKnight(false);
        bP_8.setPromotedToBishop(false);
        bP_8.setPromotedToRook(false);
        bP_8.setPromotedToQueen(false);
        
        //All squares with no pieces on them (rows 2-5) are reset to 0.
        //No piece is on these squares.
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
    
    /**
     * 
     * @return boolean if square contains a selectable piece
     */
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
    /**
     * 
     * @return boolean if piece on targeted square can move to square clicked
     */
    public boolean pieceOnTargetedSquareCanMoveToSquareClicked()
    {
        if (wK.getLocation() == Game.getTargetedSquare()) {
            return King.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wQ.getLocation() == Game.getTargetedSquare()) {
            return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wR_1.getLocation() == Game.getTargetedSquare()) {
            return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wR_2.getLocation() == Game.getTargetedSquare()) {
            return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wB_1.getLocation() == Game.getTargetedSquare()) {
            return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wB_2.getLocation() == Game.getTargetedSquare()) {
            return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wN_1.getLocation() == Game.getTargetedSquare()) {
            return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wN_2.getLocation() == Game.getTargetedSquare()) {
            return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wP_1.getLocation() == Game.getTargetedSquare()) {
            if (wP_1.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_1.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_1.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_1.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_1.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
            }
        } else if (wP_2.getLocation() == Game.getTargetedSquare()) {
            if (wP_2.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_2.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_2.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_2.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_2.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
            }
        } else if (wP_3.getLocation() == Game.getTargetedSquare()) {
            if (wP_3.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_3.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_3.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_3.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_3.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
            }
        } else if (wP_4.getLocation() == Game.getTargetedSquare()) {
            if (wP_4.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_4.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_4.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_4.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_4.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
            }
        } else if (wP_5.getLocation() == Game.getTargetedSquare()) {
            if (wP_5.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_5.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_5.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_5.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_5.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
            }
        } else if (wP_6.getLocation() == Game.getTargetedSquare()) {
            if (wP_6.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_6.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_6.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_6.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_6.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
            }
        } else if (wP_7.getLocation() == Game.getTargetedSquare()) {
            if (wP_7.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_7.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_7.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_7.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_7.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
            }
        } else if (wP_8.getLocation() == Game.getTargetedSquare()) {
            if (wP_8.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_8.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_8.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_8.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
            } else if (wP_8.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
            }
        } else if (bK.getLocation() == Game.getTargetedSquare()) {
            return King.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bQ.getLocation() == Game.getTargetedSquare()) {
            return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bR_1.getLocation() == Game.getTargetedSquare()) {
            return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bR_2.getLocation() == Game.getTargetedSquare()) {
            return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bB_1.getLocation() == Game.getTargetedSquare()) {
            return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bB_2.getLocation() == Game.getTargetedSquare()) {
            return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bN_1.getLocation() == Game.getTargetedSquare()) {
            return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bN_2.getLocation() == Game.getTargetedSquare()) {
            return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bP_1.getLocation() == Game.getTargetedSquare()) {
            if (bP_1.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_1.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_1.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_1.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_1.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
            }
        } else if (bP_2.getLocation() == Game.getTargetedSquare()) {
            if (bP_2.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_2.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_2.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_2.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_2.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
            }
        } else if (bP_3.getLocation() == Game.getTargetedSquare()) {
            if (bP_3.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_3.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_3.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_3.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_3.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
            }
        } else if (bP_4.getLocation() == Game.getTargetedSquare()) {
            if (bP_4.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_4.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_4.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_4.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_4.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
            }
        } else if (bP_5.getLocation() == Game.getTargetedSquare()) {
            if (bP_5.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_5.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_5.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_5.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_5.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
            }
        } else if (bP_6.getLocation() == Game.getTargetedSquare()) {
            if (bP_6.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_6.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_6.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_6.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_6.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
            }
        } else if (bP_7.getLocation() == Game.getTargetedSquare()) {
            if (bP_7.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_7.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_7.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_7.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_7.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
            }
        } else if (bP_8.getLocation() == Game.getTargetedSquare()) {
            if (bP_8.promoted() == false) {
                return Pawn.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_8.promotedToQueen() == true) {
                return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_8.promotedToRook() == true) {
                return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_8.promotedToBishop() == true) {
                return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
            } else if (bP_8.promotedToKnight() == true) {
                return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
            }
        }
        
        //Because the IDE doesn't know that at least one of these if blocks will be entered:
        return false;
    }
    
    /**
     * updateBoard
     * @throws IOException if can't find sound i think, if put in resource file maybe can incorporate it in executable
     * @see TeamLewisChessController
     */
    public void updateBoard() throws IOException
    {
        //When audio files play will be updated after this method is complete.
        TeamLewisChess.playSoundMove();
        
        int targetedSquareRow = getRowFromLocation(Game.getTargetedSquare());
        int targetedSquareColumn = getColumnFromLocation(Game.getTargetedSquare());
        
        int squareClickedRow = getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int squareClickedColumn = getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        isBeingPromoted = false;
        isBeingPromotedToKnight = false;
        isBeingPromotedToBishop = false;
        isBeingPromotedToRook = false;
        isBeingPromotedToQueen = false;
        
        //Step 1
        if (isACastlingMove())
        {
            
        }
        //Step 2
        else if (isAnEnPassantMove())
        {
            
        }
        //Step 3
        else //is a normal move where, if a piece is being captured, that piece is always
             //one the squareClicked.
        {
            //Step 3-A. Update current Team's numOfMovesNoCaptureOrPawnMoves
            if (wP_1.getLocation() == Game.getTargetedSquare()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_2.getLocation() == Game.getTargetedSquare()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_3.getLocation() == Game.getTargetedSquare()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_4.getLocation() == Game.getTargetedSquare()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_5.getLocation() == Game.getTargetedSquare()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_6.getLocation() == Game.getTargetedSquare()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_7.getLocation() == Game.getTargetedSquare()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_8.getLocation() == Game.getTargetedSquare()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_1.getLocation() == Game.getTargetedSquare()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_2.getLocation() == Game.getTargetedSquare()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_3.getLocation() == Game.getTargetedSquare()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_4.getLocation() == Game.getTargetedSquare()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_5.getLocation() == Game.getTargetedSquare()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_6.getLocation() == Game.getTargetedSquare()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_7.getLocation() == Game.getTargetedSquare()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_8.getLocation() == Game.getTargetedSquare()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            //} else if (wK.getLocation() == pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn]) {
            //    black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wQ.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wR_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wR_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wB_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wB_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wN_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wN_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_3.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_4.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_5.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_6.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_7.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (wP_8.getLocation() == TeamLewisChessController.getSquareClicked()) {
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            //} else if (bK.getLocation() == TeamLewisChessController.getSquareClicked()) {
            //    white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bQ.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bR_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bR_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bB_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bB_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bN_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bN_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_3.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_4.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_5.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_6.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_7.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (bP_8.getLocation() == TeamLewisChessController.getSquareClicked()) {
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else if (Game.getCurrentTeamsTurn() == 0 ) {
                white.numOfMovesNoCaptureOrPawnMoves += 1;
            } else {
                black.numOfMovesNoCaptureOrPawnMoves += 1;
            }
            
            //Step 3-B. If the piece moved was a pawn moving two spaces forward, update
            //the current team's pawnMovedTwoSpacesLastMove variabe to true and set the
            //squarePawnMovedTwoLastMovedTo to the squareClicked.
            if (wP_1.getLocation() == Game.getTargetedSquare()) {
                if (wP_1.promoted() == false && targetedSquareRow == squareClickedRow + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                } 
            } else if (wP_2.getLocation() == Game.getTargetedSquare()) {
                if (wP_2.promoted() == false && targetedSquareRow == squareClickedRow + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_3.getLocation() == Game.getTargetedSquare()) {
                if (wP_3.promoted() == false && targetedSquareRow == squareClickedRow + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_4.getLocation() == Game.getTargetedSquare()) {
                if (wP_4.promoted() == false && targetedSquareRow == squareClickedRow + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_5.getLocation() == Game.getTargetedSquare()) {
                if (wP_5.promoted() == false && targetedSquareRow == squareClickedRow + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_6.getLocation() == Game.getTargetedSquare()) {
                if (wP_6.promoted() == false && targetedSquareRow == squareClickedRow + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_7.getLocation() == Game.getTargetedSquare()) {
                if (wP_7.promoted() == false && targetedSquareRow == squareClickedRow + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_8.getLocation() == Game.getTargetedSquare()) {
                if (wP_8.promoted() == false && targetedSquareRow == squareClickedRow + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_1.getLocation() == Game.getTargetedSquare()) {
                if (bP_1.promoted() == false && targetedSquareRow == squareClickedRow - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_2.getLocation() == Game.getTargetedSquare()) {
                if (bP_2.promoted() == false && targetedSquareRow == squareClickedRow - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_3.getLocation() == Game.getTargetedSquare()) {
                if (bP_3.promoted() == false && targetedSquareRow == squareClickedRow - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_4.getLocation() == Game.getTargetedSquare()) {
                if (bP_4.promoted() == false && targetedSquareRow == squareClickedRow - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_5.getLocation() == Game.getTargetedSquare()) {
                if (bP_5.promoted() == false && targetedSquareRow == squareClickedRow - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_6.getLocation() == Game.getTargetedSquare()) {
                if (bP_6.promoted() == false && targetedSquareRow == squareClickedRow - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_7.getLocation() == Game.getTargetedSquare()) {
                if (bP_7.promoted() == false && targetedSquareRow == squareClickedRow - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_8.getLocation() == Game.getTargetedSquare()) {
                if (bP_8.promoted() == false && targetedSquareRow == squareClickedRow - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (Game.getCurrentTeamsTurn() == 0) {
                white.pawnMovedTwoSpacesLastMove = false;
                white.squarePawnMovedTwoLastMovedTo = -1;
            } else {
                black.pawnMovedTwoSpacesLastMove = false;
                black.squarePawnMovedTwoLastMovedTo = -1;
            }
            
            //Step 3-C. If a piece was captured, find the piece that is located on squareClicked.
            //Set that Piece's location variable to -1 and captured boolean variable to true.
            if (pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] != 0)
            {
                if (wK.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wK.setLocation(-1);
                    wK.setCaptured(true);
                } else if (wQ.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wQ.setLocation(-1);
                    wQ.setCaptured(true);
                } else if (wR_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wR_1.setLocation(-1);
                    wR_1.setCaptured(true);
                } else if (wR_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wR_2.setLocation(-1);
                    wR_2.setCaptured(true);
                } else if (wB_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wB_1.setLocation(-1);
                    wB_1.setCaptured(true);
                } else if (wB_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wB_2.setLocation(-1);
                    wB_2.setCaptured(true);
                } else if (wN_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wN_1.setLocation(-1);
                    wN_1.setCaptured(true);
                } else if (wN_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wN_2.setLocation(-1);
                    wN_2.setCaptured(true);
                } else if (wP_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wP_1.setLocation(-1);
                    wP_1.setCaptured(true);
                } else if (wP_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wP_2.setLocation(-1);
                    wP_2.setCaptured(true);
                } else if (wP_3.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wP_3.setLocation(-1);
                    wP_3.setCaptured(true);
                } else if (wP_4.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wP_4.setLocation(-1);
                    wP_4.setCaptured(true);
                } else if (wP_5.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wP_5.setLocation(-1);
                    wP_5.setCaptured(true);
                } else if (wP_6.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wP_6.setLocation(-1);
                    wP_6.setCaptured(true);
                } else if (wP_7.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wP_7.setLocation(-1);
                    wP_7.setCaptured(true);
                } else if (wP_8.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    wP_8.setLocation(-1);
                    wP_8.setCaptured(true);
                } else if (bK.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bK.setLocation(-1);
                    bK.setCaptured(true);
                } else if (bQ.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bQ.setLocation(-1);
                    bQ.setCaptured(true);
                } else if (bR_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bR_1.setLocation(-1);
                    bR_1.setCaptured(true);
                } else if (bR_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bR_2.setLocation(-1);
                    bR_2.setCaptured(true);
                } else if (bB_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bB_1.setLocation(-1);
                    bB_1.setCaptured(true);
                } else if (bB_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bB_2.setLocation(-1);
                    bB_2.setCaptured(true);
                } else if (bN_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bN_1.setLocation(-1);
                    bN_1.setCaptured(true);
                } else if (bN_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bN_2.setLocation(-1);
                    bN_2.setCaptured(true);
                } else if (bP_1.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bP_1.setLocation(-1);
                    bP_1.setCaptured(true);
                } else if (bP_2.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bP_2.setLocation(-1);
                    bP_2.setCaptured(true);
                } else if (bP_3.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bP_3.setLocation(-1);
                    bP_3.setCaptured(true);
                } else if (bP_4.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bP_4.setLocation(-1);
                    bP_4.setCaptured(true);
                } else if (bP_5.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bP_5.setLocation(-1);
                    bP_5.setCaptured(true);
                } else if (bP_6.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bP_6.setLocation(-1);
                    bP_6.setCaptured(true);
                } else if (bP_7.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bP_7.setLocation(-1);
                    bP_7.setCaptured(true);
                } else if (bP_8.getLocation() == TeamLewisChessController.getSquareClicked()) {
                    bP_8.setLocation(-1);
                    bP_8.setCaptured(true);
                }
            }
            
            //Step 3-D. Update the location variable of the piece on the targetedSquare to the
            //squareClicked value.
            //Step 3-E. If the piece being moved is a King, set King's hasMoved variable to true.
            //Same for rook.
            //Step 3-F. If the piece being moved is a Pawn and the squareClicked has row value of
            //either 0 or 7, then the pawn is promoted.
                //Display menu for user to choose what to promote pawn to; wait for user input.
                //Set that Pawn object's promoted boolean variable to true.
                //Set that Pawn object's corresponding promotion boolean variable to true.
            if (wK.getLocation() == Game.getTargetedSquare()) {
                wK.setLocation(TeamLewisChessController.getSquareClicked());
                wK.setHasMoved(true);
            } else if (wQ.getLocation() == Game.getTargetedSquare()) {
                wQ.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wR_1.getLocation() == Game.getTargetedSquare()) {
                wR_1.setLocation(TeamLewisChessController.getSquareClicked());
                wR_1.setHasMoved(true);
            } else if (wR_2.getLocation() == Game.getTargetedSquare()) {
                wR_2.setLocation(TeamLewisChessController.getSquareClicked());
                wR_2.setHasMoved(true);
            } else if (wB_1.getLocation() == Game.getTargetedSquare()) {
                wB_1.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wB_2.getLocation() == Game.getTargetedSquare()) {
                wB_2.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wN_1.getLocation() == Game.getTargetedSquare()) {
                wN_1.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wN_2.getLocation() == Game.getTargetedSquare()) {
                wN_2.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wP_1.getLocation() == Game.getTargetedSquare()) {
                wP_1.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 0 && wP_1.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (wP_2.getLocation() == Game.getTargetedSquare()) {
                wP_2.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 0 && wP_2.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (wP_3.getLocation() == Game.getTargetedSquare()) {
                wP_3.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 0 && wP_3.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (wP_4.getLocation() == Game.getTargetedSquare()) {
                wP_4.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 0 && wP_4.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (wP_5.getLocation() == Game.getTargetedSquare()) {
                wP_5.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 0 && wP_5.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (wP_6.getLocation() == Game.getTargetedSquare()) {
                wP_6.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 0 && wP_6.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (wP_7.getLocation() == Game.getTargetedSquare()) {
                wP_7.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 0 && wP_7.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (wP_8.getLocation() == Game.getTargetedSquare()) {
                wP_8.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 0 && wP_8.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (bK.getLocation() == Game.getTargetedSquare()) {
                bK.setLocation(TeamLewisChessController.getSquareClicked());
                bK.setHasMoved(true);
            } else if (bQ.getLocation() == Game.getTargetedSquare()) {
                bQ.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bR_1.getLocation() == Game.getTargetedSquare()) {
                bR_1.setLocation(TeamLewisChessController.getSquareClicked());
                bR_1.setHasMoved(true);
            } else if (bR_2.getLocation() == Game.getTargetedSquare()) {
                bR_2.setLocation(TeamLewisChessController.getSquareClicked());
                bR_2.setHasMoved(true);
            } else if (bB_1.getLocation() == Game.getTargetedSquare()) {
                bB_1.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bB_2.getLocation() == Game.getTargetedSquare()) {
                bB_2.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bN_1.getLocation() == Game.getTargetedSquare()) {
                bN_1.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bN_2.getLocation() == Game.getTargetedSquare()) {
                bN_2.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bP_1.getLocation() == Game.getTargetedSquare()) {
                bP_1.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 7 && bP_1.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (bP_2.getLocation() == Game.getTargetedSquare()) {
                bP_2.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 7 && bP_2.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (bP_3.getLocation() == Game.getTargetedSquare()) {
                bP_3.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 7 && bP_3.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (bP_4.getLocation() == Game.getTargetedSquare()) {
                bP_4.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 7 && bP_4.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (bP_5.getLocation() == Game.getTargetedSquare()) {
                bP_5.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 7 && bP_5.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (bP_6.getLocation() == Game.getTargetedSquare()) {
                bP_6.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 7 && bP_6.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (bP_7.getLocation() == Game.getTargetedSquare()) {
                bP_7.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 7 && bP_7.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            } else if (bP_8.getLocation() == Game.getTargetedSquare()) {
                bP_8.setLocation(TeamLewisChessController.getSquareClicked());
                if (squareClickedRow == 7 && bP_8.promoted() == false)
                {
                    isBeingPromoted = true;
                    
                    onePromotionWindow.displayPromotionWindow();
                }
            }
            
            //Step 3-G. Update the square and image values for controller class.
            TeamLewisChessController.setSquareToWipe(Game.getTargetedSquare());
            TeamLewisChessController.setSquareMovedTo(TeamLewisChessController.getSquareClicked());
            TeamLewisChessController.setImageToUpdateSquareMovedTo(pieceTypeLocationsOnBoard[targetedSquareRow][targetedSquareColumn]);
            TeamLewisChessController.setSpecialSquareToWipe(-1);
            TeamLewisChessController.setSpecialSquareMovedTo(-1);
            TeamLewisChessController.setImageToUpdateSpecialSquareMovedTo(-1);
            
            //Step 3-H. Update the pieceTypeLocationsOnBoard double array.
            //And reupdate imageToUpdateSquareMovedTo if a promotion was made.
            if (isBeingPromoted && Game.getCurrentTeamsTurn() == 0) {
                if (isBeingPromotedToKnight) {
                    pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] = 3;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(3);
                } else if (isBeingPromotedToBishop) {
                    pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] = 4;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(4);
                } else if (isBeingPromotedToRook) {
                    pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] = 2;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(2);
                } else if (isBeingPromotedToQueen) {
                    pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] = 5;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(5);
                }
            } else if (isBeingPromoted && Game.getCurrentTeamsTurn() == 1) {
                if (isBeingPromotedToKnight) {
                    pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] = 9;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(9);
                } else if (isBeingPromotedToBishop) {
                    pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] = 10;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(10);
                } else if (isBeingPromotedToRook) {
                    pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] = 8;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(9);
                } else if (isBeingPromotedToQueen) {
                    pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] = 11;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(11);
                }
            } else {
                pieceTypeLocationsOnBoard[squareClickedRow][squareClickedColumn] = pieceTypeLocationsOnBoard[targetedSquareRow][targetedSquareColumn];
            }
            
            pieceTypeLocationsOnBoard[targetedSquareRow][targetedSquareColumn] = 0;
        }
        
        //Step 4
        updateGameStatus();
    }
    
    /**
     * 
     * @param fLocation
     * @return row of fLocation
     */
    static public int getRowFromLocation(int fLocation)
    {
        //Just to satisfy program and to be updated with algorithm:
        return (fLocation / 8);
    }
    
    /**
     * 
     * @param fLocation
     * @return column of fLoction
     */
    static public int getColumnFromLocation(int fLocation)
    {
        //Just to satisfy program and to be updated with algorithm:
        return (fLocation % 8);
    }
    
    /**
     * 
     * @param fRow
     * @param fColumn
     * @return location on board given row and column, integer from 0 to 63
     */
    static public int getLocationFromRowAndColumn(int fRow, int fColumn)
    {        
        return ((fRow * 8) + fColumn);
    }
    
    /**
     * 
     * @return boolean if castling move
     */
    private boolean isACastlingMove()
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    /**
     * 
     * @return boolean if EnPassant Pawn move
     */
    private boolean isAnEnPassantMove()
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    /**
     * 
     * @return boolean from piece pawn promoted
     */
    private boolean isBeingPromoted()
    {
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    /**
     * updateGameStatus 
     */
    private void updateGameStatus()
    {
        
    }
    
    /**
     * 
     */
    public Board()
    {
        this.onePromotionWindow = new PromotionWindow();
        //All squares with no pieces on them (rows 2-5) are initialized to 0.
        //No piece is on these squares.
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
