package model;

import java.awt.Color;

/**
 * @author LauraHwa
 *
 */
public class ColorStrategy implements IUpdateStrategy {

	@Override
	public void updateState(Ball ball) {
		// TODO Auto-generated method stub
		ball.setColor(new Color((new Double(Math.random() * 128)).intValue() + 128,
				(new Double(Math.random() * 128)).intValue() + 128,
				(new Double(Math.random() * 128)).intValue() + 128));
	}
}
