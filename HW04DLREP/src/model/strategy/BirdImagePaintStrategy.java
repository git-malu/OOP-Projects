package model.strategy;

import java.awt.Toolkit;

import util.Randomizer;

public class BirdImagePaintStrategy extends UprightImagePaintStrategy {
	private static String fileName1 = "../image/humbird.gif";
	private static String fileName2 = "../image/sheep.gif";

	public BirdImagePaintStrategy() {
		super(fileName1, Randomizer.getInstance().randomDouble() + 0.5);

		if (Randomizer.getInstance().randomInt(0, 5) < 3) {
			try {
				img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(fileName2));
			} catch (Exception e) {
				System.err.println("ImagePaintStrategy: Error reading file: " + fileName2 + "\n" + e);
			}
		}
	}

	public String toString() {
		return "BridImage";
	}

}
