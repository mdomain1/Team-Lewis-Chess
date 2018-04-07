package teamlewischess;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Board class.
 * 
 * All sounds played in this class: in methods resetBoardForNewGame and updateBoard,
 * at the beginning and end in each, respectively.
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
        //Playing these two sounds together to make it sound like a lot of pieces are
        //being moved at once as the board is being reset:
        TeamLewisChess.playSoundMove();
        TeamLewisChess.playSoundCapture();
                
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
        //For readability and efficiency:
        int targetedRow = getRowFromLocation(Game.getTargetedSquare());
        int targetedColumn = getColumnFromLocation(Game.getTargetedSquare());        
        int rowClicked = getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        isBeingPromoted = false;
        isBeingPromotedToKnight = false;
        isBeingPromotedToBishop = false;
        isBeingPromotedToRook = false;
        isBeingPromotedToQueen = false;
        
        //Boolean flags used for choosing which sound to play at the end of this method:
        boolean moveIsANormalMove = false;
        boolean capturing = false;
        
        //Step 1
        if (isACastlingMove())
        {            
            //Step 1-A. Update static square and image values for controller class.
            //Step 1-B. Update the King and Rook objects' location and hasMoved variables.
            //Step 1-C. Update the pieceTypeLocationsOnBoard double array.
            TeamLewisChessController.setSquareToWipe(Game.getTargetedSquare());
            TeamLewisChessController.setSquareMovedTo(TeamLewisChessController.getSquareClicked());
            TeamLewisChessController.setImageToUpdateSquareMovedTo(pieceTypeLocationsOnBoard[targetedRow][targetedColumn]);
            
            if (Game.getCurrentTeamsTurn() == 0 && targetedColumn == columnClicked - 2) //White castling king-side
            {
                TeamLewisChessController.setSpecialSquareToWipe(63);
                TeamLewisChessController.setSpecialSquareMovedTo(61);
                TeamLewisChessController.setImageToUpdateSpecialSquareMovedTo(2);
                
                wK.setHasMoved(true);
                wR_2.setHasMoved(true);
                
                wK.setLocation(62);
                wR_2.setLocation(61);
                
                pieceTypeLocationsOnBoard[7][4] = 0;
                pieceTypeLocationsOnBoard[7][5] = 2;
                pieceTypeLocationsOnBoard[7][6] = 6;
                pieceTypeLocationsOnBoard[7][7] = 0;
            }
            else if (Game.getCurrentTeamsTurn() == 0 && targetedColumn == columnClicked + 2) //White castling queen-side
            {
                TeamLewisChessController.setSpecialSquareToWipe(56);
                TeamLewisChessController.setSpecialSquareMovedTo(59);
                TeamLewisChessController.setImageToUpdateSpecialSquareMovedTo(2);
                
                wK.setHasMoved(true);
                wR_1.setHasMoved(true);
                
                wK.setLocation(58);
                wR_1.setLocation(59);
                
                pieceTypeLocationsOnBoard[7][0] = 0;
                pieceTypeLocationsOnBoard[7][2] = 6;
                pieceTypeLocationsOnBoard[7][3] = 2;
                pieceTypeLocationsOnBoard[7][4] = 0;
            }
            else if (Game.getCurrentTeamsTurn() == 1 && targetedColumn == columnClicked - 2) //Black castling king-side
            {
                TeamLewisChessController.setSpecialSquareToWipe(7);
                TeamLewisChessController.setSpecialSquareMovedTo(5);
                TeamLewisChessController.setImageToUpdateSpecialSquareMovedTo(8);
                
                bK.setHasMoved(true);
                bR_2.setHasMoved(true);
                
                bK.setLocation(6);
                bR_2.setLocation(5);
                
                pieceTypeLocationsOnBoard[0][4] = 0;
                pieceTypeLocationsOnBoard[0][5] = 8;
                pieceTypeLocationsOnBoard[0][6] = 12;
                pieceTypeLocationsOnBoard[0][7] = 0;
            }
            else if (Game.getCurrentTeamsTurn() == 1 && targetedColumn == columnClicked + 2) //Black castling queen-side
            {
                TeamLewisChessController.setSpecialSquareToWipe(0);
                TeamLewisChessController.setSpecialSquareMovedTo(3);
                TeamLewisChessController.setImageToUpdateSpecialSquareMovedTo(8);
                
                bK.setHasMoved(true);
                bR_1.setHasMoved(true);
                
                bK.setLocation(2);
                bR_1.setLocation(3);
                
                pieceTypeLocationsOnBoard[0][0] = 0;
                pieceTypeLocationsOnBoard[0][2] = 12;
                pieceTypeLocationsOnBoard[0][3] = 8;
                pieceTypeLocationsOnBoard[0][4] = 0;
            }
                        
            //Step 1-D. Update the pawnMovedTwoSpacesLastMove of the team whose turn is the current
            //turn to false.
            //Step 1-E. Increment numOfMovesNoCaptureOrPawnMoves by one for the Team whose
            //currentTeamsTurn it is.            
            if (Game.getCurrentTeamsTurn() == 0) {
                white.pawnMovedTwoSpacesLastMove = false;
                white.numOfMovesNoCaptureOrPawnMoves += 1;
            } else {
                black.pawnMovedTwoSpacesLastMove = false;
                black.numOfMovesNoCaptureOrPawnMoves += 1;
            }
        }
        //Step 2
        else if (isAnEnPassantMove())
        {   
            capturing = true;
            
            //Step 2-A. Update the square and image values for controller class.
            TeamLewisChessController.setSquareToWipe(Game.getTargetedSquare());
            TeamLewisChessController.setSquareMovedTo(TeamLewisChessController.getSquareClicked());
            TeamLewisChessController.setImageToUpdateSquareMovedTo(pieceTypeLocationsOnBoard[targetedRow][targetedColumn]);
            TeamLewisChessController.setSpecialSquareToWipe(getLocationFromRowAndColumn(targetedRow, columnClicked));
            TeamLewisChessController.setSpecialSquareMovedTo(-1);
            TeamLewisChessController.setImageToUpdateSpecialSquareMovedTo(-1);
            
            //Step 2-B. Update the Pawn object's location variable.
            if (wP_1.getLocation() == Game.getTargetedSquare()) {
                wP_1.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wP_2.getLocation() == Game.getTargetedSquare()) {
                wP_2.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wP_3.getLocation() == Game.getTargetedSquare()) {
                wP_3.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wP_4.getLocation() == Game.getTargetedSquare()) {
                wP_4.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wP_5.getLocation() == Game.getTargetedSquare()) {
                wP_5.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wP_6.getLocation() == Game.getTargetedSquare()) {
                wP_6.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wP_7.getLocation() == Game.getTargetedSquare()) {
                wP_7.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (wP_8.getLocation() == Game.getTargetedSquare()) {
                wP_8.setLocation(TeamLewisChessController.getSquareClicked());
            } if (bP_1.getLocation() == Game.getTargetedSquare()) {
                bP_1.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bP_2.getLocation() == Game.getTargetedSquare()) {
                bP_2.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bP_3.getLocation() == Game.getTargetedSquare()) {
                bP_3.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bP_4.getLocation() == Game.getTargetedSquare()) {
                bP_4.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bP_5.getLocation() == Game.getTargetedSquare()) {
                bP_5.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bP_6.getLocation() == Game.getTargetedSquare()) {
                bP_6.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bP_7.getLocation() == Game.getTargetedSquare()) {
                bP_7.setLocation(TeamLewisChessController.getSquareClicked());
            } else if (bP_8.getLocation() == Game.getTargetedSquare()) {
                bP_8.setLocation(TeamLewisChessController.getSquareClicked());
            }
            
            //Step 2-C. Set the location variable of the Pawn object being captured to -1
            //and its captured boolean variable to true.
            //The captured pawn, for efficiency, and readability:
            int capturedPawnLocation = getLocationFromRowAndColumn(targetedRow, columnClicked);
            
            if (wP_1.getLocation() == capturedPawnLocation) {
                wP_1.setLocation(-1);
                wP_1.setCaptured(true);
            } else if (wP_2.getLocation() == capturedPawnLocation) {
                wP_2.setLocation(-1);
                wP_2.setCaptured(true);
            } else if (wP_3.getLocation() == capturedPawnLocation) {
                wP_3.setLocation(-1);
                wP_3.setCaptured(true);
            } else if (wP_4.getLocation() == capturedPawnLocation) {
                wP_4.setLocation(-1);
                wP_4.setCaptured(true);
            } else if (wP_5.getLocation() == capturedPawnLocation) {
                wP_5.setLocation(-1);
                wP_5.setCaptured(true);
            } else if (wP_6.getLocation() == capturedPawnLocation) {
                wP_6.setLocation(-1);
                wP_6.setCaptured(true);
            } else if (wP_7.getLocation() == capturedPawnLocation) {
                wP_7.setLocation(-1);
                wP_7.setCaptured(true);
            } else if (wP_8.getLocation() == capturedPawnLocation) {
                wP_8.setLocation(-1);
                wP_8.setCaptured(true);
            } else if (bP_1.getLocation() == capturedPawnLocation) {
                bP_1.setLocation(-1);
                bP_1.setCaptured(true);
            } else if (bP_2.getLocation() == capturedPawnLocation) {
                bP_2.setLocation(-1);
                bP_2.setCaptured(true);
            } else if (bP_3.getLocation() == capturedPawnLocation) {
                bP_3.setLocation(-1);
                bP_3.setCaptured(true);
            } else if (bP_4.getLocation() == capturedPawnLocation) {
                bP_4.setLocation(-1);
                bP_4.setCaptured(true);
            } else if (bP_5.getLocation() == capturedPawnLocation) {
                bP_5.setLocation(-1);
                bP_5.setCaptured(true);
            } else if (bP_6.getLocation() == capturedPawnLocation) {
                bP_6.setLocation(-1);
                bP_6.setCaptured(true);
            } else if (bP_7.getLocation() == capturedPawnLocation) {
                bP_7.setLocation(-1);
                bP_7.setCaptured(true);
            } else if (bP_8.getLocation() == capturedPawnLocation) {
                bP_8.setLocation(-1);
                bP_8.setCaptured(true);
            }
            
            //Step 2-D. Update the pieceTypeLocationsOnBoard double array.
            pieceTypeLocationsOnBoard[rowClicked][columnClicked] = pieceTypeLocationsOnBoard[targetedRow][targetedColumn];
            pieceTypeLocationsOnBoard[targetedRow][targetedColumn] = 0;
            pieceTypeLocationsOnBoard[targetedRow][columnClicked] = 0;
            
            //Step 2-E. Update the pawnMovedTwoSpacesLastMove of the team whose turn is
            //the current turn to false.
            //Step 2-F. Update numOfMovesNoCaptureOrPawnMoves = 0 for the Team whose
            //currentTeamsTurn it is.            
            if (Game.getCurrentTeamsTurn() == 0) {
                white.pawnMovedTwoSpacesLastMove = false;
                white.numOfMovesNoCaptureOrPawnMoves = 0;
            } else {
                black.pawnMovedTwoSpacesLastMove = false;
                black.numOfMovesNoCaptureOrPawnMoves = 0;
            }
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
                if (wP_1.promoted() == false && targetedRow == rowClicked + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                } 
            } else if (wP_2.getLocation() == Game.getTargetedSquare()) {
                if (wP_2.promoted() == false && targetedRow == rowClicked + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_3.getLocation() == Game.getTargetedSquare()) {
                if (wP_3.promoted() == false && targetedRow == rowClicked + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_4.getLocation() == Game.getTargetedSquare()) {
                if (wP_4.promoted() == false && targetedRow == rowClicked + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_5.getLocation() == Game.getTargetedSquare()) {
                if (wP_5.promoted() == false && targetedRow == rowClicked + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_6.getLocation() == Game.getTargetedSquare()) {
                if (wP_6.promoted() == false && targetedRow == rowClicked + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_7.getLocation() == Game.getTargetedSquare()) {
                if (wP_7.promoted() == false && targetedRow == rowClicked + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (wP_8.getLocation() == Game.getTargetedSquare()) {
                if (wP_8.promoted() == false && targetedRow == rowClicked + 2)
                {
                    white.pawnMovedTwoSpacesLastMove = true;
                    white.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_1.getLocation() == Game.getTargetedSquare()) {
                if (bP_1.promoted() == false && targetedRow == rowClicked - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_2.getLocation() == Game.getTargetedSquare()) {
                if (bP_2.promoted() == false && targetedRow == rowClicked - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_3.getLocation() == Game.getTargetedSquare()) {
                if (bP_3.promoted() == false && targetedRow == rowClicked - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_4.getLocation() == Game.getTargetedSquare()) {
                if (bP_4.promoted() == false && targetedRow == rowClicked - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_5.getLocation() == Game.getTargetedSquare()) {
                if (bP_5.promoted() == false && targetedRow == rowClicked - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_6.getLocation() == Game.getTargetedSquare()) {
                if (bP_6.promoted() == false && targetedRow == rowClicked - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_7.getLocation() == Game.getTargetedSquare()) {
                if (bP_7.promoted() == false && targetedRow == rowClicked - 2)
                {
                    black.pawnMovedTwoSpacesLastMove = true;
                    black.squarePawnMovedTwoLastMovedTo = TeamLewisChessController.getSquareClicked();
                }
            } else if (bP_8.getLocation() == Game.getTargetedSquare()) {
                if (bP_8.promoted() == false && targetedRow == rowClicked - 2)
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
            if (pieceTypeLocationsOnBoard[rowClicked][columnClicked] != 0)
            {   
                capturing = true;
                
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
            } else {
                moveIsANormalMove = true;
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
                if (rowClicked == 0 && wP_1.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    wP_1.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        wP_1.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        wP_1.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        wP_1.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        wP_1.setPromotedToKnight(true);
                    }
                }
            } else if (wP_2.getLocation() == Game.getTargetedSquare()) {
                wP_2.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 0 && wP_2.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    wP_2.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        wP_2.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        wP_2.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        wP_2.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        wP_2.setPromotedToKnight(true);
                    }
                }
            } else if (wP_3.getLocation() == Game.getTargetedSquare()) {
                wP_3.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 0 && wP_3.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    wP_3.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        wP_3.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        wP_3.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        wP_3.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        wP_3.setPromotedToKnight(true);
                    }
                }
            } else if (wP_4.getLocation() == Game.getTargetedSquare()) {
                wP_4.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 0 && wP_4.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    wP_4.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        wP_4.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        wP_4.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        wP_4.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        wP_4.setPromotedToKnight(true);
                    }
                }
            } else if (wP_5.getLocation() == Game.getTargetedSquare()) {
                wP_5.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 0 && wP_5.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    wP_5.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        wP_5.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        wP_5.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        wP_5.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        wP_5.setPromotedToKnight(true);
                    }
                }
            } else if (wP_6.getLocation() == Game.getTargetedSquare()) {
                wP_6.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 0 && wP_6.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    wP_6.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        wP_6.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        wP_6.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        wP_6.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        wP_6.setPromotedToKnight(true);
                    }
                }
            } else if (wP_7.getLocation() == Game.getTargetedSquare()) {
                wP_7.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 0 && wP_7.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    wP_7.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        wP_7.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        wP_7.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        wP_7.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        wP_7.setPromotedToKnight(true);
                    }
                }
            } else if (wP_8.getLocation() == Game.getTargetedSquare()) {
                wP_8.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 0 && wP_8.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    wP_8.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        wP_8.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        wP_8.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        wP_8.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        wP_8.setPromotedToKnight(true);
                    }
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
                if (rowClicked == 7 && bP_1.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    bP_1.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        bP_1.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        bP_1.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        bP_1.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        bP_1.setPromotedToKnight(true);
                    }
                }
            } else if (bP_2.getLocation() == Game.getTargetedSquare()) {
                bP_2.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 7 && bP_2.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    bP_2.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        bP_2.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        bP_2.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        bP_2.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        bP_2.setPromotedToKnight(true);
                    }
                }
            } else if (bP_3.getLocation() == Game.getTargetedSquare()) {
                bP_3.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 7 && bP_3.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    bP_3.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        bP_3.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        bP_3.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        bP_3.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        bP_3.setPromotedToKnight(true);
                    }
                }
            } else if (bP_4.getLocation() == Game.getTargetedSquare()) {
                bP_4.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 7 && bP_4.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    bP_4.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        bP_4.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        bP_4.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        bP_4.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        bP_4.setPromotedToKnight(true);
                    }
                }
            } else if (bP_5.getLocation() == Game.getTargetedSquare()) {
                bP_5.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 7 && bP_5.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    bP_5.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        bP_5.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        bP_5.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        bP_5.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        bP_5.setPromotedToKnight(true);
                    }
                }
            } else if (bP_6.getLocation() == Game.getTargetedSquare()) {
                bP_6.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 7 && bP_6.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    bP_6.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        bP_6.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        bP_6.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        bP_6.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        bP_6.setPromotedToKnight(true);
                    }
                }
            } else if (bP_7.getLocation() == Game.getTargetedSquare()) {
                bP_7.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 7 && bP_7.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    bP_7.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        bP_7.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        bP_7.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        bP_7.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        bP_7.setPromotedToKnight(true);
                    }
                }
            } else if (bP_8.getLocation() == Game.getTargetedSquare()) {
                bP_8.setLocation(TeamLewisChessController.getSquareClicked());
                if (rowClicked == 7 && bP_8.promoted() == false)
                {
                    onePromotionWindow.displayPromotionWindow();
                    
                    isBeingPromoted = true;
                    bP_8.setPromoted(true);
                    
                    if (isBeingPromotedToQueen) {
                        bP_8.setPromotedToQueen(true);
                    } else if (isBeingPromotedToRook) {
                        bP_8.setPromotedToRook(true);
                    } else if (isBeingPromotedToBishop) {
                        bP_8.setPromotedToBishop(true);
                    } else if (isBeingPromotedToKnight) {
                        bP_8.setPromotedToKnight(true);
                    }
                }
            }
            
            //Step 3-G. Update the square and image values for controller class.
            TeamLewisChessController.setSquareToWipe(Game.getTargetedSquare());
            TeamLewisChessController.setSquareMovedTo(TeamLewisChessController.getSquareClicked());
            TeamLewisChessController.setImageToUpdateSquareMovedTo(pieceTypeLocationsOnBoard[targetedRow][targetedColumn]);
            TeamLewisChessController.setSpecialSquareToWipe(-1);
            TeamLewisChessController.setSpecialSquareMovedTo(-1);
            TeamLewisChessController.setImageToUpdateSpecialSquareMovedTo(-1);
            
            //Step 3-H. Update the pieceTypeLocationsOnBoard double array.
            //And reupdate imageToUpdateSquareMovedTo if a promotion was made.
            if (isBeingPromoted && Game.getCurrentTeamsTurn() == 0) {
                if (isBeingPromotedToKnight) {
                    pieceTypeLocationsOnBoard[rowClicked][columnClicked] = 3;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(3);
                } else if (isBeingPromotedToBishop) {
                    pieceTypeLocationsOnBoard[rowClicked][columnClicked] = 4;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(4);
                } else if (isBeingPromotedToRook) {
                    pieceTypeLocationsOnBoard[rowClicked][columnClicked] = 2;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(2);
                } else if (isBeingPromotedToQueen) {
                    pieceTypeLocationsOnBoard[rowClicked][columnClicked] = 5;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(5);
                }
            } else if (isBeingPromoted && Game.getCurrentTeamsTurn() == 1) {
                if (isBeingPromotedToKnight) {
                    pieceTypeLocationsOnBoard[rowClicked][columnClicked] = 9;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(9);
                } else if (isBeingPromotedToBishop) {
                    pieceTypeLocationsOnBoard[rowClicked][columnClicked] = 10;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(10);
                } else if (isBeingPromotedToRook) {
                    pieceTypeLocationsOnBoard[rowClicked][columnClicked] = 8;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(8);
                } else if (isBeingPromotedToQueen) {
                    pieceTypeLocationsOnBoard[rowClicked][columnClicked] = 11;
                    TeamLewisChessController.setImageToUpdateSquareMovedTo(11);
                }
            } else {
                pieceTypeLocationsOnBoard[rowClicked][columnClicked] = pieceTypeLocationsOnBoard[targetedRow][targetedColumn];
            }
            
            pieceTypeLocationsOnBoard[targetedRow][targetedColumn] = 0;
        }
        
        //The check sound takes precedence over the castling, move, and capture sounds.
        //Can check while castling, while moving, and while capturing.
        //The castling sound takes precedence over the move sound, but
        //castling is a distinct move and sound apart from moving or capturing,
        //so there is no decision that has to be made between the castling sound and
        //the move and capture sounds. Same with the move and capture sounds. Hence,
        //They are all on the same tier.
        //Note: Capturing en passant plays the capture sound.
        //
        //If the resulting move places the enemy king in check,
        //      Play the check sound.
        //Else if the move is normal move,
        //      Play the move sound.
        //Else if capturing,
        //      Play the capture sound.
        //Else,
        //      Play the castle sound.

        if (Game.getCurrentTeamsTurn() == 0 && bK.isInCheck(pieceTypeLocationsOnBoard)) {
            TeamLewisChess.playSoundCheck();
        } else if (Game.getCurrentTeamsTurn() == 1 && wK.isInCheck(pieceTypeLocationsOnBoard)) {
            TeamLewisChess.playSoundCheck();
        } else if (moveIsANormalMove) {
            TeamLewisChess.playSoundMove();
        } else if (capturing) {
            TeamLewisChess.playSoundCapture();
        } else {
            TeamLewisChess.playSoundCastle();
        }
        
        //Step 4
        //updateGameStatus();
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
        //For readability:
        //int rowClicked = getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        int targetedRow = getRowFromLocation(Game.getTargetedSquare());
        int targetedColumn = getColumnFromLocation(Game.getTargetedSquare());
        
        if (pieceTypeLocationsOnBoard[targetedRow][targetedColumn] == 6 || pieceTypeLocationsOnBoard[targetedRow][targetedColumn] == 12) {
            if (columnClicked == targetedColumn + 2 || columnClicked == targetedColumn - 2) {
                return true;
            }
        }
        
        //Else,
        return false;
    }
    
    /**
     * 
     * @return boolean if EnPassant Pawn move
     */
    private boolean isAnEnPassantMove()
    {
        //For readability:
        int rowClicked = getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        int targetedRow = getRowFromLocation(Game.getTargetedSquare());
        int targetedColumn = getColumnFromLocation(Game.getTargetedSquare());
        
        if (columnClicked != targetedColumn && pieceTypeLocationsOnBoard[rowClicked][columnClicked] == 0) {
            if (pieceTypeLocationsOnBoard[targetedRow][targetedColumn] == 1 || pieceTypeLocationsOnBoard[targetedRow][targetedColumn] == 7) {
                return true;
            }
        }
        
        //Else,
        return false;
    }
    
    /**
     * updateGameStatus 
     */
    private void updateGameStatus()
    {
        //Store these for isValidMove method calls. Restore at end of this method.
        int targetedSquareTemp = Game.getTargetedSquare();
        int squareClickedTemp = TeamLewisChessController.getSquareClicked();
        
        //Checking for Game Statuses 1 & 2.
        //If black is put in check, check for if black is checkmated: are there any valid moves a black
        //piece can make? Else, check for the same thing if it is white's turn. Thus, the only way that
        //this could happen is if white just placed black in check--black couldn't have moved and
        //remained in check; and vice versa.
        if (Game.getCurrentTeamsTurn() == 0 && bK.isInCheck(pieceTypeLocationsOnBoard) == true) {
            //Preserving currentTeamsTurn and restoring at the end of this if control structure, as we are
            //looking a move ahead to see if black, who is in check now, can get out of check on his turn.
            Game.setCurrentTeamsTurn(1);
            
            boolean validMoveFound = false;
            boolean allMovesHaveBeenChecked = false;
            
            int row = 0;
            
            while (validMoveFound == false && row <= 7)
            {
                int column = 0;
                
                while (validMoveFound == false && column <= 7)
                {
                    switch (pieceTypeLocationsOnBoard[row][column]) {
                        case 7:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Pawn.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 8:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Rook.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 9:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Knight.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 10:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Bishop.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 11:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Queen.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 12:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (King.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        default:
                            
                            break;
                    }
                    
                    column += 1;
                }
                
                row += 1;
                
                if (row == 8)
                {
                    allMovesHaveBeenChecked = true;
                }
            }
            
            //Restoring currentTeamsTurn.
            Game.setCurrentTeamsTurn(0);
            
            if (allMovesHaveBeenChecked == true && validMoveFound == false)
            {
                Game.setGameStatus(1);
            }
        } else if (Game.getCurrentTeamsTurn() == 1 && wK.isInCheck(pieceTypeLocationsOnBoard) == true) {
            //Preserving currentTeamsTurn and restoring at the end of this if control structure, as we are
            //looking a move ahead to see if white, who is in check now, can get out of check on his turn.
            Game.setCurrentTeamsTurn(0);
            
            boolean validMoveFound = false;
            boolean allMovesHaveBeenChecked = false;
            
            int row = 0;
            
            while (validMoveFound == false && row <= 7)
            {
                int column = 0;
                
                while (validMoveFound == false && column <= 7)
                {
                    switch (pieceTypeLocationsOnBoard[row][column]) {
                        case 1:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Pawn.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 2:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Rook.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 3:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Knight.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 4:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Bishop.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 5:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Queen.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 6:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (King.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        default:
                            
                            break;
                    }
                    
                    column += 1;
                }
                
                row += 1;
                
                if (row == 8)
                {
                    allMovesHaveBeenChecked = true;
                }
            }
            
            //Restoring currentTeamsTurn.
            Game.setCurrentTeamsTurn(1);
            
            if (allMovesHaveBeenChecked == true && validMoveFound == false)
            {
                Game.setGameStatus(2);
            }
        }
        
        //Checking for Game Status 3: Draw by stalemate.
        //If Game Status equals 0, then it was not set to 1 or 2 in the previous check.
        //Game Status will only ever equal 0 until it is found to be a new result, in which
        //it must be reset back to 0 before a new game, and therefore this method, is ever
        //reached again.
        //If neither player is in check, check to make sure a valid move still exists.
        //Else, it is stalemate.
        if (Game.getGameStatus() == 0 && wK.isInCheck(pieceTypeLocationsOnBoard) == false && bK.isInCheck(pieceTypeLocationsOnBoard) == false)
        {
            //Preserving currentTeamsTurn and restoring at the end of this if control structure.
            int currentTeamsTurnTemp = Game.getCurrentTeamsTurn();
            
            boolean validMoveFound = false;
            boolean allMovesHaveBeenChecked = false;
            
            int row = 0;
            
            while (validMoveFound == false && row <= 7)
            {
                int column = 0;
                
                while (validMoveFound == false && column <= 7)
                {
                    switch (pieceTypeLocationsOnBoard[row][column]) {
                        case 1:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(0);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Pawn.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            break;
                        case 2:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(0);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Rook.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            break;
                        case 3:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(0);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Knight.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 4:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(0);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Bishop.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 5:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(0);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Queen.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 6:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(0);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (King.isValidMove(pieceTypeLocationsOnBoard, white))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 7:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(1);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Pawn.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 8:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(1);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Rook.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 9:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(1);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Knight.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 10:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(1);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Bishop.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 11:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(1);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (Queen.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        case 12:
                            Game.setTargetedSquare(getLocationFromRowAndColumn(row, column));
                            Game.setCurrentTeamsTurn(1);
                            
                            for (int i = 0; i <= 7; i++)
                            {
                                for (int j = 0; j <= 7; j++)
                                {
                                    TeamLewisChessController.setSquareClicked(getLocationFromRowAndColumn(i, j));
                                    
                                    if (King.isValidMove(pieceTypeLocationsOnBoard, black))
                                    {
                                        validMoveFound = true;
                                    }
                                }
                            }
                            
                            break;
                        default:
                            
                            break;
                    }
                    
                    column += 1;
                }
                
                row += 1;
                
                if (row == 8)
                {
                    allMovesHaveBeenChecked = true;
                }
            }
            
            //Restoring currentTeamsTurn.
            Game.setCurrentTeamsTurn(currentTeamsTurnTemp);
            
            if (allMovesHaveBeenChecked == true && validMoveFound == false)
            {
                Game.setGameStatus(3);
            }
        }
        
        //Checking for Game Status 4: Draw by threefold repetition.
        //If Game Status equals 0, then it was not set from the previous steps. See more details
        //on why in the comments for Game Status check 3 above.
        //This method is not solved yet.
        if (Game.getGameStatus() == 0)
        {
            //Extra feature
        }
        
        //Checking for Game Status 5: Draw by 50-Move Rule.
        //If Game Status equals 0, then it was not set from the previous steps. See more details
        //on why in the comments for Game Status check 3 above.
        //...
        if (Game.getGameStatus() == 0)
        {
            if (white.numOfMovesNoCaptureOrPawnMoves >= 50 && black.numOfMovesNoCaptureOrPawnMoves >= 50)
            {
                Game.setGameStatus(5);
            }
        }
        
        //Checking for Game Status 6: Draw by perpetual check.
        //If Game Status equals 0, then it was not set from the previous steps. See more details
        //on why in the comments for Game Status check 3 above.
        //This method is not solved yet.
        if (Game.getGameStatus() == 0)
        {
            //Extra feature
        }
        
        //Checking for Game Status 7: Draw by insufficient material.
        //If Game Status equals 0, then it was not set from the previous steps. See more details
        //on why in the comments for Game Status check 3 above.
        //This method is not solved yet.
        if (Game.getGameStatus() == 0)
        {
            //Extra feature
        }
        
        //Restoring:
        Game.setTargetedSquare(targetedSquareTemp);
        TeamLewisChessController.setSquareClicked(squareClickedTemp);
        
        //Display appropriate message.
        switch (Game.getGameStatus())
        {
            case 1: //White wins (Black is checkmated.).
                String gameResult1 = "White wins! Black is checkmated.";
                JOptionPane.showMessageDialog(null, gameResult1);
                
                break;
            case 2: //Black wins (White is checkmated.).
                String gameResult2 = "Black wins! White is checkmated.";
                JOptionPane.showMessageDialog(null, gameResult2);
                
                break;
            case 3: //Draw by stalemate.
                String gameResult3 = "Draw by stalemate.";
                JOptionPane.showMessageDialog(null, gameResult3);
                
                break;
            case 4: //Draw by threefold repetition.
                    //Not solved yet.
                String gameResult4 = "Draw by threefold repetition.";
                JOptionPane.showMessageDialog(null, gameResult4);
                
                break;
            case 5: //Draw by 50-Move Rule
                
                String gameResult5 = "Draw by the Fifty Move Rule.";
                JOptionPane.showMessageDialog(null, gameResult5);
                break;
            case 6: //Draw by perpetual check.
                    //Not solved yet.
                
                String gameResult6 = "Draw by perpetual check.";
                JOptionPane.showMessageDialog(null, gameResult6);
                
                break;
            case 7: //Draw by insufficient material.
                    //Not solved yet.
                
                String gameResult7 = "Draw by insufficient material.";
                JOptionPane.showMessageDialog(null, gameResult7);
                
                break;
        }
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
