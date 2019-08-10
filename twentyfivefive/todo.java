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
   public void init ()
   {
      //setBackground(Color.black);
      tasks = new ArrayList<task>();
      setSize (APPLET_WIDTH, APPLET_HEIGHT);
      button1 = new Button("Add Task");
      add(button1);
      button1.addActionListener(this);
   }
   public void paint (Graphics page)
   {
       task temp;
      if(tasks.size() > 0) {
       for(int i = 0; i < tasks.size(); i++) {
           temp = (task)tasks.get(i);
           temp.draw(page); // who what lasagna
        }
    }
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
			tasks.add(new task("Task", tasks.size(), 45));
        }
	}
}
