package shape;

import java.awt.Color;
import java.awt.Graphics;

public class AnArc extends AShape{
	/**
	 * new fields -- arc angles-- for start angle and end angle
	 */
	int arc1, arc2;
	
	public AnArc(){
		color = Color.ORANGE;
		size = new int[] {80, 90};
		location = new int[] {100, 50};
		arc1 = 30;
		arc2 = 90;
	}
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillArc(location[0], location[1], size[0], size[1], arc1, arc2);
	}
}
