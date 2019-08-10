
/**
 * Write a description of class task here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class task implements ActionListener
{
    // instance variables - replace the example below with your own
    private String name;
    private boolean done;
    private int dex;
    private Time time;
    private int x;
    private int y;
    final static int wid = 70;
    final static int hgt = 20;
    long remaining; 
    long lastUpdate; 
    Timer timer;
    /**
     * Constructor for objects of class task
     */
    public task(String n, int i, int t)
    {
        name = n;
        done = false;
        dex = i;
        time = new Time(t*60); // mins
        remaining=t*60000;
        y = (dex)*(hgt+5);
        x = 0;
        timer = new Timer(1000, this);
    }
    
    
    public void draw(Graphics page) {
        page.drawRect(x, y, wid, hgt);
        String data = "" + name + " " + time.returnTime();
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
    public void start(){
        resume();
    }
    public void stop(){
        pause();
    }
    public void moveup(int z){
        y = (z)*(hgt+5);
    }
    void pause() {
    long now = System.currentTimeMillis();
    remaining -= (now - lastUpdate);
    timer.stop();
    
    
}
void resume() {
    lastUpdate = System.currentTimeMillis();
    timer.start(); 
  }
  void updateDisplay() {
    long now = System.currentTimeMillis(); // current time in ms
    long elapsed = now - lastUpdate; // ms elapsed since last update
    remaining -= elapsed; // adjust remaining time
    lastUpdate = now;
    time.updateTime((int)((remaining+500)/1000));
    if(time.returnTimeInSeconds()==0){
        done=true;
    }
}
public void actionPerformed(ActionEvent e) {
    updateDisplay();
  }

}

