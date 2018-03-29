package teamlewischess;

//class declaration - abstract because we will not want to create a Piece object but we would
//like to specify the private fields that all pieces should have in addition to their behaviours
public abstract class Piece {
    private int location;
    private int team;    //never gets changed after initialized by constructor
    private boolean captured;
    
    public int getLocation()
    {
        return location;
    }
    
    public int getTeam()
    {
        return team;
    }
        
    public boolean isCaptured()
    {
        return captured;
    }
    
    public void setLocation(int fLocation)
    {
        location = fLocation;
    }
    
    public void setCaptured(boolean fCaptured)
    {
        captured = fCaptured;
    }
    
    public Piece(int fLocation, int fTeam) {
        location = fLocation;
        team = fTeam;
        captured = false;
    }
}
