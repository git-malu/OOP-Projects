package ballModel;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

public class SpinBall extends Ball implements Observer{
	double angle = 0.2;
	public SpinBall(){
		velocity = new double[] {4,4};
		
	}
	
	public SpinBall (double[] p, double r, double[] v, Color c) {
		super(p, r, v, c);
		// TODO Auto-generated constructor stub
	}
	
	public void moving() {
		location[0] = location[0]+velocity[0];
		location[1] = location[1]+velocity[1];
//		BigDecimal vx = BigDecimal.valueOf(velocity[0]);
//		BigDecimal vy = BigDecimal.valueOf(velocity[1]);
//		BigDecimal ca = BigDecimal.valueOf(Math.cos(angle));
//		BigDecimal sa = BigDecimal.valueOf(Math.sin(angle));
		
//		velocity[0] = ( (vx.multiply(ca) ).multiply( vy.multiply(sa) ) ).doubleValue() ;
//		velocity[1] = ((vy.multiply(ca)).multiply(vx.multiply(sa))).doubleValue() ;
		velocity[0] = Math.round((velocity[0]*Math.cos(angle) - velocity[1]*Math.sin(angle)));
		velocity[1] = Math.round((velocity[1]*Math.cos(angle) + velocity[0]*Math.sin(angle)));

		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		moving();
		bouncing();
		paint();
	}

}