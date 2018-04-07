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
        //Plugged into switch statement; assigned here just for readability, to shorten the length.
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        //No break statements so that cases can fall through down to one return false statement.
        //If it is white's turn and the square the knight is trying to move to contains one
        //of white's pieces, return false, a piece does block the knight's path to that square.
        //Else if it is black's turn, do the same for black. Otherwise, return true, the knight
        //can move to an empty square or a square that contains another enemy piece.
        if (Game.getCurrentTeamsTurn() == 0) {
            switch (fPieceTypeLocationsOnBoard[rowClicked][columnClicked]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return false;
            }
        } else {
            switch (fPieceTypeLocationsOnBoard[rowClicked][columnClicked]) {
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    return false;
            }
        }
            
        return true;
    }
    
    /**
     * 
     * @param fPieceTypeLocationsOnBoard
     * @return 
     */
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
            
           for(int i = 0; i <= 1 ;i++){
               
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
    /**
     * 
     * @param fLocation
     * @param fTeam 
     */
    public Knight(int fLocation, int fTeam) {
        super(fLocation, fTeam);
    }
}
