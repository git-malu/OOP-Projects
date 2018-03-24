package shape;

import java.awt.Color;
import java.awt.Graphics;

public class ARoundRect extends AShape {
	/**
	 * new fields for RoundRect shape
	 */
	int arcWidth, arcHeight;
	
	public ARoundRect(){
		color = Color.WHITE;
		size = new int[] {100, 90};
		location = new int[] {200, 50};
		arcWidth = 30;
		arcHeight = 30;
	}
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRoundRect(location[0], location[1], size[0], size[1], 30, 30);
		
	}
}
