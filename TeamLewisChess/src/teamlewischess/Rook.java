package teamlewischess;

import java.util.ArrayList;
import java.util.List;

/**
 * @see Piece
 */
public class Rook extends Piece {
    static public boolean hasMoved;

    public Rook(int fLocation, int fTeam) {
        super(fLocation, fTeam);
    }

    static public boolean isValidMove(int[][] fPieceTypeLocationsOnBoard, Team fTeam) {

//        System.out.println("Rook withinRange of PieceMobility: " + 
//                 Rook.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard));
//         System.out.println("noPieceBlocksPathToSquare: " + 
//                 Rook.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard));         
//        System.out.println("moveDoesNotPlaceKingInCheck:  " + 
//                 Rook.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard));
        
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
    
        int rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        int columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
                final List<Integer> legalMoves = new ArrayList<>();
        final List<String> legalSquareStrings = new ArrayList<>();
        final List<Integer> possibleMoves = new ArrayList<>();
        final List<Integer> movePP = new ArrayList<>();
        final List<Integer> movePM = new ArrayList<>();
        final List<Integer> moveMP = new ArrayList<>();
        final List<Integer> moveMM = new ArrayList<>();
        final List<Integer> moveUP = new ArrayList<>();
        final List<Integer> moveDN = new ArrayList<>();
        final List<Integer> moveRT = new ArrayList<>();
        final List<Integer> moveLF = new ArrayList<>();
        final List<String> boardList = new ArrayList<>();

        final int SIZE = 8;
        final int MAX_ROW = 7;
        final int MIN_ROW = 0;
        final int MAX_COL = 7;
        final int MIN_COL = 0;

        int rindx = Board.getRowFromLocation(Game.getTargetedSquare());
        int cindx = Board.getColumnFromLocation(Game.getTargetedSquare());
        int square = cindx + (rindx * 8);
        int squareClicked = (rowClicked * 8) + columnClicked;

        int row = rindx;
        int col = cindx;
        boolean slide = true;
          // Go left first   
        int squareNum = row * SIZE + col;
        int team = Game.getCurrentTeamsTurn();
        int r = rindx;
        int c = cindx;
                    
                    if (rindx - 1 >= MIN_ROW) {  // up
                        for (r = rindx - 1, c = cindx; r >= MIN_ROW; r--) {
                            if(slide) {
                            square = r * SIZE + c;

                            if (fPieceTypeLocationsOnBoard[r][c] != 0) {
                                slide = false;
                            }
                            if (team == 0 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                            } else if (team == 0 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveUP.add(square);
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveUP.add(square);
                            } else if (fPieceTypeLocationsOnBoard[r][c] == 0) {
                                possibleMoves.add(square);
                                moveUP.add(square);
                            
                            }else {
                                possibleMoves.add(square);
                                moveUP.add(square);
                            }
                            
                        }else {
                                break;
                            }
                        }                            
                    }

                    slide = true;
                    System.out.println("\nDOWN");
                    if (rindx + 1 <= MAX_ROW) {  // down
                        for (r = rindx + 1, c = cindx; r <= MAX_ROW; r++) {
                            if(slide) {
                            square = r * SIZE + c;
                            if (fPieceTypeLocationsOnBoard[r][c] != 0) {
                                if (fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) { //whilte's own
                                    System.out.println("6. there is a white piece on this square " + square);
                                    slide = false;
                                } else if (fPieceTypeLocationsOnBoard[r][c] > 7) {
                                    System.out.println("6. There is black piece at this square = " + square);   // black's own 
                                    slide = false;
                                }
                            }
                            if (team == 0 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {  // own piece
                                slide = false;
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                            } else if (team == 0 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveDN.add(square);
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveDN.add(square);
                            }else {
                          
                                possibleMoves.add(square);
                                moveDN.add(square);
                               
                            }

                        }else {
                                break;
                            }
                        }
                    }
                    moveDN.forEach((mv) -> {
                        System.out.println("moveDN " + mv);
                    });

                    slide = true;
                    System.out.println("\nRIGHT");
                    if (cindx + 1 <= MAX_COL) {  // right
                        for (c = cindx + 1, r = rindx; c <= MAX_COL; c++) {
                            if(slide) {
                            square = r * SIZE + c;

                            if (fPieceTypeLocationsOnBoard[r][c] != 0) {
                                if (fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                    System.out.println("7. there is a white piece on this square " + square);
                                } else if (fPieceTypeLocationsOnBoard[r][c] > 7) {
                                    System.out.println("7. There is black piece at this square = " + square);
                                }
                                slide = false;
                            }
                            if (team == 0 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                            } else if (team == 0 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveRT.add(square);
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveRT.add(square);
                            } else {
                                possibleMoves.add(square);
                                moveRT.add(square);
                               
                            }

                        }else {
                                break;
                            }
                        }
                    }

                    moveRT.forEach((mv) -> {
                        System.out.println("moveRT " + mv);
                    });

                    slide = true;
                    System.out.println("\nLEFT");
                    if (cindx - 1 >= MIN_COL) {  // left
                        for (c = cindx - 1, r = rindx; c >= MIN_COL; c--) {
                            if(slide) {
                            square = r * SIZE + c;

                            if (fPieceTypeLocationsOnBoard[r][c] != 0) {
                                if (fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                    System.out.println("8. there is a white piece on this square " + square);
                                } else if (fPieceTypeLocationsOnBoard[r][c] > 7) {
                                    System.out.println("8. There is black piece at this square = " + square);
                                }
                              slide = false;
                            }
                            if (team == 0 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                System.out.println("!first +7 white team, white square, row = " + r + ", col = " + c);
                                slide = false;
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                System.out.println("!first +7 black team, black square, row = " + r + ", col = " + c);
                                slide = false;
                            } else if (team == 0 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                System.out.println("!first +7 white team, black square, row = " + r + ", col = " + c);
                                slide = false;
                                possibleMoves.add(square);
                                moveLF.add(square);
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                System.out.println("!first + 7 black team, white sqaure, row = " + r + ", col = " + c);
                                slide = false;
                                possibleMoves.add(square);
                                moveLF.add(square);
                            } else {
                                possibleMoves.add(square);
                                moveLF.add(square);
                              
                            }

                        }else {
                                break;
                            }
                        }

                    }

                    moveLF.forEach((mv) -> {
                        System.out.println("moveLF " + mv);
                    });

                    for (int pm : possibleMoves) {
                        legalMoves.add(pm);
                    }
                    for (int lm : legalMoves) {
                        System.out.println("legal moves from range: lm = " + lm);
                        if (squareClicked == lm) {
                            System.out.println("valid moves: Match lm = " + lm);
                            System.out.println("valid moves: return true ");
                            return true;
                        }
                    }
         return false;
    }
    
    static private boolean noPieceBlocksPathToSquare(int[][] fPieceTypeLocationsOnBoard)
    {
         int rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        int columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());

                        final List<Integer> legalMoves = new ArrayList<>();
        final List<String> legalSquareStrings = new ArrayList<>();
        final List<Integer> possibleMoves = new ArrayList<>();
        final List<Integer> movePP = new ArrayList<>();
        final List<Integer> movePM = new ArrayList<>();
        final List<Integer> moveMP = new ArrayList<>();
        final List<Integer> moveMM = new ArrayList<>();
        final List<Integer> moveUP = new ArrayList<>();
        final List<Integer> moveDN = new ArrayList<>();
        final List<Integer> moveRT = new ArrayList<>();
        final List<Integer> moveLF = new ArrayList<>();
        final List<String> boardList = new ArrayList<>();

        final int SIZE = 8;
        final int MAX_ROW = 7;
        final int MIN_ROW = 0;
        final int MAX_COL = 7;
        final int MIN_COL = 0;

        int rindx = Board.getRowFromLocation(Game.getTargetedSquare());
        int cindx = Board.getColumnFromLocation(Game.getTargetedSquare());
        int square = cindx + (rindx * 8);
        int squareClicked = (rowClicked * 8) + columnClicked;

        int row = rindx;
        int col = cindx;
        boolean slide = true;
        int r = rindx;
        int c = cindx;
        slide = true;
          // Go left first   
        int squareNum = row * SIZE + col;
        int team = Game.getCurrentTeamsTurn();
                    System.out.println("\nUP");
                    if (rindx - 1 >= MIN_ROW) {  // up
                        for (r = rindx - 1, c = cindx; r >= MIN_ROW; r--) {
                            if(slide) {
                            square = r * SIZE + c;

                            if (fPieceTypeLocationsOnBoard[r][c] != 0) {
                                if (fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                    System.out.println("5. there is a white piece on this square " + square);
                                } else if (fPieceTypeLocationsOnBoard[r][c] > 7) {
                                    System.out.println("5. There is black piece at this square = " + square);
                                }
                                slide = false;
                            }
                            if (team == 0 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                            } else if (team == 0 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveUP.add(square);
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveUP.add(square);
                            } else if (fPieceTypeLocationsOnBoard[r][c] == 0) {
                                possibleMoves.add(square);
                                moveUP.add(square);
                            
                            }else {
                                possibleMoves.add(square);
                                moveUP.add(square);
                            }
                            
                        }else {
                                break;
                            }
                        }                            
                    }

                    moveUP.forEach((mv) -> {
                        System.out.println("moveUP " + mv);
                    });

                    slide = true;
                    System.out.println("\nDOWN");
                    if (rindx + 1 <= MAX_ROW) {  // down
                        for (r = rindx + 1, c = cindx; r <= MAX_ROW; r++) {
                            if(slide) {
                            square = r * SIZE + c;
                            if (fPieceTypeLocationsOnBoard[r][c] != 0) {
                                if (fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) { //whilte's own
                                    System.out.println("6. there is a white piece on this square " + square);
                                    slide = false;
                                } else if (fPieceTypeLocationsOnBoard[r][c] > 7) {
                                    System.out.println("6. There is black piece at this square = " + square);   // black's own 
                                    slide = false;
                                }
                            }
                            if (team == 0 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {  // own piece
                                slide = false;
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                            } else if (team == 0 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveDN.add(square);
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveDN.add(square);
                            }else {
                          
                                possibleMoves.add(square);
                                moveDN.add(square);
                               
                            }

                        }else {
                                break;
                            }
                        }
                    }
                    moveDN.forEach((mv) -> {
                        System.out.println("moveDN " + mv);
                    });

                    slide = true;
                    System.out.println("\nRIGHT");
                    if (cindx + 1 <= MAX_COL) {  // right
                        for (c = cindx + 1, r = rindx; c <= MAX_COL; c++) {
                            if(slide) {
                            square = r * SIZE + c;

                            if (fPieceTypeLocationsOnBoard[r][c] != 0) {
                                if (fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                    System.out.println("7. there is a white piece on this square " + square);
                                } else if (fPieceTypeLocationsOnBoard[r][c] > 7) {
                                    System.out.println("7. There is black piece at this square = " + square);
                                }
                                slide = false;
                            }
                            if (team == 0 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                            } else if (team == 0 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveRT.add(square);
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                slide = false;
                                possibleMoves.add(square);
                                moveRT.add(square);
                            } else {
                                possibleMoves.add(square);
                                moveRT.add(square);
                               
                            }

                        }else {
                                break;
                            }
                        }
                    }

                    moveRT.forEach((mv) -> {
                        System.out.println("moveRT " + mv);
                    });

                    slide = true;
                    System.out.println("\nLEFT");
                    if (cindx - 1 >= MIN_COL) {  // left
                        for (c = cindx - 1, r = rindx; c >= MIN_COL; c--) {
                            if(slide) {
                            square = r * SIZE + c;

                            if (fPieceTypeLocationsOnBoard[r][c] != 0) {
                                if (fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                    System.out.println("8. there is a white piece on this square " + square);
                                } else if (fPieceTypeLocationsOnBoard[r][c] > 7) {
                                    System.out.println("8. There is black piece at this square = " + square);
                                }
                              slide = false;
                            }
                            if (team == 0 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                System.out.println("!first +7 white team, white square, row = " + r + ", col = " + c);
                                slide = false;
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                System.out.println("!first +7 black team, black square, row = " + r + ", col = " + c);
                                slide = false;
                            } else if (team == 0 && fPieceTypeLocationsOnBoard[r][c] >= 7) {
                                System.out.println("!first +7 white team, black square, row = " + r + ", col = " + c);
                                slide = false;
                                possibleMoves.add(square);
                                moveLF.add(square);
                            } else if (team == 1 && fPieceTypeLocationsOnBoard[r][c] > 0 && fPieceTypeLocationsOnBoard[r][c] < 7) {
                                System.out.println("!first + 7 black team, white sqaure, row = " + r + ", col = " + c);
                                slide = false;
                                possibleMoves.add(square);
                                moveLF.add(square);
                            } else {
                                possibleMoves.add(square);
                                moveLF.add(square);
                              
                            }

                        }else {
                                break;
                            }
                        }

                    }

                    moveLF.forEach((mv) -> {
                        System.out.println("moveLF " + mv);
                    });

                    for (int pm : possibleMoves) {
                        legalMoves.add(pm);
                    }
                    for (int lm : legalMoves) {
                        System.out.println("legal moves from range: lm = " + lm);
                        if (squareClicked == lm) {
                            System.out.println("valid moves: Match lm = " + lm);
                            System.out.println("valid moves: return true ");
                            return true;
                        }
                    }
        return false; // just to satisfy algorithm
    }
    
    static private boolean moveDoesNotPlaceKingInCheck(int[][] fPieceTypeLocationsOnBoard)
    {
        int rowClicked = 0;
        int columnClicked = 0;
        int rowTargeted = 0;
        int columnTargeted = 0;
        int rowKing = 0;
        int columnKing = 0;
        
        int[][] tempArray = new int[8][8];
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tempArray[i][j] = fPieceTypeLocationsOnBoard[i][j];
            }
        }

        rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        // update temporary board with hypothetical move
        tempArray[rowClicked][columnClicked] = tempArray[rowTargeted][columnTargeted];
        tempArray[rowTargeted][columnTargeted] = 0;

        if (Game.getCurrentTeamsTurn() == 0){
            
            // find the white king 
            
            int whiteKing = 6;
            
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if (tempArray[i][j] == whiteKing){
                        rowKing = i;
                        columnKing = j;
                    }                    
                }
            }
          
            ///// check area for black Bishop and Queen                 
            
           int blackBishop = 10;
           int blackQueen = 11;
           
           int[] bishopRowMove = new int[4];
           int[] bishopColumnMove = new int[4];
           
           bishopRowMove[0] = 1  ; bishopColumnMove[0] = -1;
           bishopRowMove[1] = 1  ; bishopColumnMove[1] = 1;
           bishopRowMove[2] = -1 ; bishopColumnMove[2] = -1;
           bishopRowMove[3] = -1 ; bishopColumnMove[3] = 1;
           
           int nextRow = 0;
           int nextColumn = 0;
           boolean pieceInTheWay = false;
          
           for (int i = 0; i < 4; i++)
           {
               pieceInTheWay = false;
               nextRow = rowKing + bishopRowMove[i];
               nextColumn = columnKing + bishopColumnMove[i];
               
               while(pieceInTheWay == false && nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                   if (tempArray[nextRow][nextColumn] != 0){
                       if(tempArray[nextRow][nextColumn] == blackQueen || tempArray[nextRow][nextColumn] == blackBishop)
                            return false; // moveDoesNotPlaceKingInCheck
                        else
                            pieceInTheWay = true;
                   }
                   else{
                       nextRow += bishopRowMove[i];
                       nextColumn += bishopColumnMove[i];
                   }
               }
           }

           ///// check area for black Rook and Queen                 
            
           int blackRook = 8;
           
           int[] rookRowMove = new int[4];
           int[] rookColumnMove = new int[4];
           
           rookRowMove[0] = 1  ; rookColumnMove[0] = 0;
           rookRowMove[1] = -1 ; rookColumnMove[1] = 0;
           rookRowMove[2] = 0  ; rookColumnMove[2] = 1;
           rookRowMove[3] = 0  ; rookColumnMove[3] = -1;
           
           for (int i = 0; i < 4; i++)
           {
               pieceInTheWay = false;
               nextRow = rowKing + rookRowMove[i];
               nextColumn = columnKing + rookColumnMove[i];
               
               while(pieceInTheWay == false && nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                   if (tempArray[nextRow][nextColumn] != 0){
                       if(tempArray[nextRow][nextColumn] == blackQueen || tempArray[nextRow][nextColumn] == blackRook)
                            return false; // moveDoesNotPlaceKingInCheck
                        else
                            pieceInTheWay = true;
                   }
                   else{
                       nextRow += rookRowMove[i];
                       nextColumn += rookColumnMove[i];
                   }
               }
           }

           
            ///// check area for blackknight
            
            int blackKnight = 9;
            
            int[] rowKnight = new int[8];
            int[] columnKnight= new int[8];
            
            rowKnight[0]= -1  ; columnKnight[0]=2;
            rowKnight[1]= -2  ; columnKnight[1]=1;      
            rowKnight[2]= -2  ; columnKnight[2]=-1;
            rowKnight[3]= -1  ; columnKnight[3]=-2;
            rowKnight[4]= 1   ; columnKnight[4]=-2;
            rowKnight[5]= 2   ; columnKnight[5]=-1;
            rowKnight[6]= 2   ; columnKnight[6]=1;
            rowKnight[7]= 1   ; columnKnight[7]=2;
            
           for(int i = 0; i <= 7 ;i++){
               
               nextRow = rowKing + rowKnight[i];
               nextColumn = columnKing + columnKnight[i];
                
               if(nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                   if(tempArray [nextRow][nextColumn] == blackKnight)
                       return false; // moveDoesNotPlaceKingInCheck
               }          
           }               

           // check area for black pawn
           
           int blackPawn = 7;
           
           int[] rowPawn = new int[2];
           int[] columnPawn= new int[2];
            
           rowPawn[0]= -1 ; columnPawn[0] = 1;
           rowPawn[1]= -1 ; columnPawn[1] = -1;      
            
           for(int i = 0; i < 2 ;i++){
               
              nextRow = rowKing + rowPawn[i];
              nextColumn = columnKing + columnPawn[i];
              
              if(tempArray[nextRow][nextColumn] == blackPawn)
                    return false; // moveDoesNotPlaceKingInCheck
           }

        }
        
        else { // black's turn
     
            //find the black king
            
            int blackKing = 12;
            
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if (tempArray[i][j] == blackKing){
                        rowKing = i;
                        columnKing = j;
                    }                    
                }
            }

            ///// check area for white Bishop and Queen                 
            
           int whiteBishop = 4;
           int whiteQueen = 5;
           
           int[] bishopRowMove = new int[4];
           int[] bishopColumnMove = new int[4];
           
           bishopRowMove[0] = 1  ; bishopColumnMove[0] = -1;
           bishopRowMove[1] = 1  ; bishopColumnMove[1] = 1;
           bishopRowMove[2] = -1 ; bishopColumnMove[2] = -1;
           bishopRowMove[3] = -1 ; bishopColumnMove[3] = 1;
           
           int nextRow = 0;
           int nextColumn = 0;
           boolean pieceInTheWay = false;
          
           for (int i = 0; i < 4; i++)
           {
               pieceInTheWay = false;
               nextRow = rowKing + bishopRowMove[i];
               nextColumn = columnKing + bishopColumnMove[i];
               
               while(pieceInTheWay == false && nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                   if (tempArray[nextRow][nextColumn] != 0){
                       if(tempArray[nextRow][nextColumn] == whiteQueen || tempArray[nextRow][nextColumn] == whiteBishop)
                            return false; // moveDoesNotPlaceKingInCheck
                        else
                            pieceInTheWay = true;
                   }
                   else{
                       nextRow += bishopRowMove[i];
                       nextColumn += bishopColumnMove[i];
                   }
               }
           }

           ///// check area for Rook and Queen (white)                
            
           int whiteRook = 2;
           
           int[] rookRowMove = new int[4];
           int[] rookColumnMove = new int[4];
           
           rookRowMove[0] = 1  ; rookColumnMove[0] = 0;
           rookRowMove[1] = 0  ; rookColumnMove[1] = 1;
           rookRowMove[2] = -1 ; rookColumnMove[2] = 0;
           rookRowMove[3] = 0  ; rookColumnMove[3] = -1;
           
           for (int i = 0; i < 4; i++)
           {
               pieceInTheWay = false;
               nextRow = rowKing + rookRowMove[i];
               nextColumn = columnKing + rookColumnMove[i];
               
               while(pieceInTheWay == false && nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                   if (tempArray[nextRow][nextColumn] != 0){
                       if(tempArray[nextRow][nextColumn] == whiteQueen || tempArray[nextRow][nextColumn] == whiteRook)
                            return false; // moveDoesNotPlaceKingInCheck
                        else
                            pieceInTheWay = true;
                   }
                   else{
                       nextRow += rookRowMove[i];
                       nextColumn += rookColumnMove[i];
                   }
               }
           }

           ///// check area for whiteknight
            
           int whiteKnight = 3;
            
           int[] rowKnight = new int[8];
           int[] columnKnight= new int[8];
            
           rowKnight[0] = -1 ; columnKnight[0] = 2;
           rowKnight[1] = -2 ; columnKnight[1] = 1;      
           rowKnight[2] = -2 ; columnKnight[2] = -1;
           rowKnight[3] = -1 ; columnKnight[3] = -2;
           rowKnight[4] = 1  ; columnKnight[4] = -2;
           rowKnight[5] = 2  ; columnKnight[5] = -1;
           rowKnight[6] = 2  ; columnKnight[6] = 1;
           rowKnight[7] = 1  ; columnKnight[7] = 2;
           
           for(int i = 0; i <= 7; i++){
              
              nextRow = rowKing + rowKnight[i];
              nextColumn = columnKing + columnKnight[i];
              
              if(nextRow >= 0 && nextRow <= 7){
                    if(nextColumn >= 0 && nextColumn <= 7){ 
                        if(tempArray[nextRow][nextColumn] == whiteKnight)
                             return false; // moveDoesNotPlaceKingInCheck
                    }
                }          
           }

            // check area for white pawn
            
            int whitePawn = 1;
            
            int[] rowPawn = new int[2];
            int[] columnPawn= new int[2];
            
            rowPawn[0]= 1; columnPawn[0]= 1;
            rowPawn[1]= 1; columnPawn[1]= -1;      
            
            for(int i = 0; i < 2 ;i++){
                
              nextRow = rowKing + rowPawn[i];
              nextColumn = columnKing + columnPawn[i];
              
              if(tempArray[nextRow][nextColumn] == whitePawn)
                  return false; // moveDoesNotPlaceKingInCheck
           }

        }
        // moveDoesNotPlaceKingInCheck
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
}
