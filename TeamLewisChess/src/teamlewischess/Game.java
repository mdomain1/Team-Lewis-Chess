package teamlewischess;

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
        
    }
    
    public void determineAndExeLogicAction()
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
                targetedSquare = -1;
                TeamLewisChessController.setHighlightSquareClicked(false);
                TeamLewisChessController.resetSquareAndImageVar();
            }
        }
    }
    
    private void updateCurrentTeamsTurn()
    {
        
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
    }
}
