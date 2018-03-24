package ballModel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class RadiusBall extends Ball implements Observer{
	double breath_time = 0;
	public RadiusBall() {
		super();
	}
	
	public RadiusBall(double[] p, double r, double[] v, Color c) {
		super(p, r, v, c);
		// TODO Auto-generated constructor stub
	}
//	public RadiusBall(Color col, int r, double[] locat){
//		//random
//		radius = r;
//		color = col;
//		location = locat;
////		int radius = rand.nextInt(50); 
////		int breath_time = 0;
//	}
	
	public void moving() {
		//location[0] = location[0]+velocity[0];
		//location[1] = location[1]+velocity[1];
		
		//calculate next ball center
		double newCenterX = location[0]+radius+velocity[0];
		double newCenterY = location[1]+radius+velocity[1];
		
		//calculate new radius, goes like sin function
		breath_time = (breath_time+0.3)%(Math.PI*2);
		radius=(int)  ((Math.sin(breath_time)+2)*10);
		
		//System.out.println(Math.sin(breath_time+0.1));
		//new paint location
		location[0] = newCenterX - radius;
		location[1] = newCenterY - radius;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		moving();
		bouncing();
		
	}
}