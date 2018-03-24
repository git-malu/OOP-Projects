package ballModel;

import java.awt.Color;
import java.awt.*;

/**
 * a superclass for all kinds of shapes
 * @author malu
 *
 */
public abstract class AShape {
	/**
	 * shapes will have color, location, size.
	 * 
	 */
	Color color = Color.RED;
	int[] size = {44,44};
	double[] location = {33,99};

	// abstract method will be implemented by sub classes,that is, other specific shapes
	public abstract void paint(Graphics g);

	//setters & getters

	public void setColor(Color value) {
		this.color = value;
	}

	public Color getColor() {
		return this.color;
	}

	public void setSize(int[] value) {
		this.size = value;
	}

	public int[] getSize() {
		return this.size;
	}

	public void setLocation(double[] value) {
		this.location = value;
	}

	public double[] getLocation() {
		return this.location;
	}

}
