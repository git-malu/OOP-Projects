package ballModel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class NullBall extends Ball implements Observer{
	public NullBall(double[] p, double r, double[] v, Color c) {
		super(p, r, v, c);
		// TODO Auto-generated constructor stub
	}
	public NullBall() {
		super();
	}
	public void paint(Graphics g) {
		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
