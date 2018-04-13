package teamlewischess;

/**
 * @see Piece
 */

public class Pawn extends Piece {
    private boolean promoted;
    private boolean promotedToKnight;
    private boolean promotedToBishop;
    private boolean promotedToRook;
    private boolean promotedToQueen;
    
    static public boolean isValidMove(int[][] fPieceTypeLocationsOnBoard, Team fTeam)
    {
        System.out.println("Pawn withinRange of PieceMobility: " + 
                 Pawn.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard,fTeam));
         System.out.println("noPieceBlocksPathToSquare: " + 
                 Pawn.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard,fTeam));
         System.out.println("moveDoesNotPlaceKingInCheck:  " + 
                Pawn.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard));
         
        if(Pawn.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard,fTeam)){
            if(Pawn.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard,fTeam)){
                if(Pawn.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard)){
                    return true;
                }
            }
        }       
        return false;
    }
    
    static private boolean withinRangeOfPieceMobility(int[][] fPieceTypeLocationsOnBoard, Team fTeam)
    {
        int rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        int columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        int pawn;
       
        int whitePawn = 1;      int blackPawn = 7;
        int whiteKnight = 3;    int blackKnight = 9;
        
        pawn = fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted];
        
        if (pawn != whitePawn && pawn != blackPawn){
            if (pawn != whiteKnight && pawn != blackKnight){
                // rook's cross
                if(rowTargeted == rowClicked)
                    return true;
                else if(columnTargeted == columnClicked)
                    return true;

                // bishop's diagonal
                int[] bishopRowMove = new int[4];
                int[] bishopColumnMove = new int[4];

                bishopRowMove[0] = 1  ; bishopColumnMove[0] = -1;
                bishopRowMove[1] = 1  ; bishopColumnMove[1] = 1;
                bishopRowMove[2] = -1 ; bishopColumnMove[2] = -1;
                bishopRowMove[3] = -1 ; bishopColumnMove[3] = 1;

                int nextRow = 0;
                int nextColumn = 0;

                for (int i = 0; i < 4; i++){
                    nextRow = rowTargeted + bishopRowMove[i];
                    nextColumn = columnTargeted + bishopColumnMove[i];

                    while(nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                        if(nextRow == rowClicked && nextColumn == columnClicked)
                             return true; // withinRangeofPieceMobility
                        else{
                            nextRow += bishopRowMove[i];
                            nextColumn += bishopColumnMove[i];
                        }
                    }
                }
            }
            else{ // pawn is a knight
                
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

                int nextRow;
                int nextColumn;

                for(int i = 0; i <= 7; i++){

                   nextRow = rowTargeted + rowKnight[i];
                   nextColumn = columnTargeted + columnKnight[i];

                    if( nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 &&  nextColumn <= 7){
                         if(nextRow == rowClicked && nextColumn == columnClicked){
                             return true;
                         }
                    }
                }
            }
        }
        else{ // if pawn = pawn
            
            int[] rowPawnMove = new int[4];
            int[] columnPawnMove = new int[4];

            if(Game.getCurrentTeamsTurn() == 0){

                rowPawnMove[0] = -1; columnPawnMove[0] = 1;
                rowPawnMove[1] = -1; columnPawnMove[1] = -1;
                rowPawnMove[2] = -1; columnPawnMove[2] = 0;
                rowPawnMove[3] = -2; columnPawnMove[3] = 0; // currently an unrestricted move

               if (rowTargeted == 6) {
                    for (int i = 0; i < 4; i++) {
                       
                        if (rowTargeted + rowPawnMove[i] >= 0
                                && rowTargeted + rowPawnMove[i] <= 7
                                && columnTargeted + columnPawnMove[i] >= 0
                                && columnTargeted + columnPawnMove[i] <= 7) {
                            if (rowTargeted + rowPawnMove[i] == rowClicked
                                    && columnTargeted + columnPawnMove[i] == columnClicked) {
                                return true;
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (rowTargeted + rowPawnMove[i] >= 0
                                && rowTargeted + rowPawnMove[i] <= 7
                                && columnTargeted + columnPawnMove[i] >= 0
                                && columnTargeted + columnPawnMove[i] <= 7) {
                            if (rowTargeted + rowPawnMove[i] == rowClicked
                                    && columnTargeted + columnPawnMove[i] == columnClicked) {
                                return true;
                            }
                        }
                    }
                }
            }
            else if(Game.getCurrentTeamsTurn() != 0){

                rowPawnMove[0] = 1; columnPawnMove[0] = 1;
                rowPawnMove[1] = 1; columnPawnMove[1] = -1;
                rowPawnMove[2] = 1; columnPawnMove[2] = 0;
                rowPawnMove[3] = 2; columnPawnMove[3] = 0; // currently an unrestricted move

                if (rowTargeted == 1) {
                    for (int i = 0; i < 4; i++) {
                        if ((rowTargeted + rowPawnMove[i]) >= 0 && (rowTargeted + rowPawnMove[i]) <= 7 && (columnTargeted + columnPawnMove[i]) >= 0
                                && (columnTargeted + columnPawnMove[i]) <= 7) {
                            if ((rowTargeted + rowPawnMove[i]) == rowClicked) {
                                if (columnTargeted + columnPawnMove[i] == columnClicked) {
                                    return true;
                                }
                            }
                        }
                    }
                } else if (rowTargeted > 1) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("i = " + i + ", rowTargeted = " + rowTargeted + ", rowClicked " + rowClicked);
                        System.out.println("rowPawnMove[" + i + "] = " + rowPawnMove[i]);
                        System.out.println("columnPawnMove[" + i + "]" + columnPawnMove[i]);
                        if (rowTargeted + rowPawnMove[i] >= 1// 0 
                                && rowTargeted + rowPawnMove[i] <= 7
                                && columnTargeted + columnPawnMove[i] >= 0
                                && columnTargeted + columnPawnMove[i] <= 7) {
                            if ((rowTargeted + rowPawnMove[i]) == rowClicked) {
                                if (columnTargeted + columnPawnMove[i] == columnClicked) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        // withinRangeOfPieceMobility
        return false;
    }
    
    static private boolean noPieceBlocksPathToSquare(int[][] fPieceTypeLocationsOnBoard, Team fTeam)
    {
        int rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        int columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        // compare piece colors
        if(fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] >= 1 && fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] <= 6){
            if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 1 && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 6)
                return false;
        }
        else if(fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] >= 7 && fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] <= 12){
            if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 7 && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 12)
                return false;
        }
        int pawn;
        int whitePawn = 1;      int blackPawn = 7;
        
        pawn = fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted];
        
        if (pawn != whitePawn && pawn != blackPawn){
            
            int nextRow;
            int nextColumn;
            int previousRow;
            int previousColumn;
            
            // if pawn is a rook
            if(rowTargeted == rowClicked || columnTargeted == columnClicked){

                int[] rookRowMove = new int[4];
                int[] rookColumnMove = new int[4];

                rookRowMove[0] = 1  ; rookColumnMove[0] = 0;
                rookRowMove[1] = -1 ; rookColumnMove[1] = 0;
                rookRowMove[2] = 0  ; rookColumnMove[2] = -1;
                rookRowMove[3] = 0  ; rookColumnMove[3] = 1;

                for (int i = 0; i < 4; i++){

                    nextRow = rowTargeted + rookRowMove[i];
                    nextColumn = columnTargeted + rookColumnMove[i];

                    while(nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                        if(nextRow == rowClicked && nextColumn == columnClicked){

                            previousRow = nextRow - rookRowMove[i];
                            previousColumn = nextColumn - rookColumnMove[i];

                            while(previousRow != rowTargeted && previousColumn != columnTargeted){

                                if(fPieceTypeLocationsOnBoard[previousRow][previousColumn] != 0)
                                    return false; // noPieceBlocksPathToSquare
                                else{
                                    previousRow -= rookRowMove[i];
                                    previousColumn -= rookColumnMove[i];
                                }
                            }
                            return true; // noPieceBlocksPathToSquare
                        }
                        else{
                            nextRow += rookRowMove[i];
                            nextColumn += rookColumnMove[i];
                        }
                    }
                }
            }
            else{ // pawn is a bishop
                
                int[] bishopRowMove = new int[4];
                int[] bishopColumnMove = new int[4];

                bishopRowMove[0] = 1  ; bishopColumnMove[0] = -1;
                bishopRowMove[1] = 1  ; bishopColumnMove[1] = 1;
                bishopRowMove[2] = -1 ; bishopColumnMove[2] = -1;
                bishopRowMove[3] = -1 ; bishopColumnMove[3] = 1;

                for (int i = 0; i < 4; i++){

                    nextRow = rowTargeted + bishopRowMove[i];
                    nextColumn = columnTargeted + bishopColumnMove[i];

                    while(nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                        if(nextRow == rowClicked && nextColumn == columnClicked){

                            previousRow = nextRow - bishopRowMove[i];
                            previousColumn = nextColumn - bishopColumnMove[i];

                            while(previousRow != rowTargeted && previousColumn != columnTargeted){

                                if(fPieceTypeLocationsOnBoard[previousRow][previousColumn] != 0)
                                    return false; // noPieceBlocksPathToSquare
                                else{
                                    previousRow -= bishopRowMove[i];
                                    previousColumn -= bishopColumnMove[i];
                                }
                            }
                            return true; // noPieceBlocksPathToSquare
                        }
                        else{
                            nextRow += bishopRowMove[i];
                            nextColumn += bishopColumnMove[i];
                        }
                    }
                }
            }
            // noPieceBlocksQueenPathToSquare
            return false;  
        }
        else { // pawn is a pawn
           
            int enPassantSquare = fTeam.squarePawnMovedTwoLastMovedTo;
            int[] rowPawnMove = new int[4];
            int[] columnPawnMove = new int[4];

            if(Game.getCurrentTeamsTurn() == 0){

                rowPawnMove[0] = -1; columnPawnMove[0] = 1;
                rowPawnMove[1] = -1; columnPawnMove[1] = -1;
                rowPawnMove[2] = -1; columnPawnMove[2] = 0;
                rowPawnMove[3] = -2; columnPawnMove[3] = 0; // currently an unrestricted move
                
                for(int i = 0; i < 4; i++){
                    if(rowTargeted + rowPawnMove[i] == rowClicked){
                        if (columnTargeted + columnPawnMove[i] == columnClicked) {
                            if (i == 0 || i == 1) {
                                if( fTeam.pawnMovedTwoSpacesLastMove==true) {
                                if (fPieceTypeLocationsOnBoard[rowClicked][columnClicked] == 0) {
                                    System.out.println("fTeam.pawnMovedTwoSapcesLastMove = " + fTeam.pawnMovedTwoSpacesLastMove);
                                    if (rowTargeted == 3 && fTeam.pawnMovedTwoSpacesLastMove
                                            && enPassantSquare == (rowTargeted * 8) + columnClicked) {
                                        System.out.println("enPassant true");

                                        return true;
                                    }
                                }
                                } else if ( fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 1
                                    && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 6) {
                                return false;
                            }

                        } else if(i == 2 || i == 3){
                                if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] != 0)
                                    return false;
                            }                                 
                        }
                    }
                }    
            }
            else if(Game.getCurrentTeamsTurn() != 0){

                rowPawnMove[0] = 1; columnPawnMove[0] = 1;
                rowPawnMove[1] = 1; columnPawnMove[1] = -1;
                rowPawnMove[2] = 1; columnPawnMove[2] = 0;
                rowPawnMove[3] = 2; columnPawnMove[3] = 0; // currently an unrestricted move

                for(int i = 0; i < 4; i++){
                    if(rowTargeted + rowPawnMove[i] == rowClicked){
                        if(columnTargeted + columnPawnMove[i] == columnClicked){
                            if (i == 0 || i == 1) {
                                if( fTeam.pawnMovedTwoSpacesLastMove==true) {
                                if (fPieceTypeLocationsOnBoard[rowClicked][columnClicked] == 0) {
                                    System.out.println("fTeam.pawnMovedTwoSapcesLastMove = " + fTeam.pawnMovedTwoSpacesLastMove);

                                    if (rowTargeted == 4 && fTeam.pawnMovedTwoSpacesLastMove
                                            && enPassantSquare == (rowTargeted * 8) + columnClicked) {
                                        System.out.println("enPassant true"); 
                                        return true;
                                    }
                                }
                                } else if ( fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 7
                                    && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 12) {
                                return false;
                            }
                            }

                            else if(i == 2 || i == 3){
                                if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] != 0)
                                    return false; // noPieceBlocksPathToSquare
                            }                                 
                        }
                    }
                }
            }
        }
        // noPieceBlocksPathToSquare
        return true;
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
              
               if(nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                    if(tempArray[nextRow][nextColumn] == blackPawn)
                    return false; // moveDoesNotPlaceKingInCheck
               }
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
              
              if(nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7){
                    if(tempArray[nextRow][nextColumn] == whitePawn)
                  return false; // moveDoesNotPlaceKingInCheck
              }
           }
        }
        // moveDoesNotPlaceKingInCheck
        return true;
    }
    
    public boolean promoted()
    {
        return promoted;
    }
    
    public boolean promotedToKnight()
    {
        return promotedToKnight;
    }
        
    public boolean promotedToBishop()
    {
        return promotedToBishop;
    }
    
    public boolean promotedToRook()
    {
        return promotedToRook;
    }
    
    public boolean promotedToQueen()
    {
        return promotedToQueen;
    }
    
    public void setPromoted(boolean fPromoted)
    {
        promoted = fPromoted;
    }
    
    public void setPromotedToKnight(boolean fPromotedToKnight)
    {
        promotedToKnight = fPromotedToKnight;
    }
    
    public void setPromotedToBishop(boolean fPromotedToBishop)
    {
        promotedToBishop = fPromotedToBishop;
    }
    
    public void setPromotedToRook(boolean fPromotedToRook)
    {
        promotedToRook = fPromotedToRook;
    }
    
    public void setPromotedToQueen(boolean fPromotedToQueen)
    {
        promotedToQueen = fPromotedToQueen;
    }
    
    public Pawn(int fLocation, int fTeam) {
        super(fLocation, fTeam);
        
        promoted = false;
        promotedToKnight = false;
        promotedToBishop = false;
        promotedToRook = false;
        promotedToQueen = false;
    }
}
