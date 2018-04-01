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
        int row = getRowFromLocation(Game.getTargetedSquare());
        int column = getColumnFromLocation(Game.getTargetedSquare());
        
        if (wK.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return King.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wQ.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Queen.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wR_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wR_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Rook.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wB_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wB_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Bishop.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wN_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wN_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Knight.isValidMove(pieceTypeLocationsOnBoard, black);
        } else if (wP_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (wP_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (wP_3.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (wP_4.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (wP_5.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (wP_6.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (wP_7.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (wP_8.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (bK.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return King.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bQ.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Queen.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bR_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bR_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Rook.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bB_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bB_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Bishop.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bN_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bN_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            return Knight.isValidMove(pieceTypeLocationsOnBoard, white);
        } else if (bP_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (bP_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (bP_3.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (bP_4.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (bP_5.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (bP_6.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (bP_7.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
        } else if (bP_8.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
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
    
    public void updateBoard()
    {
        //Testing / playing for now:
        
        int row = getRowFromLocation(Game.getTargetedSquare());
        int column = getColumnFromLocation(Game.getTargetedSquare());
        
        switch (pieceTypeLocationsOnBoard[row][column]) {            
            case 1:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(1);
                break;
            case 2:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(2);
                break;
            case 3:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(3);
                break;
            case 4:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(4);
                break;
            case 5:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(5);
                break;
            case 6:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(6);
                break;
            case 7:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(7);
                break;
            case 8:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(8);
                break;
            case 9:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(9);
                break;
            case 10:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(10);
                break;
            case 11:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(11);
                break;
            case 12:
                TeamLewisChessController.setImageToUpdateSquareMovedTo(12);
                break;
            default:
                break;
        }
        
        TeamLewisChessController.setSquareMovedTo(TeamLewisChessController.getSquareClicked());
        TeamLewisChessController.setSquareToWipe(Game.getTargetedSquare());
        
        int row2 = getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int column2 = getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        pieceTypeLocationsOnBoard[row2][column2] = pieceTypeLocationsOnBoard[row][column];
        pieceTypeLocationsOnBoard[row][column] = 0;
        
        if (wK.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wK.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wQ.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wQ.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wR_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wR_1.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wR_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wR_2.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wB_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wB_1.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wB_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wB_2.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wN_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wN_1.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wN_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wN_2.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wP_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wP_1.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wP_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wP_2.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wP_3.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wP_3.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wP_4.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wP_4.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wP_5.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wP_5.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wP_6.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wP_6.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wP_7.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wP_7.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (wP_8.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wP_8.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bK.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bK.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bQ.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bQ.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bR_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bR_1.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bR_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bR_2.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bB_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bB_1.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bB_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bB_2.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bN_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bN_1.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bN_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            wK.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bP_1.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bP_1.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bP_2.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bP_2.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bP_3.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bP_3.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bP_4.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bP_4.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bP_5.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bP_5.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bP_6.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bP_6.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bP_7.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bP_7.setLocation(TeamLewisChessController.getSquareClicked());
        } else if (bP_8.getLocation() == pieceTypeLocationsOnBoard[row][column]) {
            bP_8.setLocation(TeamLewisChessController.getSquareClicked());
        }
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
