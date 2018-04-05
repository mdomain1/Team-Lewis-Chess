package teamlewischess;

import java.io.IOException;

/**
 * Description pending...
 */
public class Game {
    Board oneBoard = new Board();
    static private int targetedSquare;
    static private int currentTeamsTurn;
    static private int gameStatus;
    
    public void newGame()
    {
        targetedSquare = -1;
        currentTeamsTurn = 0;
        gameStatus = 0;
        oneBoard.resetBoardForNewGame();
    }
    
    public void determineAndExeLogicAction() throws IOException
    {
        if (targetedSquare == -1)
        {
            if (oneBoard.containsSelectablePiece())
            {
                targetedSquare = TeamLewisChessController.getSquareClicked();
                TeamLewisChessController.setHighlightSquareClicked(true);
            }
            
            TeamLewisChessController.resetSquareAndImageVar();
        }
        else
        {
            if (oneBoard.pieceOnTargetedSquareCanMoveToSquareClicked())
            {
                oneBoard.updateBoard();
                targetedSquare = -1;
                TeamLewisChessController.setHighlightSquareClicked(false);
                updateCurrentTeamsTurn();
            }
            else
            {
                TeamLewisChessController.setSquareToWipe(Game.getTargetedSquare()); //for de-highlighting
                targetedSquare = -1;
                TeamLewisChessController.setHighlightSquareClicked(false);
                TeamLewisChessController.resetSquareAndImageVar();
            }
        }
    }
    
    private void updateCurrentTeamsTurn()
    {
        // 0 – indicates it is white’s turn, 1 – indicates it is black’s turn
        if(currentTeamsTurn == 0){
            currentTeamsTurn = 1;
        }
        else{
            currentTeamsTurn = 0;
        }
    }
        
    static public int getTargetedSquare()
    {
        return targetedSquare;
    }
            
    static public int getCurrentTeamsTurn()
    {
        return currentTeamsTurn;
    }
                
    static public int getGameStatus()
    {
        return gameStatus;
    }
    
    static public void setGameStatus(int fGameStatus)
    {
        gameStatus = fGameStatus;
    }
    
    public Game()
    {
        targetedSquare = -1;
        currentTeamsTurn = 0;
        gameStatus = 0;
        
        //So no image is erroneously updated on the first click:
        TeamLewisChessController.setSquareMovedTo(-1);
        TeamLewisChessController.setSpecialSquareToWipe(-1);
    }
}
