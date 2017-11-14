package Weiqi;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grid extends JFrame{
	private JPanel p;
	private int count = 0;
	private int rad = 50;
	private int width = 1000, height = 1050;
	private int[][] legal = new int[width][height];
	
	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		for (int i = rad; i <= width; i += rad) {
			g.drawLine(rad, i, 19*rad, i);
			g.drawLine(i, 100, i, width);
		}
	}
	class MyMouseListener implements MouseListener{
		private int x, y;
		@Override
		public void mouseClicked(MouseEvent e) {
			Graphics g = getGraphics();
			if (count % 2 == 0)
				g.setColor(Color.WHITE);
			else
				g.setColor(Color.BLACK);
			
			x = (e.getX()-rad/2)/rad;
			y = (e.getY()-rad/2)/rad;
			
			if (legal[x][y] == 0) {
				g.drawOval(x*rad+rad/2, y*rad+rad/2, rad, rad);
				g.fillOval(x*rad+rad/2, y*rad+rad/2, rad, rad);
				count++;
				legal[x][y] = 1;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public Grid() {
		super("Wei Qi");
		setSize(1000,1050);
		Container c = getContentPane();
		JPanel p = new JPanel();
		Graphics g = getGraphics();
		p.paint(g);
		setVisible(true);
		c.add(p, BorderLayout.CENTER);
		MyMouseListener ml = new MyMouseListener();
		addMouseListener(ml);
	}
	
	public static void main(String[] args) {
		new Grid();
	}
}

