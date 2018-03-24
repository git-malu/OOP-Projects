package shape;

import java.awt.Graphics;
import java.util.ArrayList;

public class ACompositeShape extends AShape{
	ArrayList<AShape> childShapes = new ArrayList<AShape>();
	
	public void paint(Graphics g){
		for(AShape s:childShapes) {
			s.paint(g);
		}
	}
	public void add(AShape s) {
		childShapes.add(s);
	}
	
	public void remove(AShape s) {
		childShapes.remove(s);
	}
}
