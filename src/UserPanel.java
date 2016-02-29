/**
 * @(#)UserPanel.java
 *
 * @author 
 * @version 1.00 2016/2/5
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//UserPanel inherits from JPanel and uses the KeyListener and ActionListener interfaces

public class UserPanel extends JPanel implements KeyListener, ActionListener
{
      
  
	 
	 private int points; //Player's points
	 

	 

   private javax.swing.Timer timer; //controls how often stats are checked
   private javax.swing.Timer enemyTimer; //controls how often enemies shoot
   
   
   private boolean start = false; 
   
   public UserPanel (int width, int height) {
   
    Color backColor=Color.black;
   
    
    
    points = 0;
    
 
   
   
  	int speed = (int)(Math.random()*10); //randomly set speed for basic enemy
	  /* change tile enemies.add(new Enemy(enemyX+=120, enemyY, enemyWidth, enemyHeight, Color.blue, speed, 10));
	  speed = (int)(Math.random()*10);
	  enemies.add(new Enemy(enemyX+=120, enemyY, enemyWidth, enemyHeight, Color.magenta, speed, 10));
	  */
	  		  	     	         
      //Status check every 5 milliseconds
      timer = new javax.swing.Timer(5, this);
     
      //Enemies shoot every 3 seconds
      enemyTimer = new javax.swing.Timer(3000, new EnemyAnimationListener());
     
      addKeyListener(this);//used for key controls
      addMouseMotionListener(new PanelMotionListener()); //used to listen to mouse events
      
      //All methods inherited from JPanel
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);      
      setBackground(backColor);
	   
	    setPreferredSize(new Dimension(width, height));

      
   }
   
    
	  public void actionPerformed (ActionEvent e){ //invoked when timer expires every 5ms
   	  	 /* checkStats();
	    	  repaint(); //ensures PaintComponent is called*/
   	  }  
  
  
  public void keyTyped(KeyEvent e) { }
  public void keyReleased(KeyEvent e) { }  
  
  public void keyPressed(KeyEvent e){
   
	    switch(e.getKeyCode())
	    {
	      case KeyEvent.VK_ENTER://actions performed if enter key is pressed
	      	timer.start();
	      	enemyTimer.start();
	      	
	      
	      	start = true;
	      		
	      	break;
	      case KeyEvent.VK_SPACE://actions performed if enter key is pressed
	      	timer.start();
	       	
	      	
	      	break;   
	      case KeyEvent.VK_ESCAPE://actions performed if escape key is pressed
	        System.exit(0);
	       
	        break;
	      default:
	      	
       }
    
   
    }

   //draws everything
    
   public void paintComponent(Graphics g){
  
      super.paintComponent(g); //a call to JPanel's paintComponent	  		   
	    	
	    int fontSize = 14;
	    g.setColor(Color.red);
	    g.setFont(new Font("Courier", Font.PLAIN, fontSize));
	  
	   
	   
	  if(!start){//shows instructions in the beginning
	  	g.drawString("Instructions: Drag the piece with the mouse", (getWidth() /2) - 100, getHeight()/2 + 20);
	  	
	  }
    
    
	 
	  
	  }
	    private class PieceAnimationListener implements ActionListener{
   
   }
    private class PanelMotionListener extends MouseMotionAdapter{//mouse dragged action that controls where slider is

      public void mouseDragged(MouseEvent e){
		//if(start==true)
         
    }
}

   private class PanelMotionListener extends MouseMotionAdapter{//mouse dragged action that controls where slider is

      public void mouseDragged(MouseEvent e){
				if(start==true) //don't allow hero to move if not started            
         myHero.move(e.getX(), myHero.getWidth());                

      }
   }
}

  
	
	   	  
	   	  
	   	 
   	  
   
 
