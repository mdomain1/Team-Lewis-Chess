package teamlewischess;

//class declaration - abstract because we will not want to create a Piece object but we would
//like to specify the private fields that all pieces should have in addition to their behaviours

/**
 * Abstract class Piece. 
 * All other piece classes are derived from this class.
 */

public abstract class Piece {
    private int location;
    private int team;    //never gets changed after initialized by constructor
    private boolean captured;
    
    /**
     * 
     * @return board location 
     */
    public int getLocation()
    {
        return location;
    }
    
    /**
     * 
     * @return  team 
     */
    public int getTeam()
    {
        return team;
    }
    
    /**
     * 
     * @return  boolean
     */    
    public boolean isCaptured()
    {
        return captured;
    }
    
    /**
     * 
     * @param fLocation sets given location
     */
    public void setLocation(int fLocation)
    {
        location = fLocation;
    }
    
    /**
     * 
     * @param fCaptured sets boolean captured 
     */
    public void setCaptured(boolean fCaptured)
    {
        captured = fCaptured;
    }
    
    /**
     * 
     * @param fLocation sets piece location 
     * @param fTeam sets piece team
     */
    public Piece(int fLocation, int fTeam) {
        location = fLocation;
        team = fTeam;
        captured = false;
    }
}
