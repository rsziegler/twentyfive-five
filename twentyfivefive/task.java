
/**
 * Write a description of class task here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
public class task
{
    // instance variables - replace the example below with your own
    private String name;
    private boolean done;
    private int dex;
    private int time;
    private int x;
    private int y;
    final static int wid = 50;
    final static int hgt = 20;

    /**
     * Constructor for objects of class task
     */
    public task(String n, int i, int t)
    {
        name = n;
        done = false;
        dex = i;
        time = t; // mins
        y = (dex)*(hgt+5);
        x = 0;
    }
    
    
    public void draw(Graphics page) {
        page.drawRect(x, y, wid, hgt);
        String data = "" + name + " " + time;
        page.drawString(data, x+5, y+15);
    }
    // getters
    public String getName()
    {
        return name;
    }
    public boolean getDone()
    {
        return done;
    }
    
    // setters
    public void setName(String n)
    {
        name = n;
    }
    public void setDone()
    {
        done = !done;
    }
    
    
}
