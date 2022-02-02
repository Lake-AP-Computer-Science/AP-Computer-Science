package problem1;

public class Signal 
{
    private String Message = "";
    private int Strength = 0;
    private int Count = 0;
	
    public Signal(String Message, int Strength) {
        this.Message = Message;
        this.Strength = Strength;
    }
    
    //Getters and setters
    public String GetMessage() {
        return this.Message;
    }
    
    public void SetMessage(String Message) {
        this.Message = Message;
    }
    
    public int GetStrength() {
        return Strength;
    }
    
    public void SetStrength(int Strength) {
        this.Strength = Strength;
    }
    
    public void SetCount(int Count)
    {
    	this.Count = Count;
    }
    
    public int GetCount()
    {
    	return Count;
    }
    
    public void IncrementCount()
    {
    	this.Count++;
    }
    
    public void DecrementCount()
    {
    	this.Count--;
    }
    
    public String toString()
    {
		return "Strength: " + Strength + " Message: " + Message;
    }
}
