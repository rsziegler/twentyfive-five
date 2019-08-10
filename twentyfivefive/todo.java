//********************************************************************
//  LineUp.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of a graphical object.
//********************************************************************

import java.util.Random;
import java.applet.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.*;

public class todo extends Applet implements ActionListener
{
    private final int APPLET_WIDTH = 400;
    private final int APPLET_HEIGHT = 150;
    ArrayList tasks;
    Button button1;
    TextField t1, t2;
    public void init ()
    {
        //setBackground(Color.black);
        tasks = new ArrayList<task>();
        setSize (APPLET_WIDTH, APPLET_HEIGHT);
        button1 = new Button("Add Task");
        add(button1);
        button1.addActionListener(this);
        t1 = new TextField(20);
        t2 = new TextField(20);
        add(t1);
        add(t2);
        t1.setText("Enter task name here");
        t2.setText("Enter task time (in min)");
    }

    public void paint (Graphics page)
    {
        task temp;
        if(tasks.size() > 0) {
            for(int i = 0; i < tasks.size(); i++) {
                temp = (task)tasks.get(i);
                if(temp.getDone()){
                    tasks.remove(i);

                    page.drawString("Beep, Beep",10,50);
                    try {
                        // pause the program for a quarter second (in ms)
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){}
                    page.drawString("Time's Up!",10,100);
                    try {
                        // pause the program for a quarter second (in ms)
                        Thread.sleep(3000);
                    }
                    catch (InterruptedException e){}
                    temp = (task)tasks.get(i);
                    temp.start();
                    temp.draw(page);
                }
                else{
                    temp.draw(page);
                }// who what lasagna
            }
        }
        String str1="";
        String str2="";
        //page.drawString("Add a new task?",10,50);
        try {
            // pause the program for a quarter second (in ms)
            Thread.sleep(250);
        }
        catch (InterruptedException e){}

        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        // TODO: add a pop up for customization

        if (e.getSource() == button1) {
            String str1="";
            String str2="";
            str1=t1.getText();
            str2=t2.getText();
            if((!str1.equals(""))&&(!str1.equals("Enter task name here"))){
                if((!str2.equals(""))&&(!str2.equals("Enter task time (in min)"))&&str2.length()<7){
                    int a=Integer.parseInt(str2);
                    tasks.add(new task(str1, tasks.size(), a));
                    
                }
                else{
                    tasks.add(new task(str1, tasks.size(), 45));
                }
            }
            else{
                if((!str2.equals(""))&&(!str2.equals("Enter task time (in min)"))&&str2.length()<7){
                    int a=Integer.parseInt(str2);
                    tasks.add(new task("Task", tasks.size(), a));
                }
                else{
                    tasks.add(new task("Task", tasks.size(), 45));
                }
            }
            if(tasks.size()==1){
                task temp=(task)tasks.get(0);
                temp.start();
            }
        }
   }
}
