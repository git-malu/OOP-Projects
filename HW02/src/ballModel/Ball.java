package ballModel;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Array;
import java.util.Observable;
import java.util.Observer;

public class Ball extends AShape implements Observer{
	double radius = 20;
	double[] velocity = {5,3};
	int xEdge = 300;
	int yEdge = 400;
	public Ball(){
		
	}
	public Ball(double[] p, double r, double[] v, Color c) {
		
		location = p;
				//new double[] {p[0]-2*r,p[1]-2*r};
		radius = r;
		
		velocity = v;
		color = c;
		bouncing();
	}
	
	//view will use the paint method
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		yEdge = g.getClipBounds().height;
		xEdge = g.getClipBounds().width;
		g.setColor(color); // Set the color to use when drawing
		g.fillOval((int)location[0], (int)location[1], 2*(int)radius, 2*(int)radius);
	}
	
	public void moving() {
		location[0] = location[0]+velocity[0];
		location[1] = location[1]+velocity[1];
	}
	public void bouncing() {
		if (location[0]+2*radius>xEdge) {
			location[0] = location[0]-2*velocity[0];
			velocity[0] = -velocity[0];
		}
		
		if (location[0]<0) {
			location[0] = location[0]-2*velocity[0];
			velocity[0] = -velocity[0];
		}
		
		if (location[1]<0) {
			location[1] = location[1]-2*velocity[1];
			velocity[1] = -velocity[1];
		}
		
		if (location[1]+2*radius>yEdge) {
			location[1] = location[1]-2*velocity[1];
			velocity[1] = -velocity[1];
		}
		
	}
	
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}



}
