package ballModel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class ColorBall extends Ball implements Observer{
	public ColorBall(double[] p, double r, double[] v, Color c) {
		super(p, r, v, c);
		// TODO Auto-generated constructor stub
	}

	//int radius = 20;
	//int[] location = {0,0};
	 Color[] randColor = {Color.BLUE,Color.GREEN, Color.ORANGE, Color.WHITE};
	
//	public void paint(Graphics g) {
//		
//		// TODO Auto-generated method stub
//		yEdge = g.getClipBounds().height;
//		xEdge = g.getClipBounds().width;
//		g.setColor(Color.RED); // Set the color to use when drawing
//		g.fillOval(location[0], location[1], 2*radius, 2*radius);
//	}
	
	// update state
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		moving();
		bouncing();
		color = randColor[(int)(Math.random()*4)];
		
	}
}
