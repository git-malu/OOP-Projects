package ballModel;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * this is an implementation of composite design pattern
 * a composite shape 'is a' AShape.
 */
public class ACompositeShape extends AShape {

	/** 
	 * new field -- ArrayList
	 * a composite shape will be made of children shapes.
	 * Example:
	 * a composite shape 'has a' triangle child
	 * a composite shape 'has a' rectangle child
	 * Thus, this composite shape look like a house
	 */
	ArrayList<AShape> childShapes = new ArrayList<AShape>();

	public void paint(Graphics g) {
		//paint all the children
		for (AShape s : childShapes) {
			s.paint(g);
		}
	}

	/**
	 * add a child
	 * @param s --- a child that will be added to the composite shape
	 */
	public void add(AShape s) {
		childShapes.add(s);
	}

	/**
	 * remove a child
	 * @param s --- a child that will be removed from the composite shape
	 */
	public void remove(AShape s) {
		childShapes.remove(s);
	}
}
