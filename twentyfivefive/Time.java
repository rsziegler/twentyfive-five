

public class Time
{
    private int minutes;
    private int seconds;
    /**
     * Constructor for objects of class time
     */
    public Time(int s)
    {
        updateTime(s);
    }
    public void updateTime(int s)
    {
        minutes=s/60;
        seconds=s%60;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String returnTime()
    {
        if(seconds>9){
        return minutes+":"+seconds;
    }
    else{
        return minutes+":0"+seconds;
    }
}
public int returnTimeInSeconds(){
    int a=(60*minutes)+seconds;
    return a;
}
}
