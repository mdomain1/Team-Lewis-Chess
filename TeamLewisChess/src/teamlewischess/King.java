package teamlewischess;

/**
 * Description pending...
 */
public class King extends Piece {
    static public boolean hasMoved;
    
    private boolean canCastle(int[][] fPieceTypeLocationsOnBoard)
    {
        //Note: Have to make sure that the rook that the king is castling with is an original rook
        //and not a pawn promoted to a rook.
        
        //Just to satisfy program and to be updated with algorithm:
        return false;
    }
    
    public boolean isInCheck(int[][] fPieceTypeLocationsOnBoard)
    {
        return false;
    }
    
    static public boolean isValidMove(int[][] fPieceTypeLocationsOnBoard, Team fTeam)
    {
        System.out.println("King withinRange of PieceMobility: " + 
                 King.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard));
         System.out.println("noPieceBlocksPathToSquare: " + 
                 King.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard));
         //System.out.println("moveDoesNotPlaceKingInCheck:  " + 
           //      King.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard));
         
        if(King.withinRangeOfPieceMobility(fPieceTypeLocationsOnBoard)){
            if(King.noPieceBlocksPathToSquare(fPieceTypeLocationsOnBoard)){
                if(King.moveDoesNotPlaceKingInCheck(fPieceTypeLocationsOnBoard)){
                    return true;
                }
            }
        }
        return false;
    }
    
    static private boolean withinRangeOfPieceMobility(int[][] fPieceTypeLocationsOnBoard)
    {
        int[] rowKingMove = new int[8];
        int[] columnKingMove = new int[8];
        
        rowKingMove[0] = 1; columnKingMove[0] = 0;
        rowKingMove[1] = 1; columnKingMove[1] = 1;
        rowKingMove[2] = 1; columnKingMove[2] = -1;
        rowKingMove[3] = -1; columnKingMove[3] = 0;
        rowKingMove[4] = -1; columnKingMove[4] = 1;
        rowKingMove[5] = -1; columnKingMove[5] = -1;
        rowKingMove[6] = 0; columnKingMove[6] = 1;
        rowKingMove[7] = 0; columnKingMove[7] = -1;
        
        int rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        int columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        for(int i = 0; i < 8; i++){
            
            int nextRow = rowTargeted + rowKingMove[i];
            int nextColumn = columnTargeted + columnKingMove[i];
            
                if(nextRow >= 0 && nextRow <= 7 && nextColumn >= 0 && nextColumn <= 7)
                    if(nextRow == rowClicked && nextColumn == columnClicked)
                        return true;
              }        
        // withinRangeOfPieceMobility
        return false;
    }
    
    static private boolean noPieceBlocksPathToSquare(int[][] fPieceTypeLocationsOnBoard)
    {
        // Unaccounted: castling (need to check if paths are clear on long and short sides of king)
        // algorithm in the works:
        //      decide which king wants to perform castling
        
        int rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        int columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        int rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        int columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        if(fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] >= 1 && fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] <= 6){
            if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 1 && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 6)
                return false;
        }
        else if(fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] >= 7 && fPieceTypeLocationsOnBoard[rowTargeted][columnTargeted] <= 12){
            if(fPieceTypeLocationsOnBoard[rowClicked][columnClicked] >= 7 && fPieceTypeLocationsOnBoard[rowClicked][columnClicked] <= 12)
                return false;
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
        System.out.println("temp array created");
        rowTargeted = Board.getRowFromLocation(Game.getTargetedSquare());
        columnTargeted = Board.getColumnFromLocation(Game.getTargetedSquare());
        
        rowClicked = Board.getRowFromLocation(TeamLewisChessController.getSquareClicked());
        columnClicked = Board.getColumnFromLocation(TeamLewisChessController.getSquareClicked());
        
        // update temporary board with hypothetical move
        tempArray[rowClicked][columnClicked] = tempArray[rowTargeted][columnTargeted];
        tempArray[rowTargeted][columnTargeted] = 0;
        System.out.println("move made");
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
            System.out.println("white king found");
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
           System.out.println("black bishop and black queen not found");
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
           System.out.println("black rook and black queen not found");
           
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
           System.out.println("black knight not found");
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
           System.out.println("black pawn not found");
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
            System.out.println("black king found");
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
           System.out.println("white bishop and queen not found");
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
           System.out.println("white rook and queen not found");
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
           System.out.println("white knight not found");
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
            System.out.println("white pawn not found");
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
    
    public King(int fLocation, int fTeam) {
        super(fLocation, fTeam);
        
        hasMoved = false;
    }
}
