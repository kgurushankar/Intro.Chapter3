package pacer;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class PacerTest extends JPanel
{

	private static final long serialVersionUID = 1L;
	private Image left,right;

  // Constructor
  public PacerTest()
  {
    left = (new ImageIcon("assets/leftshoe.gif")).getImage();
    right = (new ImageIcon("assets/rightshoe.gif")).getImage();
  }

  // Called automatically when the panel needs repainting
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int x = 300;
    int y = 500; //was 100

    Pacer pacer = new Pacer(x,y,left,right);
    pacer.draw(g);
    for (int i=0; i<4; i++)
    {
    pacer.Step();
    pacer.Step();
    pacer.stop();
    pacer.turnLeft();
    pacer.draw(g);
    }
    g.drawLine(x - 50, y, x + 50, y);
    g.drawLine(x, y - 50, x, y + 50);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Pacer");
    window.setBounds(100, 100, 500, 480);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    PacerTest panel = new PacerTest();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
    
    
  }
}