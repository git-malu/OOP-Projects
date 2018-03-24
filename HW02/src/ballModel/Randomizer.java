package ballModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;


public class Randomizer {
	private static Randomizer instance;
	private Random rnd;
	
	public Randomizer() {
		rnd = new Random();
	}
	
	public static Randomizer getInstance() {
		if(instance == null) {
            instance = new Randomizer();
        }
        return instance;
	}
	
	public double[] randomLoc(Rectangle bounds) {
//		int max_x = g.getClipBounds().width;
//		int max_y = g.getClipBounds().height;
		int max_x = (int) bounds.width;
		
		
		int max_y = (int) bounds.height;
		int x = rnd.nextInt(max_x);
		int y = rnd.nextInt(max_y);
		return new double[] {x,y};
	}
	
	public double randomDouble(int min, int max) {
		double x = rnd.nextInt(max-min+1) + min;
		return x;
	}
	
	public double[] randomVel() {
		int x = rnd.nextInt(20+1);
		int y = rnd.nextInt(20+1);
		return new double[] {x,y};
	}
	
	public Color randomColor() {
		Color color = new Color(
				(new Double(Math.random() * 128)).intValue() + 128,
				(new Double(Math.random() * 128)).intValue() + 128,
				(new Double(Math.random() * 128)).intValue() + 128);
		return color;
	}
}
