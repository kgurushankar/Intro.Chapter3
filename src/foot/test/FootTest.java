package foot.test;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class FootTest extends JPanel
{

	private static final long serialVersionUID = 1L;
private Image shoe;

  // Constructor
  public FootTest()
  {
    shoe = (new ImageIcon("leftshoe.gif")).getImage();
  }

  // Called automatically when the panel needs repainting
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int x = 300;
    int y = 100;
    int stepLength = 100;

    Foot foot = new Foot(x, y, shoe);
    
    /*
    for (int count = 1; count <= 4; count++)
    {
    	if (count==1) {foot.turn(270);}
      foot.draw(g);
      foot.moveSideways(stepLength);
      //if (count==1) {foot.turn(90);}
    }
    */
    
    
    stepLength = 57;
    for (int count = 1; count <= 4; count++)
    {
      foot.draw(g);
      foot.turn(270);
      foot.moveSideways((-1*stepLength));
      foot.moveForward((-1*stepLength));
     }
    
    

    // Draw a cursor at the expected center of the first "shoe":
    g.drawLine(x - 50, y, x + 50, y);
    g.drawLine(x, y - 50, x, y + 50);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Feet");
    window.setBounds(100, 100, 500, 480);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    FootTest panel = new FootTest();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
  }
}