package walker.test;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class WalkerTest extends JPanel
{

	private static final long serialVersionUID = 1L;
	private Image left,right;

  // Constructor
  public WalkerTest()
  {
    left = (new ImageIcon("assets/leftshoe.gif")).getImage();
    right = (new ImageIcon("assets/rightshoe.gif")).getImage();
  }

  // Called automatically when the panel needs repainting
  public void paintComponent(Graphics g)
  {
	  //g.clearRect(0, 0, getWidth(), getHeight());
    super.paintComponent(g);

    int x = 300;
    int y = 100;

    Walker walker = new Walker(x,y,left,right);
    walker.draw(g);
    for (int i=0; i<10; i++)
    {
    walker.Step();
    walker.draw(g);
    }
    walker.stop();
    walker.draw(g);
    
    g.drawLine(x - 50, y, x + 50, y);
    g.drawLine(x, y - 50, x, y + 50);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Walker");
    window.setBounds(100, 100, 500, 480);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    WalkerTest panel = new WalkerTest();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
    
    
  }
}